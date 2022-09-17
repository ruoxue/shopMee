package com.ruoyi.shop.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 购买明细对象 BUYER_ITEM
 * 
 * @author xiaoming
 * @date 2022-08-18
 */
public class BuyerItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单ID */
    private String orderId;
    private  String virtualInfo;


    /** 购物车ID */
    private String cartId;

    /** 明细项ID */
    private String itemId;

    /** 商品ID */
    @Excel(name = "商品ID")
    private Long skuId;

    /** 商品标题 */
    @Excel(name = "商品标题")
    private String skuTitle;

    /** 商品介绍 */
    @Excel(name = "商品介绍")
    private String skuIntro;

    /** 售卖价格 */
    @Excel(name = "售卖价格")
    private BigDecimal price;

    /** 成本价 */
    @Excel(name = "成本价")
    private BigDecimal costPrice;

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

    private  String thumb;
    private  String productSn;
    private  String productCode;


    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedTime;

    /** 划线价格 */
    @Excel(name = "划线价格")
    private BigDecimal originalPrice;

    public void setOrderId(String orderId) 
    {
        this.orderId = orderId;
    }

    public String getOrderId() 
    {
        return orderId;
    }
    public void setCartId(String cartId) 
    {
        this.cartId = cartId;
    }

    public String getCartId() 
    {
        return cartId;
    }
    public void setItemId(String itemId) 
    {
        this.itemId = itemId;
    }

    public String getItemId() 
    {
        return itemId;
    }
    public void setSkuId(Long skuId)
    {
        this.skuId = skuId;
    }

    public Long getSkuId()
    {
        return skuId;
    }
    public void setSkuTitle(String skuTitle) 
    {
        this.skuTitle = skuTitle;
    }

    public String getSkuTitle() 
    {
        return skuTitle;
    }
    public void setSkuIntro(String skuIntro) 
    {
        this.skuIntro = skuIntro;
    }

    public String getSkuIntro() 
    {
        return skuIntro;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setCostPrice(BigDecimal costPrice) 
    {
        this.costPrice = costPrice;
    }

    public BigDecimal getCostPrice() 
    {
        return costPrice;
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
    public void setOriginalPrice(BigDecimal originalPrice) 
    {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getOriginalPrice() 
    {
        return originalPrice;
    }

    public String getVirtualInfo() {
        return virtualInfo;
    }

    public void setVirtualInfo(String virtualInfo) {
        this.virtualInfo = virtualInfo;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("cartId", getCartId())
            .append("itemId", getItemId())
            .append("skuId", getSkuId())
            .append("skuTitle", getSkuTitle())
            .append("skuIntro", getSkuIntro())
            .append("price", getPrice())
            .append("costPrice", getCostPrice())
            .append("revision", getRevision())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .append("originalPrice", getOriginalPrice())
            .toString();
    }
}
