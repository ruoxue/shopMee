package com.ruoyi.order.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.alipay.api.AlipayResponse;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.pay.core.client.dto.PayNotifyDataDTO;
import com.ruoyi.shop.domain.OrderPO;
import com.ruoyi.order.domain.PayChannel;
import com.ruoyi.order.service.IPayChannelService;
import com.ruoyi.pay.core.client.PayClient;
import com.ruoyi.pay.core.client.PayClientFactory;
import com.ruoyi.pay.core.client.PayCommonResult;
import com.ruoyi.pay.core.client.dto.PayOrderUnifiedReqDTO;
import com.ruoyi.pay.core.client.impl.PayClientFactoryImpl;
import com.ruoyi.pay.core.client.impl.alipay.AlipayPayClientConfig;
import com.ruoyi.system.api.RemoteOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.order.mapper.BuyerPaymentMapper;
import com.ruoyi.order.domain.BuyerPayment;
import com.ruoyi.order.service.IBuyerPaymentService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 支付Service业务层处理
 *
 * @author xiaoming
 * @date 2022-08-28
 */
@Service
public class BuyerPaymentServiceImpl implements IBuyerPaymentService {
    @Autowired
    private BuyerPaymentMapper buyerPaymentMapper;
    @Autowired
    IPayChannelService payChannelService;

    @Autowired
    private RemoteOrderService remoteOrderService;

    /**
     * 查询支付
     *
     * @param revision 支付主键
     * @return 支付
     */
    @Override
    public BuyerPayment selectBuyerPaymentByRevision(Long revision) {
        return buyerPaymentMapper.selectBuyerPaymentByRevision(revision);
    }

    /**
     * 查询支付列表
     *
     * @param buyerPayment 支付
     * @return 支付
     */
    @Override
    public List<BuyerPayment> selectBuyerPaymentList(BuyerPayment buyerPayment) {
        return buyerPaymentMapper.selectBuyerPaymentList(buyerPayment);
    }

    /**
     * 新增支付
     *
     * @param query 支付
     * @return 结果
     */

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PayCommonResult<?> insertBuyerPayment(BuyerPayment query,String ip) {
        OrderPO orderPO = remoteOrderService.getInfo(query.getOrderId(), SecurityConstants.INNER);

        orderPO.setUpdatedTime(new Date());
        orderPO.setAddressId(query.getAddressId());
        orderPO.setOrderStatus(5);
        remoteOrderService.updateBuyerPayment(orderPO, SecurityConstants.INNER);


        BigDecimal totalPrice = orderPO.getTotalPrice();


        BuyerPayment buyerPayment = new BuyerPayment();
        buyerPayment.setCreatedTime(new Date());
        buyerPayment.setPayAmount(totalPrice);
        buyerPayment.setOrderAmount(totalPrice);
        buyerPayment.setOrderId(orderPO.getOrderId());
        buyerPayment.setRevision(1L);
        buyerPaymentMapper.insertBuyerPayment(buyerPayment);
        PayClientFactory payClientFactory = new PayClientFactoryImpl();
        PayChannel payChannel = payChannelService.selectPayChannelById(query.getPayMethod());

        AlipayPayClientConfig config = new AlipayPayClientConfig();
        BeanUtils.copyProperties(payChannel, config);
        config.setServerUrl(payChannel.getGateWay());


        payClientFactory.createOrUpdatePayClient(payChannel.getId(), payChannel.getCode()
                , config);
        PayClient payClient = payClientFactory.getPayClient(payChannel.getId());

        PayOrderUnifiedReqDTO payOrderUnifiedReqDTO = new PayOrderUnifiedReqDTO();

        payOrderUnifiedReqDTO.setAmount(totalPrice.multiply(BigDecimal.valueOf(100L)).longValue());
        Date date = new Date();
        date.setTime(date.getTime() + 600 * 1000 * 60 * 24);
        payOrderUnifiedReqDTO.setExpireTime(date);
        payOrderUnifiedReqDTO.setUserIp(ip);

        payOrderUnifiedReqDTO.setMerchantOrderId(buyerPayment.getId() + "");
        payOrderUnifiedReqDTO.setAmount(orderPO.getPayablePrice().multiply(BigDecimal.valueOf(100)).longValue());
        payOrderUnifiedReqDTO.setSubject(orderPO.getSubject() );
        payOrderUnifiedReqDTO.setNotifyUrl(payChannel.getNotifyUrl()+"/"+payChannel.getId()+"/"+buyerPayment.getId());
        payOrderUnifiedReqDTO.setReturnUrl(payChannel.getReturnUrl()+"/"+payChannel.getId()+"/"+buyerPayment.getId());

        PayCommonResult<?> payCommonResult = payClient.unifiedOrder(payOrderUnifiedReqDTO);
        AlipayResponse response = ((AlipayResponse) payCommonResult.getData());
//        buyerPayment.setThirdId(response.getOutTradeNo());
        buyerPayment.setPayDesc(JSONUtil.toJsonStr(response));
        buyerPayment.setIp(ip);
        buyerPaymentMapper.updateBuyerPayment(buyerPayment);


        return payCommonResult;
    }

    /**
     * 修改支付
     *
     * @param buyerPayment 支付
     * @return 结果
     */
    @Override
    public int updateBuyerPayment(BuyerPayment buyerPayment) {
        return buyerPaymentMapper.updateBuyerPayment(buyerPayment);
    }

    /**
     * 批量删除支付
     *
     * @param revisions 需要删除的支付主键
     * @return 结果
     */
    @Override
    public int deleteBuyerPaymentByRevisions(Long[] revisions) {
        return buyerPaymentMapper.deleteBuyerPaymentByRevisions(revisions);
    }

    /**
     * 删除支付信息
     *
     * @param revision 支付主键
     * @return 结果
     */
    @Override
    public int deleteBuyerPaymentByRevision(Long revision) {
        return buyerPaymentMapper.deleteBuyerPaymentByRevision(revision);
    }

    @Override
    public OrderPO insertBuyerPaymentVirtual(String orderId, String info, Long addressId) {
        OrderPO orderPO = remoteOrderService.getInfo(orderId, SecurityConstants.INNER);
        BigDecimal totalPrice = orderPO.getTotalPrice();
        orderPO.setInfo(info);
        orderPO.setOrderStatus(10);

        orderPO.setAddressId(addressId);
        remoteOrderService.updateBuyerPayment(orderPO, SecurityConstants.INNER);

        return orderPO;
    }

    @Override
    public void payNotify(PayNotifyDataDTO payNotifyDataDTO) {

    }
}
