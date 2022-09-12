package com.ruoyi.shop.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 地址对象 BUYER_ADDRESS
 * 
 * @author xiaoming
 * @date 2022-09-11
 */
public class BuyerAddress extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 地址ID */
    private Long addressId;



    private String value;
    private String region;


    /** 地址名称 */
    @Excel(name = "地址名称")
    private String addressName;
    private String phone;

    private String provinceName;
    private String cityName;
    private String countyName;


    /** 顺序号 */
    @Excel(name = "顺序号")
    private Long seqNumber;

    /** 省 */
    @Excel(name = "省")
    private Long province;

    /** 市 */
    @Excel(name = "市")
    private Long city;

    /** 区 */
    @Excel(name = "区")
    private Long county;

    /** 街道 */
    @Excel(name = "街道")
    private String street;

    /** 门牌号 */
    @Excel(name = "门牌号")
    private String lastDetail;

    /** 乐观锁 */
    private Long revision;

    /** 创建人 */
    private String createdBy;

    /** 创建时间 */
    private Date createdTime;

    /** 更新人 */
    private String updatedBy;

    /** 更新时间 */
    private Date updatedTime;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    /** $column.columnComment */
    @Excel(name = "uid", readConverterExp = "$column.readConverterExp()")
    private Long uid;

    public void setAddressId(Long addressId) 
    {
        this.addressId = addressId;
    }

    public Long getAddressId() 
    {
        return addressId;
    }
    public void setAddressName(String addressName) 
    {
        this.addressName = addressName;
    }

    public String getAddressName() 
    {
        return addressName;
    }
    public void setSeqNumber(Long seqNumber) 
    {
        this.seqNumber = seqNumber;
    }

    public Long getSeqNumber() 
    {
        return seqNumber;
    }
    public void setProvince(Long province) 
    {
        this.province = province;
    }

    public Long getProvince() 
    {
        return province;
    }
    public void setCity(Long city) 
    {
        this.city = city;
    }

    public Long getCity() 
    {
        return city;
    }
    public void setCounty(Long county) 
    {
        this.county = county;
    }

    public Long getCounty() 
    {
        return county;
    }
    public void setStreet(String street) 
    {
        this.street = street;
    }

    public String getStreet() 
    {
        return street;
    }
    public void setLastDetail(String lastDetail) 
    {
        this.lastDetail = lastDetail;
    }

    public String getLastDetail() 
    {
        return lastDetail;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getUpdatedTime()
    {
        return updatedTime;
    }
    public void setUid(Long uid) 
    {
        this.uid = uid;
    }

    public Long getUid() 
    {
        return uid;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("addressId", getAddressId())
            .append("addressName", getAddressName())
            .append("seqNumber", getSeqNumber())
            .append("province", getProvince())
            .append("city", getCity())
            .append("county", getCounty())
            .append("street", getStreet())
            .append("lastDetail", getLastDetail())
            .append("revision", getRevision())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .append("uid", getUid())
            .toString();
    }
}
