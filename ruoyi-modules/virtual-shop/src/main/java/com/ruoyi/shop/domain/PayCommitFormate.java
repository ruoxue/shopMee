package com.ruoyi.shop.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 求购商品格式对象 pay_commit_formate
 * 
 * @author xiaoming
 * @date 2022-09-11
 */
public class PayCommitFormate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 路径 */
    @Excel(name = "路径")
    private String url;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 格式 */
    @Excel(name = "格式")
    private String formate;

    /** 格式描述 */
    @Excel(name = "格式描述")
    private String formateDesc;

    /** 本地api */
    @Excel(name = "本地api")
    private String local;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal rate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public String getFormate() {
        return formate;
    }

    public void setFormate(String formate) {
        this.formate = formate;
    }

    public void setFormateDesc(String formateDesc)
    {
        this.formateDesc = formateDesc;
    }

    public String getFormateDesc() 
    {
        return formateDesc;
    }
    public void setLocal(String local) 
    {
        this.local = local;
    }

    public String getLocal() 
    {
        return local;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setRate(BigDecimal rate) 
    {
        this.rate = rate;
    }

    public BigDecimal getRate() 
    {
        return rate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("url", getUrl())
            .append("name", getName())
            .append("format", getFormate())
            .append("formateDesc", getFormateDesc())
            .append("local", getLocal())
            .append("status", getStatus())
            .append("rate", getRate())
            .toString();
    }
}
