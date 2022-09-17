package com.ruoyi.pay.core.client.dto;


import java.util.Date;

/**
 * 支付通知 Response DTO
 *
 * @author 芋道源码
 */

public class PayOrderNotifyRespDTO {

    /**
     * 支付订单号（支付模块的）
     */
    private String orderExtensionNo;
    /**
     * 支付渠道编号
     */
    private String channelOrderNo;
    /**
     * 支付渠道用户编号
     */
    private String channelUserId;
    /**
     * 支付成功时间
     */
    private Date successTime;



    /**
     * TODO @jason 结合其他的渠道定义成枚举,
     * alipay
     * TRADE_CLOSED,未付款交易超时关闭，或支付完成后全额退款。
     * TRADE_SUCCESS, 交易支付成功
     * TRADE_FINISHED 	交易结束，不可退款。
     */
    private String tradeStatus;

    public static PayOrderNotifyRespDTO builder() {
        return new PayOrderNotifyRespDTO();
    }

    public String getOrderExtensionNo() {
        return orderExtensionNo;
    }

    public PayOrderNotifyRespDTO setOrderExtensionNo(String orderExtensionNo) {
        this.orderExtensionNo = orderExtensionNo;
        return this;
    }

    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    public PayOrderNotifyRespDTO setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo;
        return  this;
    }

    public String getChannelUserId() {
        return channelUserId;
    }

    public PayOrderNotifyRespDTO setChannelUserId(String channelUserId) {
        this.channelUserId = channelUserId;
        return  this;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public PayOrderNotifyRespDTO setSuccessTime(Date successTime) {
        this.successTime = successTime;
        return  this;
    }



    public String getTradeStatus() {
        return tradeStatus;
    }

    public PayOrderNotifyRespDTO setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
        return this;
    }

    public PayOrderNotifyRespDTO build() {
        return this;
    }
}
