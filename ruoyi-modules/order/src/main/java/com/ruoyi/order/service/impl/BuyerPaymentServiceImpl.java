package com.ruoyi.order.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.constant.SecurityConstants;
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
    public PayCommonResult<?> insertBuyerPayment(BuyerPayment query) {
        OrderPO orderPO = remoteOrderService.getInfo(query.getOrderId(), SecurityConstants.INNER);
        BigDecimal totalPrice = orderPO.getTotalPrice();


        BuyerPayment buyerPayment = new BuyerPayment();
        buyerPayment.setCreatedTime(new Date());
        buyerPayment.setPayAmount(totalPrice);
        buyerPayment.setOrderAmount(totalPrice);
        buyerPayment.setOrderId(orderPO.getOrderId());
        buyerPayment.setRevision(1L);
        PayClientFactory payClientFactory = new PayClientFactoryImpl();
        PayChannel payChannel = payChannelService.selectPayChannelById(query.getPayMethod());

        AlipayPayClientConfig alipayPayClientConfig = new AlipayPayClientConfig();
        BeanUtils.copyProperties(payChannel, alipayPayClientConfig);
        payClientFactory.createOrUpdatePayClient(payChannel.getId(), payChannel.getCode()
                , alipayPayClientConfig);
        PayClient payClient = payClientFactory.getPayClient(payChannel.getId());

        PayOrderUnifiedReqDTO payOrderUnifiedReqDTO = new PayOrderUnifiedReqDTO();

        payOrderUnifiedReqDTO.setAmount(totalPrice.multiply(BigDecimal.valueOf(100L)).longValue());
        payOrderUnifiedReqDTO.setExpireTime(new Date());
        payOrderUnifiedReqDTO.setUserIp("127.0.0.1");
        payOrderUnifiedReqDTO.setSubject("");
        payOrderUnifiedReqDTO.setMerchantOrderId(buyerPayment.getOrderId());

        PayCommonResult<?> payCommonResult = payClient.unifiedOrder(payOrderUnifiedReqDTO);
        buyerPaymentMapper.insertBuyerPayment(buyerPayment);


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
    public OrderPO insertBuyerPaymentVirtual(String orderId, String info) {
        OrderPO orderPO = remoteOrderService.getInfo(orderId, SecurityConstants.INNER);
        BigDecimal totalPrice = orderPO.getTotalPrice();
        orderPO.setInfo(info);
        orderPO.setOrderStatus(10);
        remoteOrderService.updateBuyerPayment(orderPO, SecurityConstants.INNER);

        return orderPO;
    }
}
