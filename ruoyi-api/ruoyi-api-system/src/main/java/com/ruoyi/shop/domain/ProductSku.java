package com.ruoyi.shop.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 商品规格信息对象 product_sku
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public class ProductSku extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键ID */
    private String id;

    /** 店铺ID */
    @Excel(name = "店铺ID")
    private Long shopId;

    /** 商品ID */
    @Excel(name = "商品ID")
    private String goodsId;

    /** 规格名称 */
    @Excel(name = "规格名称")
    private String title;

    /** 规格图片链接 */
    @Excel(name = "规格图片链接")
    private String thumb;

    /** 售卖价格 */
    @Excel(name = "售卖价格")
    private BigDecimal price;

    /** 成本价 */
    @Excel(name = "成本价")
    private BigDecimal costPrice;

    /** 划线价格 */
    @Excel(name = "划线价格")
    private BigDecimal originalPrice;

    /** 商品编码 格式:XXXX-YYYYYYYY-ZZ */
    @Excel(name = "商品编码 格式:XXXX-YYYYYYYY-ZZ")
    private String productCode;

    /** 商品条形码 */
    @Excel(name = "商品条形码")
    private String productSn;

    /** 库存 */
    @Excel(name = "库存")
    private String stock;

    /** 库存预警 */
    @Excel(name = "库存预警")
    private Long stockWarning;

    /** 销量 */
    @Excel(name = "销量")
    private Long salesCount;

    /** 重量(千克) */
    @Excel(name = "重量(千克)")
    private String weight;

    /** 体积(m³) */
    @Excel(name = "体积(m³)")
    private String volume;

    /** 规格项id 多个值逗号分割 关联product_spec_option表主键ID */
    @Excel(name = "规格项id 多个值逗号分割 关联product_spec_option表主键ID")
    private String specOptionIds;

    /** 展示顺序 越小越靠前 */
    @Excel(name = "展示顺序 越小越靠前")
    private Long displayOrder;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setShopId(Long shopId) 
    {
        this.shopId = shopId;
    }

    public Long getShopId() 
    {
        return shopId;
    }
    public void setGoodsId(String goodsId) 
    {
        this.goodsId = goodsId;
    }

    public String getGoodsId() 
    {
        return goodsId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setThumb(String thumb) 
    {
        this.thumb = thumb;
    }

    public String getThumb() 
    {
        return thumb;
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
    public void setOriginalPrice(BigDecimal originalPrice) 
    {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getOriginalPrice() 
    {
        return originalPrice;
    }
    public void setProductCode(String productCode) 
    {
        this.productCode = productCode;
    }

    public String getProductCode() 
    {
        return productCode;
    }
    public void setProductSn(String productSn) 
    {
        this.productSn = productSn;
    }

    public String getProductSn() 
    {
        return productSn;
    }
    public void setStock(String stock) 
    {
        this.stock = stock;
    }

    public String getStock() 
    {
        return stock;
    }
    public void setStockWarning(Long stockWarning) 
    {
        this.stockWarning = stockWarning;
    }

    public Long getStockWarning() 
    {
        return stockWarning;
    }
    public void setSalesCount(Long salesCount) 
    {
        this.salesCount = salesCount;
    }

    public Long getSalesCount() 
    {
        return salesCount;
    }
    public void setWeight(String weight) 
    {
        this.weight = weight;
    }

    public String getWeight() 
    {
        return weight;
    }
    public void setVolume(String volume) 
    {
        this.volume = volume;
    }

    public String getVolume() 
    {
        return volume;
    }
    public void setSpecOptionIds(String specOptionIds) 
    {
        this.specOptionIds = specOptionIds;
    }

    public String getSpecOptionIds() 
    {
        return specOptionIds;
    }
    public void setDisplayOrder(Long displayOrder) 
    {
        this.displayOrder = displayOrder;
    }

    public Long getDisplayOrder() 
    {
        return displayOrder;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shopId", getShopId())
            .append("goodsId", getGoodsId())
            .append("title", getTitle())
            .append("thumb", getThumb())
            .append("price", getPrice())
            .append("costPrice", getCostPrice())
            .append("originalPrice", getOriginalPrice())
            .append("productCode", getProductCode())
            .append("productSn", getProductSn())
            .append("stock", getStock())
            .append("stockWarning", getStockWarning())
            .append("salesCount", getSalesCount())
            .append("weight", getWeight())
            .append("volume", getVolume())
            .append("specOptionIds", getSpecOptionIds())
            .append("displayOrder", getDisplayOrder())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
