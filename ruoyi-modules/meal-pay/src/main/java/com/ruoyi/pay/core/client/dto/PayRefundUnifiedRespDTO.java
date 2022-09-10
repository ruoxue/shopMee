package com.ruoyi.pay.core.client.dto;

/**
 * 统一退款 Response DTO
 *
 * @author jason
 */

public class PayRefundUnifiedRespDTO {

    /**
     * 渠道退款单编号
     */
    private String channelRefundId;

    public String getChannelRefundId() {
        return channelRefundId;
    }

    public void setChannelRefundId(String channelRefundId) {
        this.channelRefundId = channelRefundId;
    }
}
