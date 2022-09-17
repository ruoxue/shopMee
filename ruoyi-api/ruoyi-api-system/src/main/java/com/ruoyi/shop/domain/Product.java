package com.ruoyi.shop.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 商品基础信息对象 product
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public class Product extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private  Integer auto;
    private Long id;

    /** 店铺ID */
    @Excel(name = "店铺ID")
    private Long shopId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long displayOrder;

    /** 商品类型 1:实物 2:虚拟商品 3:电子卡密 */
    @Excel(name = "商品类型 1:实物 2:虚拟商品 3:电子卡密")
    private Integer type;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 副标题 */
    @Excel(name = "副标题")
    private String subTitle;

    /** 短标题 */
    @Excel(name = "短标题")
    private String shortTitle;

    /** 商品状态 0:放置仓库 1:上架售卖 2:上架隐藏 3:定时上架 -1:后台删除 */
    @Excel(name = "商品状态 0:放置仓库 1:上架售卖 2:上架隐藏 3:定时上架 -1:后台删除")
    private Integer status;
    private Long formateId;

    /** 上架时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上架时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date putawayTime;

    /** 首图视频 */
    @Excel(name = "首图视频")
    private String video;

    /** 视频封面图 */
    @Excel(name = "视频封面图")
    private String videoThumb;

    /** 商品主图 */
    @Excel(name = "商品主图")
    private String thumb;

    /** 商品轮播图 */
    @Excel(name = "商品轮播图")
    private String thumbs;

    /** 售卖价格 */
    @Excel(name = "售卖价格")
    private BigDecimal price;

    /** 划线价格 */
    @Excel(name = "划线价格")
    private BigDecimal originalPrice;

    /** 成本价 */
    @Excel(name = "成本价")
    private BigDecimal costPrice;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer priceHide;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal minPrice;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal maxPrice;

    /** 规格类型 1:多规格商品 0:无规格 */
    @Excel(name = "规格类型 1:多规格商品 0:无规格")
    private Integer hasOption;

    /** 商品编码 格式:XXXX-YYYYYYYY-ZZ */
    @Excel(name = "商品编码 格式:XXXX-YYYYYYYY-ZZ")
    private String productCode;

    /** 商品条形码 */
    @Excel(name = "商品条形码")
    private String productSn;

    /** 商品库存 */
    @Excel(name = "商品库存")
    private Long stock;

    /** 库存预警 */
    @Excel(name = "库存预警")
    private Long stockWarning;

    /** 商品详情隐藏库存 1:隐藏 0:不隐藏 */
    @Excel(name = "商品详情隐藏库存 1:隐藏 0:不隐藏")
    private Integer stockHide;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long stockCnf;

    /** 销量 */
    @Excel(name = "销量")
    private Long salesCount;

    /** 商品详情隐藏销量 1:隐藏 0:不隐藏 */
    @Excel(name = "商品详情隐藏销量 1:隐藏 0:不隐藏")
    private Integer salesHide;

    /** 已出售数 */
    @Excel(name = "已出售数")
    private Long virtualSales;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 重量(千克) */
    @Excel(name = "重量(千克)")
    private String weight;

    /** 体积(m³) */
    @Excel(name = "体积(m³)")
    private String volume;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer autoComplete;

    /** 快递运费类型 0:运费模板 1:统一运费 */
    @Excel(name = "快递运费类型 0:运费模板 1:统一运费")
    private Integer dispatchType;

    /** 运费价格 */
    @Excel(name = "运费价格")
    private BigDecimal dispatchPrice;

    /** 运费模板ID 关联es_shop_dispatch表id */
    @Excel(name = "运费模板ID 关联es_shop_dispatch表id")
    private Long dispatchId;

    /** 物流支持 1:快递 2:同城配送 3:上门自提 */
    @Excel(name = "物流支持 1:快递 2:同城配送 3:上门自提")
    private String dispatchMode;

    /** 默认物流支持 */
    @Excel(name = "默认物流支持")
    private String defaultDispatchMode;

    /** 商品详情隐藏快递 1:隐藏 0:不隐藏 */
    @Excel(name = "商品详情隐藏快递 1:隐藏 0:不隐藏")
    private Integer dispatchHide;

    /** 是否开启限购 1:限购 0:不限购 */
    @Excel(name = "是否开启限购 1:限购 0:不限购")
    private Integer isBuyNumLimit;

    /** 每人限购数量上限 */
    @Excel(name = "每人限购数量上限")
    private Long maxBuyTotal;

    /** 单次下单购买限购数量 */
    @Excel(name = "单次下单购买限购数量")
    private Long maxBuyOnce;

    /** 起购数量 */
    @Excel(name = "起购数量")
    private Long minBuy;

    /** 商品详情 */
    @Excel(name = "商品详情")
    private String content;

    /** 浏览数 */
    @Excel(name = "浏览数")
    private Long viewCount;

    /** 是否支持售后维权 1:支持 0:不支持 */
    @Excel(name = "是否支持售后维权 1:支持 0:不支持")
    private Long isRefundSupport;

    /** 关联商品 */
    @Excel(name = "关联商品")
    private String relatedGoods;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long auditStatus;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String refuseReason;

    /** 商品版本号 */
    @Excel(name = "商品版本号")
    private Long version;

    /** 售罄时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "售罄时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date selloutTime;

    /** 删除时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "删除时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deleteTime;

    /** 下架时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下架时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
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
    public void setDisplayOrder(Long displayOrder) 
    {
        this.displayOrder = displayOrder;
    }

    public Long getDisplayOrder() 
    {
        return displayOrder;
    }
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setSubTitle(String subTitle) 
    {
        this.subTitle = subTitle;
    }

    public String getSubTitle() 
    {
        return subTitle;
    }
    public void setShortTitle(String shortTitle) 
    {
        this.shortTitle = shortTitle;
    }

    public String getShortTitle() 
    {
        return shortTitle;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setPutawayTime(Date putawayTime) 
    {
        this.putawayTime = putawayTime;
    }

    public Date getPutawayTime() 
    {
        return putawayTime;
    }
    public void setVideo(String video) 
    {
        this.video = video;
    }

    public String getVideo() 
    {
        return video;
    }
    public void setVideoThumb(String videoThumb) 
    {
        this.videoThumb = videoThumb;
    }

    public String getVideoThumb() 
    {
        return videoThumb;
    }
    public void setThumb(String thumb) 
    {
        this.thumb = thumb;
    }

    public String getThumb() 
    {
        return thumb;
    }
    public void setThumbs(String thumbs) 
    {
        this.thumbs = thumbs;
    }

    public String getThumbs() 
    {
        return thumbs;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setOriginalPrice(BigDecimal originalPrice) 
    {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getOriginalPrice() 
    {
        return originalPrice;
    }
    public void setCostPrice(BigDecimal costPrice) 
    {
        this.costPrice = costPrice;
    }

    public BigDecimal getCostPrice() 
    {
        return costPrice;
    }
    public void setPriceHide(Integer priceHide) 
    {
        this.priceHide = priceHide;
    }

    public Integer getPriceHide() 
    {
        return priceHide;
    }
    public void setMinPrice(BigDecimal minPrice) 
    {
        this.minPrice = minPrice;
    }

    public BigDecimal getMinPrice() 
    {
        return minPrice;
    }
    public void setMaxPrice(BigDecimal maxPrice) 
    {
        this.maxPrice = maxPrice;
    }

    public BigDecimal getMaxPrice() 
    {
        return maxPrice;
    }
    public void setHasOption(Integer hasOption) 
    {
        this.hasOption = hasOption;
    }

    public Integer getHasOption() 
    {
        return hasOption;
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
    public void setStock(Long stock)
    {
        this.stock = stock;
    }

    public Long getStock()
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
    public void setStockHide(Integer stockHide) 
    {
        this.stockHide = stockHide;
    }

    public Integer getStockHide() 
    {
        return stockHide;
    }
    public void setStockCnf(Long stockCnf) 
    {
        this.stockCnf = stockCnf;
    }

    public Long getStockCnf() 
    {
        return stockCnf;
    }
    public void setSalesCount(Long salesCount) 
    {
        this.salesCount = salesCount;
    }

    public Long getSalesCount() 
    {
        return salesCount;
    }
    public void setSalesHide(Integer salesHide) 
    {
        this.salesHide = salesHide;
    }

    public Integer getSalesHide() 
    {
        return salesHide;
    }
    public void setVirtualSales(Long virtualSales) 
    {
        this.virtualSales = virtualSales;
    }

    public Long getVirtualSales() 
    {
        return virtualSales;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
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
    public void setAutoComplete(Integer autoComplete) 
    {
        this.autoComplete = autoComplete;
    }

    public Integer getAutoComplete() 
    {
        return autoComplete;
    }
    public void setDispatchType(Integer dispatchType) 
    {
        this.dispatchType = dispatchType;
    }

    public Integer getDispatchType() 
    {
        return dispatchType;
    }
    public void setDispatchPrice(BigDecimal dispatchPrice) 
    {
        this.dispatchPrice = dispatchPrice;
    }

    public BigDecimal getDispatchPrice() 
    {
        return dispatchPrice;
    }
    public void setDispatchId(Long dispatchId) 
    {
        this.dispatchId = dispatchId;
    }

    public Long getDispatchId() 
    {
        return dispatchId;
    }
    public void setDispatchMode(String dispatchMode) 
    {
        this.dispatchMode = dispatchMode;
    }

    public String getDispatchMode() 
    {
        return dispatchMode;
    }
    public void setDefaultDispatchMode(String defaultDispatchMode) 
    {
        this.defaultDispatchMode = defaultDispatchMode;
    }

    public String getDefaultDispatchMode() 
    {
        return defaultDispatchMode;
    }
    public void setDispatchHide(Integer dispatchHide) 
    {
        this.dispatchHide = dispatchHide;
    }

    public Integer getDispatchHide() 
    {
        return dispatchHide;
    }
    public void setIsBuyNumLimit(Integer isBuyNumLimit) 
    {
        this.isBuyNumLimit = isBuyNumLimit;
    }

    public Integer getIsBuyNumLimit() 
    {
        return isBuyNumLimit;
    }
    public void setMaxBuyTotal(Long maxBuyTotal) 
    {
        this.maxBuyTotal = maxBuyTotal;
    }

    public Long getMaxBuyTotal() 
    {
        return maxBuyTotal;
    }
    public void setMaxBuyOnce(Long maxBuyOnce) 
    {
        this.maxBuyOnce = maxBuyOnce;
    }

    public Long getMaxBuyOnce() 
    {
        return maxBuyOnce;
    }
    public void setMinBuy(Long minBuy) 
    {
        this.minBuy = minBuy;
    }

    public Long getMinBuy() 
    {
        return minBuy;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setViewCount(Long viewCount) 
    {
        this.viewCount = viewCount;
    }

    public Long getViewCount() 
    {
        return viewCount;
    }
    public void setIsRefundSupport(Long isRefundSupport) 
    {
        this.isRefundSupport = isRefundSupport;
    }

    public Long getIsRefundSupport() 
    {
        return isRefundSupport;
    }
    public void setRelatedGoods(String relatedGoods) 
    {
        this.relatedGoods = relatedGoods;
    }

    public String getRelatedGoods() 
    {
        return relatedGoods;
    }
    public void setAuditStatus(Long auditStatus) 
    {
        this.auditStatus = auditStatus;
    }

    public Long getAuditStatus() 
    {
        return auditStatus;
    }
    public void setRefuseReason(String refuseReason) 
    {
        this.refuseReason = refuseReason;
    }

    public String getRefuseReason() 
    {
        return refuseReason;
    }
    public void setVersion(Long version) 
    {
        this.version = version;
    }

    public Long getVersion() 
    {
        return version;
    }
    public void setSelloutTime(Date selloutTime) 
    {
        this.selloutTime = selloutTime;
    }

    public Date getSelloutTime() 
    {
        return selloutTime;
    }
    public void setDeleteTime(Date deleteTime) 
    {
        this.deleteTime = deleteTime;
    }

    public Date getDeleteTime() 
    {
        return deleteTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }

    public Integer getAuto() {
        return auto;
    }

    public void setAuto(Integer auto) {
        this.auto = auto;
    }

    public Long getFormateId() {
        return formateId;
    }

    public void setFormateId(Long formateId) {
        this.formateId = formateId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shopId", getShopId())
            .append("displayOrder", getDisplayOrder())
            .append("type", getType())
            .append("title", getTitle())
            .append("subTitle", getSubTitle())
            .append("shortTitle", getShortTitle())
            .append("status", getStatus())
            .append("putawayTime", getPutawayTime())
            .append("video", getVideo())
            .append("videoThumb", getVideoThumb())
            .append("thumb", getThumb())
            .append("thumbs", getThumbs())
            .append("price", getPrice())
            .append("originalPrice", getOriginalPrice())
            .append("costPrice", getCostPrice())
            .append("priceHide", getPriceHide())
            .append("minPrice", getMinPrice())
            .append("maxPrice", getMaxPrice())
            .append("hasOption", getHasOption())
            .append("productCode", getProductCode())
            .append("productSn", getProductSn())
            .append("stock", getStock())
            .append("stockWarning", getStockWarning())
            .append("stockHide", getStockHide())
            .append("stockCnf", getStockCnf())
            .append("salesCount", getSalesCount())
            .append("salesHide", getSalesHide())
            .append("virtualSales", getVirtualSales())
            .append("unit", getUnit())
            .append("weight", getWeight())
            .append("volume", getVolume())
            .append("autoComplete", getAutoComplete())
            .append("dispatchType", getDispatchType())
            .append("dispatchPrice", getDispatchPrice())
            .append("dispatchId", getDispatchId())
            .append("dispatchMode", getDispatchMode())
            .append("defaultDispatchMode", getDefaultDispatchMode())
            .append("dispatchHide", getDispatchHide())
            .append("isBuyNumLimit", getIsBuyNumLimit())
            .append("maxBuyTotal", getMaxBuyTotal())
            .append("maxBuyOnce", getMaxBuyOnce())
            .append("minBuy", getMinBuy())
            .append("content", getContent())
            .append("viewCount", getViewCount())
            .append("isRefundSupport", getIsRefundSupport())
            .append("relatedGoods", getRelatedGoods())
            .append("auditStatus", getAuditStatus())
            .append("refuseReason", getRefuseReason())
            .append("version", getVersion())
            .append("selloutTime", getSelloutTime())
            .append("deleteTime", getDeleteTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("endTime", getEndTime())
            .toString();
    }
}
