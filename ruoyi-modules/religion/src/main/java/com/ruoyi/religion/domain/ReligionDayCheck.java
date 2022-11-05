package com.ruoyi.religion.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 日常检查对象 religion_day_check
 * 
 * @author xiaoming
 * @date 2022-10-22 23:25:24
 */
public class ReligionDayCheck extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 封面 */
    @Excel(name = "封面")
    private String thumb;

    /** 租户号 */
    private String tenantId;

    /** 删除 */
    private Long deleted;

    /** 路由 */
    @Excel(name = "路由")
    private String route;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 附件 */
    @Excel(name = "附件")
    private String subFile;

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
    public void setThumb(String thumb) 
    {
        this.thumb = thumb;
    }

    public String getThumb() 
    {
        return thumb;
    }
    public void setTenantId(String tenantId) 
    {
        this.tenantId = tenantId;
    }

    public String getTenantId() 
    {
        return tenantId;
    }
    public void setDeleted(Long deleted) 
    {
        this.deleted = deleted;
    }

    public Long getDeleted() 
    {
        return deleted;
    }
    public void setRoute(String route) 
    {
        this.route = route;
    }

    public String getRoute() 
    {
        return route;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setSubFile(String subFile) 
    {
        this.subFile = subFile;
    }

    public String getSubFile() 
    {
        return subFile;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("thumb", getThumb())
            .append("tenantId", getTenantId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("deleted", getDeleted())
            .append("route", getRoute())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("subFile", getSubFile())
            .toString();
    }
}
