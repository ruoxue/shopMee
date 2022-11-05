package com.ruoyi.religion.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 违法用地场所对象 religion_Illegal_use_manager
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:30
 */
public class ReligionIllegalUseManager extends BaseEntity
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

    /** 违法建筑 */
    @Excel(name = "违法建筑")
    private BigDecimal illegalBuild;

    /** 违法用地 */
    @Excel(name = "违法用地")
    private BigDecimal illegalLand;

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
    public void setIllegalBuild(BigDecimal illegalBuild) 
    {
        this.illegalBuild = illegalBuild;
    }

    public BigDecimal getIllegalBuild() 
    {
        return illegalBuild;
    }
    public void setIllegalLand(BigDecimal illegalLand) 
    {
        this.illegalLand = illegalLand;
    }

    public BigDecimal getIllegalLand() 
    {
        return illegalLand;
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
            .append("illegalBuild", getIllegalBuild())
            .append("illegalLand", getIllegalLand())
            .append("deleted", getDeleted())
            .append("remark", getRemark())
            .toString();
    }
}
