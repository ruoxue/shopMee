package com.ruoyi.religion.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 宗教场所对象 religion_area
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:30
 */
public class ReligionArea extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 租户号 */
    private String tenantId;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 简介 */
    @Excel(name = "简介")
    private String introduce;

    /** 照片 */
    @Excel(name = "照片")
    private String thumb;

    /** 宗教类别 */
    @Excel(name = "宗教类别")
    private String religionType;

    /** 经度 */
    @Excel(name = "经度")
    private BigDecimal longitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private BigDecimal latitude;

    /** 景区级别 */
    @Excel(name = "景区级别")
    private Long scenicLevel;

    /** 文保级别 */
    @Excel(name = "文保级别")
    private Long securityLevel;

    /** 门票 */
    @Excel(name = "门票")
    private BigDecimal ticket;

    /** 始建年代 */
    @Excel(name = "始建年代")
    private String initialTime;

    /** 开发时间 */
    @Excel(name = "开发时间")
    private String devTime;

    /** 主要景点 */
    @Excel(name = "主要景点")
    private String mainSpot;

    /** 适宜游玩时间 */
    @Excel(name = "适宜游玩时间")
    private String niceTime;

    /** 宗教事务 */
    @Excel(name = "宗教事务")
    private String religionThing;

    /** 删除 */
    private Long deleted;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setTenantId(String tenantId) 
    {
        this.tenantId = tenantId;
    }

    public String getTenantId() 
    {
        return tenantId;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setIntroduce(String introduce) 
    {
        this.introduce = introduce;
    }

    public String getIntroduce() 
    {
        return introduce;
    }
    public void setThumb(String thumb) 
    {
        this.thumb = thumb;
    }

    public String getThumb() 
    {
        return thumb;
    }
    public void setReligionType(String religionType) 
    {
        this.religionType = religionType;
    }

    public String getReligionType() 
    {
        return religionType;
    }
    public void setLongitude(BigDecimal longitude) 
    {
        this.longitude = longitude;
    }

    public BigDecimal getLongitude() 
    {
        return longitude;
    }
    public void setLatitude(BigDecimal latitude) 
    {
        this.latitude = latitude;
    }

    public BigDecimal getLatitude() 
    {
        return latitude;
    }
    public void setScenicLevel(Long scenicLevel) 
    {
        this.scenicLevel = scenicLevel;
    }

    public Long getScenicLevel() 
    {
        return scenicLevel;
    }
    public void setSecurityLevel(Long securityLevel) 
    {
        this.securityLevel = securityLevel;
    }

    public Long getSecurityLevel() 
    {
        return securityLevel;
    }
    public void setTicket(BigDecimal ticket) 
    {
        this.ticket = ticket;
    }

    public BigDecimal getTicket() 
    {
        return ticket;
    }
    public void setInitialTime(String initialTime) 
    {
        this.initialTime = initialTime;
    }

    public String getInitialTime() 
    {
        return initialTime;
    }
    public void setDevTime(String devTime) 
    {
        this.devTime = devTime;
    }

    public String getDevTime() 
    {
        return devTime;
    }
    public void setMainSpot(String mainSpot) 
    {
        this.mainSpot = mainSpot;
    }

    public String getMainSpot() 
    {
        return mainSpot;
    }
    public void setNiceTime(String niceTime) 
    {
        this.niceTime = niceTime;
    }

    public String getNiceTime() 
    {
        return niceTime;
    }
    public void setReligionThing(String religionThing) 
    {
        this.religionThing = religionThing;
    }

    public String getReligionThing() 
    {
        return religionThing;
    }
    public void setDeleted(Long deleted) 
    {
        this.deleted = deleted;
    }

    public Long getDeleted() 
    {
        return deleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("tenantId", getTenantId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("introduce", getIntroduce())
            .append("thumb", getThumb())
            .append("religionType", getReligionType())
            .append("longitude", getLongitude())
            .append("latitude", getLatitude())
            .append("scenicLevel", getScenicLevel())
            .append("securityLevel", getSecurityLevel())
            .append("ticket", getTicket())
            .append("initialTime", getInitialTime())
            .append("devTime", getDevTime())
            .append("mainSpot", getMainSpot())
            .append("niceTime", getNiceTime())
            .append("religionThing", getReligionThing())
            .append("deleted", getDeleted())
            .append("remark", getRemark())
            .toString();
    }
}
