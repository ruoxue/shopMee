package com.ruoyi.pay.core.client.dto;

import java.io.Serializable;
import java.util.Date;

public class AlipayNotifyDto implements Serializable {


    private Date gmt_create;
    private Date charset;
    private String subject;
    private String sign;
    private String buyer_id;
    private String body;
    private String invoice_amount;
    private String notify_id;
    private String fund_bill_list;
    private String notify_type;
    private String trade_status;
    private String receipt_amount;
    private String app_id;
    private String buyer_pay_amount;
    private String sign_type;
    private String seller_id;
    private Date gmt_payment;
    private Date notify_time;
    private String passback_params;
    private String version;
    private String out_trade_no;
    private String total_amount;
    private String trade_no;
    private String auth_app_id;
    private String point_amount;

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setCharset(Date charset) {
        this.charset = charset;
    }

    public Date getCharset() {
        return charset;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public void setBuyer_id(String buyer_id) {
        this.buyer_id = buyer_id;
    }

    public String getBuyer_id() {
        return buyer_id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setInvoice_amount(String invoice_amount) {
        this.invoice_amount = invoice_amount;
    }

    public String getInvoice_amount() {
        return invoice_amount;
    }

    public void setNotify_id(String notify_id) {
        this.notify_id = notify_id;
    }

    public String getNotify_id() {
        return notify_id;
    }

    public void setFund_bill_list(String fund_bill_list) {
        this.fund_bill_list = fund_bill_list;
    }

    public String getFund_bill_list() {
        return fund_bill_list;
    }

    public void setNotify_type(String notify_type) {
        this.notify_type = notify_type;
    }

    public String getNotify_type() {
        return notify_type;
    }

    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
    }

    public String getTrade_status() {
        return trade_status;
    }

    public void setReceipt_amount(String receipt_amount) {
        this.receipt_amount = receipt_amount;
    }

    public String getReceipt_amount() {
        return receipt_amount;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setBuyer_pay_amount(String buyer_pay_amount) {
        this.buyer_pay_amount = buyer_pay_amount;
    }

    public String getBuyer_pay_amount() {
        return buyer_pay_amount;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setGmt_payment(Date gmt_payment) {
        this.gmt_payment = gmt_payment;
    }

    public Date getGmt_payment() {
        return gmt_payment;
    }

    public void setNotify_time(Date notify_time) {
        this.notify_time = notify_time;
    }

    public Date getNotify_time() {
        return notify_time;
    }

    public void setPassback_params(String passback_params) {
        this.passback_params = passback_params;
    }

    public String getPassback_params() {
        return passback_params;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setAuth_app_id(String auth_app_id) {
        this.auth_app_id = auth_app_id;
    }

    public String getAuth_app_id() {
        return auth_app_id;
    }

    public void setPoint_amount(String point_amount) {
        this.point_amount = point_amount;
    }

    public String getPoint_amount() {
        return point_amount;
    }


}
