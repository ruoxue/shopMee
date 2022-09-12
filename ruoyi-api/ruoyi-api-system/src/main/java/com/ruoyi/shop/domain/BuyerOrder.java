package com.ruoyi.shop.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 订单对象 BUYER_ORDER
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public class BuyerOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long commitId;
    private  Long commit_id;
    private  Long formate_id;


    private Long formateId;

    private  Integer auto;
    private  String commitName;
    private  String merchantName;

    public String getCommitName() {
        return commitName;
    }

    public void setCommitName(String commitName) {
        this.commitName = commitName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Long getCommit_id() {
        return commit_id;
    }

    public void setCommit_id(Long commit_id) {
        this.commit_id = commit_id;
    }

    /** 订单ID */
    private String orderId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String userId;

    /** 购物车ID */
    @Excel(name = "购物车ID")
    private String cartId;

    /** 地址ID */
    @Excel(name = "地址ID")
    private Long addressId;

    /** 优惠券ID */
    @Excel(name = "优惠券ID")
    private String couponId;

    /** 总金额 */
    @Excel(name = "总金额")
    private BigDecimal totalPrice;

    /** 优惠金额 */
    @Excel(name = "优惠金额")
    private BigDecimal couponPrice;

    /** 应付金额 */
    @Excel(name = "应付金额")
    private BigDecimal payablePrice;

    /** 支付方式 */
    @Excel(name = "支付方式")
    private Integer payMethod;

    /** 开票设置ID */
    @Excel(name = "开票设置ID")
    private String invoiceTplId;

    /** 订单留言备注 */
    @Excel(name = "订单留言备注")
    private String leaveComment;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private Integer orderStatus;

    private String format;

    /** 乐观锁 */
    @Excel(name = "乐观锁")
    private Long revision;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createdBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    /** 更新人 */
    @Excel(name = "更新人")
    private String updatedBy;


    private  Integer type;
    private  String info;

    public Long getFormateId() {
        return formateId;
    }

    public void setFormateId(Long formateId) {
        this.formateId = formateId;
    }

    public Long getFormate_id() {
        return formate_id;
    }

    public void setFormate_id(Long formate_id) {
        this.formate_id = formate_id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedTime;

    public void setOrderId(String orderId) 
    {
        this.orderId = orderId;
    }

    public String getOrderId() 
    {
        return orderId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setCartId(String cartId) 
    {
        this.cartId = cartId;
    }

    public String getCartId() 
    {
        return cartId;
    }
    public void setAddressId(Long addressId)
    {
        this.addressId = addressId;
    }

    public Long getAddressId()
    {
        return addressId;
    }
    public void setCouponId(String couponId) 
    {
        this.couponId = couponId;
    }

    public String getCouponId() 
    {
        return couponId;
    }
    public void setTotalPrice(BigDecimal totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() 
    {
        return totalPrice;
    }
    public void setCouponPrice(BigDecimal couponPrice) 
    {
        this.couponPrice = couponPrice;
    }

    public BigDecimal getCouponPrice() 
    {
        return couponPrice;
    }
    public void setPayablePrice(BigDecimal payablePrice) 
    {
        this.payablePrice = payablePrice;
    }

    public BigDecimal getPayablePrice() 
    {
        return payablePrice;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public void setInvoiceTplId(String invoiceTplId)
    {
        this.invoiceTplId = invoiceTplId;
    }

    public String getInvoiceTplId() 
    {
        return invoiceTplId;
    }
    public void setLeaveComment(String leaveComment) 
    {
        this.leaveComment = leaveComment;
    }

    public String getLeaveComment() 
    {
        return leaveComment;
    }
    public void setOrderStatus(Integer orderStatus)
    {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderStatus()
    {
        return orderStatus;
    }
    public void setRevision(Long revision) 
    {
        this.revision = revision;
    }

    public Long getRevision() 
    {
        return revision;
    }
    public void setCreatedBy(String createdBy) 
    {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() 
    {
        return createdBy;
    }
    public void setCreatedTime(Date createdTime) 
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() 
    {
        return createdTime;
    }
    public void setUpdatedBy(String updatedBy) 
    {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedBy() 
    {
        return updatedBy;
    }
    public void setUpdatedTime(Date updatedTime) 
    {
        this.updatedTime = updatedTime;
    }

    public Date getUpdatedTime() 
    {
        return updatedTime;
    }

    public Long getCommitId() {
        return commitId;
    }

    public void setCommitId(Long commitId) {
        this.commitId = commitId;
    }

    public Integer getAuto() {
        return auto;
    }

    public void setAuto(Integer auto) {
        this.auto = auto;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("userId", getUserId())
            .append("cartId", getCartId())
            .append("addressId", getAddressId())
            .append("couponId", getCouponId())
            .append("totalPrice", getTotalPrice())
            .append("couponPrice", getCouponPrice())
            .append("payablePrice", getPayablePrice())
            .append("payMethod", getPayMethod())
            .append("invoiceTplId", getInvoiceTplId())
            .append("leaveComment", getLeaveComment())
            .append("orderStatus", getOrderStatus())
            .append("revision", getRevision())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
