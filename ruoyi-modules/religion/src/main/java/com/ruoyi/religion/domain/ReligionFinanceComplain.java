package com.ruoyi.religion.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 财务投诉对象 religion_finance_complain
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
public class ReligionFinanceComplain extends BaseEntity
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

    /** 宗教类院校 */
    @Excel(name = "宗教类院校")
    private Long collegaId;

    /** 宗教团体 */
    @Excel(name = "宗教团体")
    private Long teamId;

    /** 投诉来源 */
    @Excel(name = "投诉来源")
    private Long complainFrom;

    /** 宗教场所 */
    @Excel(name = "宗教场所")
    private Long buildingId;

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
    public void setCollegaId(Long collegaId) 
    {
        this.collegaId = collegaId;
    }

    public Long getCollegaId() 
    {
        return collegaId;
    }
    public void setTeamId(Long teamId) 
    {
        this.teamId = teamId;
    }

    public Long getTeamId() 
    {
        return teamId;
    }
    public void setComplainFrom(Long complainFrom) 
    {
        this.complainFrom = complainFrom;
    }

    public Long getComplainFrom() 
    {
        return complainFrom;
    }
    public void setBuildingId(Long buildingId) 
    {
        this.buildingId = buildingId;
    }

    public Long getBuildingId() 
    {
        return buildingId;
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
            .append("collegaId", getCollegaId())
            .append("teamId", getTeamId())
            .append("complainFrom", getComplainFrom())
            .append("buildingId", getBuildingId())
            .append("deleted", getDeleted())
            .append("remark", getRemark())
            .toString();
    }
}
