package com.ruoyi.mobile.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 购买明细对象 BUYER_ITEM
 * 
 * @author xiaoming
 * @date 2022-08-08
 */
public class BuyerItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单ID */
    private String orderId;

    /** 购物车ID */
    private String cartId;

    /** 明细项ID */
    private String itemId;

    /** 商品ID */
    @Excel(name = "商品ID")
    private String skuId;

    /** 商品标题 */
    @Excel(name = "商品标题")
    private String skuTitle;

    /** 商品介绍 */
    @Excel(name = "商品介绍")
    private String skuIntro;

    /** 原价 */
    @Excel(name = "原价")
    private BigDecimal price;

    /** 售价 */
    @Excel(name = "售价")
    private BigDecimal salePrice;

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
    public void setSkuId(String skuId) 
    {
        this.skuId = skuId;
    }

    public String getSkuId() 
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
    public void setSalePrice(BigDecimal salePrice) 
    {
        this.salePrice = salePrice;
    }

    public BigDecimal getSalePrice() 
    {
        return salePrice;
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
            .append("salePrice", getSalePrice())
            .append("revision", getRevision())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}