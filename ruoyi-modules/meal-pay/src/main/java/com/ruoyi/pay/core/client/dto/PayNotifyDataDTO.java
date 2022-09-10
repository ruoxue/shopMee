package com.ruoyi.pay.core.client.dto;


import java.util.Map;


/**
 * 支付订单，退款订单回调，渠道的统一通知请求数据
 */

public class PayNotifyDataDTO {


    /**
     *  HTTP 回调接口的 request body
     */
    private String body;


    /**
     * HTTP 回调接口 content type 为 application/x-www-form-urlencoded 的所有参数
     */
    private Map<String,String> params;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
