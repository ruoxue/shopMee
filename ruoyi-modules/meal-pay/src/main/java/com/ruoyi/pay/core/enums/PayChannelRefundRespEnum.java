package com.ruoyi.pay.core.enums;


/**
 * 渠道统一的退款返回结果
 *
 * @author  jason
 */

public enum PayChannelRefundRespEnum {

    SUCCESS(1, "退款成功"),
    FAILURE(2, "退款失败"),
    PROCESSING(3,"退款处理中"),
    CLOSED(4, "退款关闭");

    private final Integer status;
    private final String name;

    PayChannelRefundRespEnum(Integer status, String name) {
        this.status = status;
        this.name = name;
    }
}
