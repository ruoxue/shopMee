package com.ruoyi.order.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.order.mapper.ProductBannerMapper;
import com.ruoyi.order.domain.ProductBanner;
import com.ruoyi.order.service.IProductBannerService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-28
 */
@Service
public class ProductBannerServiceImpl implements IProductBannerService 
{
    @Autowired
    private ProductBannerMapper productBannerMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public ProductBanner selectProductBannerById(Long id)
    {
        return productBannerMapper.selectProductBannerById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param productBanner 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ProductBanner> selectProductBannerList(ProductBanner productBanner)
    {
        return productBannerMapper.selectProductBannerList(productBanner);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param productBanner 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertProductBanner(ProductBanner productBanner)
    {
        return productBannerMapper.insertProductBanner(productBanner);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param productBanner 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateProductBanner(ProductBanner productBanner)
    {
        return productBannerMapper.updateProductBanner(productBanner);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteProductBannerByIds(Long[] ids)
    {
        return productBannerMapper.deleteProductBannerByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteProductBannerById(Long id)
    {
        return productBannerMapper.deleteProductBannerById(id);
    }
}
