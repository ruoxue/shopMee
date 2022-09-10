//package com.ruoyi.mobile.domain;
//
//import java.math.BigDecimal;
//import java.util.Date;
//import com.fasterxml.jackson.annotation.JsonFormat;
//import org.apache.commons.lang3.builder.ToStringBuilder;
//import org.apache.commons.lang3.builder.ToStringStyle;
//import com.ruoyi.common.core.annotation.Excel;
//import com.ruoyi.common.core.web.domain.BaseEntity;
//
///**
// * 订单对象 BUYER_ORDER
// *
// * @author xiaoming
// * @date 2022-08-08
// */
//public class BuyerOrder extends BaseEntity
//{
//    private static final long serialVersionUID = 1L;
//
//    /** 订单ID */
//    private String orderId;
//
//    /** 用户ID */
//    @Excel(name = "用户ID")
//    private String userId;
//
//    /** 购物车ID */
//    @Excel(name = "购物车ID")
//    private String cartId;
//
//    /** 地址ID */
//    @Excel(name = "地址ID")
//    private String addressId;
//
//    /** 优惠券ID */
//    @Excel(name = "优惠券ID")
//    private String couponId;
//
//    /** 总金额 */
//    @Excel(name = "总金额")
//    private BigDecimal totalPrice;
//
//    /** 优惠金额 */
//    @Excel(name = "优惠金额")
//    private BigDecimal couponPrice;
//
//    /** 应付金额 */
//    @Excel(name = "应付金额")
//    private BigDecimal payablePrice;
//
//    /** 支付方式 */
//    @Excel(name = "支付方式")
//    private Integer payMethod;
//
//    /** 开票设置ID */
//    @Excel(name = "开票设置ID")
//    private String invoiceTplId;
//
//    /** 订单留言备注 */
//    @Excel(name = "订单留言备注")
//    private String leaveComment;
//
//    /** 订单状态 */
//    @Excel(name = "订单状态")
//    private String orderStatus;
//
//    /** 乐观锁 */
//    @Excel(name = "乐观锁")
//    private Long revision;
//
//    /** 创建人 */
//    @Excel(name = "创建人")
//    private String createdBy;
//
//    /** 创建时间 */
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
//    private Date createdTime;
//
//    /** 更新人 */
//    @Excel(name = "更新人")
//    private String updatedBy;
//    private  String type;
//    private String info;
//
//    /** 更新时间 */
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
//    private Date updatedTime;
//
//    public void setOrderId(String orderId)
//    {
//        this.orderId = orderId;
//    }
//
//    public String getOrderId()
//    {
//        return orderId;
//    }
//    public void setUserId(String userId)
//    {
//        this.userId = userId;
//    }
//
//    public String getUserId()
//    {
//        return userId;
//    }
//    public void setCartId(String cartId)
//    {
//        this.cartId = cartId;
//    }
//
//    public String getCartId()
//    {
//        return cartId;
//    }
//    public void setAddressId(String addressId)
//    {
//        this.addressId = addressId;
//    }
//
//    public String getAddressId()
//    {
//        return addressId;
//    }
//    public void setCouponId(String couponId)
//    {
//        this.couponId = couponId;
//    }
//
//    public String getCouponId()
//    {
//        return couponId;
//    }
//    public void setTotalPrice(BigDecimal totalPrice)
//    {
//        this.totalPrice = totalPrice;
//    }
//
//    public BigDecimal getTotalPrice()
//    {
//        return totalPrice;
//    }
//    public void setCouponPrice(BigDecimal couponPrice)
//    {
//        this.couponPrice = couponPrice;
//    }
//
//    public BigDecimal getCouponPrice()
//    {
//        return couponPrice;
//    }
//    public void setPayablePrice(BigDecimal payablePrice)
//    {
//        this.payablePrice = payablePrice;
//    }
//
//    public BigDecimal getPayablePrice()
//    {
//        return payablePrice;
//    }
//
//    public Integer getPayMethod() {
//        return payMethod;
//    }
//
//    public void setPayMethod(Integer payMethod) {
//        this.payMethod = payMethod;
//    }
//
//    public void setInvoiceTplId(String invoiceTplId)
//    {
//        this.invoiceTplId = invoiceTplId;
//    }
//
//    public String getInvoiceTplId()
//    {
//        return invoiceTplId;
//    }
//    public void setLeaveComment(String leaveComment)
//    {
//        this.leaveComment = leaveComment;
//    }
//
//    public String getLeaveComment()
//    {
//        return leaveComment;
//    }
//    public void setOrderStatus(String orderStatus)
//    {
//        this.orderStatus = orderStatus;
//    }
//
//    public String getOrderStatus()
//    {
//        return orderStatus;
//    }
//    public void setRevision(Long revision)
//    {
//        this.revision = revision;
//    }
//
//    public Long getRevision()
//    {
//        return revision;
//    }
//    public void setCreatedBy(String createdBy)
//    {
//        this.createdBy = createdBy;
//    }
//
//    public String getCreatedBy()
//    {
//        return createdBy;
//    }
//    public void setCreatedTime(Date createdTime)
//    {
//        this.createdTime = createdTime;
//    }
//
//    public Date getCreatedTime()
//    {
//        return createdTime;
//    }
//    public void setUpdatedBy(String updatedBy)
//    {
//        this.updatedBy = updatedBy;
//    }
//
//    public String getUpdatedBy()
//    {
//        return updatedBy;
//    }
//    public void setUpdatedTime(Date updatedTime)
//    {
//        this.updatedTime = updatedTime;
//    }
//
//    public Date getUpdatedTime()
//    {
//        return updatedTime;
//    }
//
//    @Override
//    public String toString() {
//        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
//            .append("orderId", getOrderId())
//            .append("userId", getUserId())
//            .append("cartId", getCartId())
//            .append("addressId", getAddressId())
//            .append("couponId", getCouponId())
//            .append("totalPrice", getTotalPrice())
//            .append("couponPrice", getCouponPrice())
//            .append("payablePrice", getPayablePrice())
//            .append("payMethod", getPayMethod())
//            .append("invoiceTplId", getInvoiceTplId())
//            .append("leaveComment", getLeaveComment())
//            .append("orderStatus", getOrderStatus())
//            .append("revision", getRevision())
//            .append("createdBy", getCreatedBy())
//            .append("createdTime", getCreatedTime())
//            .append("updatedBy", getUpdatedBy())
//            .append("updatedTime", getUpdatedTime())
//            .toString();
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getInfo() {
//        return info;
//    }
//
//    public void setInfo(String info) {
//        this.info = info;
//    }
//}
