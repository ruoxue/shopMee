package com.ruoyi.order.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 pay_channel
 * 
 * @author xiaoming
 * @date 2022-08-28
 */
public class PayChannel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String code;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String config;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String privateKey;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String alipayPublicKey;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String appCertContent;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String alipayPublicCertContent;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setConfig(String config) 
    {
        this.config = config;
    }

    public String getConfig() 
    {
        return config;
    }
    public void setPrivateKey(String privateKey) 
    {
        this.privateKey = privateKey;
    }

    public String getPrivateKey() 
    {
        return privateKey;
    }
    public void setAlipayPublicKey(String alipayPublicKey) 
    {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getAlipayPublicKey() 
    {
        return alipayPublicKey;
    }
    public void setAppCertContent(String appCertContent) 
    {
        this.appCertContent = appCertContent;
    }

    public String getAppCertContent() 
    {
        return appCertContent;
    }
    public void setAlipayPublicCertContent(String alipayPublicCertContent) 
    {
        this.alipayPublicCertContent = alipayPublicCertContent;
    }

    public String getAlipayPublicCertContent() 
    {
        return alipayPublicCertContent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("name", getName())
            .append("config", getConfig())
            .append("privateKey", getPrivateKey())
            .append("alipayPublicKey", getAlipayPublicKey())
            .append("appCertContent", getAppCertContent())
            .append("alipayPublicCertContent", getAlipayPublicCertContent())
            .toString();
    }
}
