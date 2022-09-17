package com.ruoyi.order.service.impl;

import cn.hutool.json.JSONUtil;
import com.alipay.api.AlipayResponse;
import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.order.domain.BuyerItem;
import com.ruoyi.order.domain.BuyerPayment;
import com.ruoyi.order.domain.PayChannel;
import com.ruoyi.order.mapper.BuyerItemMapper;
import com.ruoyi.order.mapper.BuyerPaymentMapper;
import com.ruoyi.order.service.IBuyerPaymentService;
import com.ruoyi.order.service.IPayChannelService;
import com.ruoyi.pay.core.client.PayClient;
import com.ruoyi.pay.core.client.PayClientFactory;
import com.ruoyi.pay.core.client.PayCommonResult;
import com.ruoyi.pay.core.client.dto.PayNotifyDataDTO;
import com.ruoyi.pay.core.client.dto.PayOrderNotifyRespDTO;
import com.ruoyi.pay.core.client.dto.PayOrderUnifiedReqDTO;
import com.ruoyi.pay.core.client.impl.alipay.AlipayPayClientConfig;
import com.ruoyi.pay.core.enums.PayNotifyRefundStatusEnum;

import com.ruoyi.shop.domain.OrderPO;
import com.ruoyi.shop.domain.ProductSku;
import com.ruoyi.system.api.RemoteOrderService;
import com.ruoyi.system.api.RemoteProductSkuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    BuyerItemMapper buyerItemMapper;
    @Autowired
    IPayChannelService payChannelService;

    @Autowired
    PayClientFactory payClientFactory;


    @Autowired
    RemoteProductSkuService skuService;


    @Autowired
    private RemoteOrderService remoteOrderService;

    /**
     * 查询支付
     *
     * @param revision 支付主键
     * @return 支付
     */
    @Override
    public BuyerPayment selectBuyerPaymentById(Long revision) {
        return buyerPaymentMapper.selectBuyerPaymentById(revision);
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
    public PayCommonResult<?> insertBuyerPayment(BuyerPayment query, String ip) {
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
        payOrderUnifiedReqDTO.setSubject(orderPO.getSubject());
        payOrderUnifiedReqDTO.setNotifyUrl(payChannel.getNotifyUrl() + "/" + payChannel.getId() + "/" + buyerPayment.getId());
        payOrderUnifiedReqDTO.setReturnUrl(payChannel.getReturnUrl() + "/" + payChannel.getId() + "/" + buyerPayment.getId());

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
        return buyerPaymentMapper.deleteBuyerPaymentById(revisions);
    }

    /**
     * 删除支付信息
     *
     * @param id 支付主键
     * @return 结果
     */
    @Override
    public int deleteBuyerPaymentByRevision(Long id) {
        return buyerPaymentMapper.deleteBuyerPaymentById(id);
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
    @Transactional(rollbackFor = Exception.class)
    public int payNotify(PayNotifyDataDTO payNotifyDataDTO, PayChannel payChannel) {


        AlipayPayClientConfig config = new AlipayPayClientConfig();
        BeanUtils.copyProperties(payChannel, config);
        config.setServerUrl(payChannel.getGateWay());


        payClientFactory.createOrUpdatePayClient(payChannel.getId(),
                payChannel.getCode()
                , config);
        PayClient client = payClientFactory.getPayClient(payChannel.getId());
        boolean b = client.verifyNotifyData(payNotifyDataDTO);
        if (b) {

            try {
                PayOrderNotifyRespDTO payOrderNotifyRespDTO = client.parseOrderNotify(payNotifyDataDTO);

                String orderExtensionNo = payOrderNotifyRespDTO.getOrderExtensionNo();

                long paySeq = Long.parseLong(orderExtensionNo);
                BuyerPayment buyerPayment = buyerPaymentMapper.selectBuyerPaymentById(paySeq);

                if (buyerPayment.getStatus() >= 10) {
                    return 0;
                }

                if (!PayNotifyRefundStatusEnum.TRADE_SUCCESS.toString().equals(payOrderNotifyRespDTO.getTradeStatus())) {
                    return 0;
                }
                buyerPayment.setStatus(10L);
                buyerPayment.setUpdatedTime(new Date());
                buyerPayment.setThirdSn(payOrderNotifyRespDTO.getChannelOrderNo());
                buyerPayment.setThirdId(payOrderNotifyRespDTO.getChannelOrderNo());

                OrderPO info = remoteOrderService.getInfo(buyerPayment.getOrderId(), SecurityConstants.INNER);
                info.setOrderStatus(10);

                info.setUpdatedTime(new Date());
                remoteOrderService.updateBuyerPayment(info, SecurityConstants.INNER);
                buyerPaymentMapper.updateBuyerPayment(buyerPayment);
                BuyerItem buyerItemQuery = new BuyerItem();
                buyerItemQuery.setOrderId(buyerPayment.getOrderId());
                List<BuyerItem> buyerItems = buyerItemMapper.selectBuyerItemList(buyerItemQuery);
                for (int i = 0; i < buyerItems.size(); i++) {

                    BuyerItem buyerItem = buyerItems.get(i);
                    BigDecimal price = buyerItem.getPrice();

                    ProductSku sku = skuService.getInfo(buyerItem.getSkuId(), SecurityConstants.INNER);


                    Long shopId = sku.getShopId();
                    Map<String, String> param = new HashMap<>();
                    param.put("amount", String.valueOf(price));
                    param.put("shopId", String.valueOf(shopId));

                    int i1 = buyerPaymentMapper.updateShopAmount(param);


                }
                return 1;

            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        } else {


        }
        return 0;
    }
}
