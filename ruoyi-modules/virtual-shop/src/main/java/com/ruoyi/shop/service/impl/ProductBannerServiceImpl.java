package com.ruoyi.shop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ProductBannerMapper;
import com.ruoyi.shop.domain.ProductBanner;
import com.ruoyi.shop.service.IProductBannerService;

/**
 * bannerService业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-29
 */
@Service
public class ProductBannerServiceImpl implements IProductBannerService 
{
    @Autowired
    private ProductBannerMapper productBannerMapper;

    /**
     * 查询banner
     * 
     * @param id banner主键
     * @return banner
     */
    @Override
    public ProductBanner selectProductBannerById(Long id)
    {
        return productBannerMapper.selectProductBannerById(id);
    }

    /**
     * 查询banner列表
     * 
     * @param productBanner banner
     * @return banner
     */
    @Override
    public List<ProductBanner> selectProductBannerList(ProductBanner productBanner)
    {
        return productBannerMapper.selectProductBannerList(productBanner);
    }

    /**
     * 新增banner
     * 
     * @param productBanner banner
     * @return 结果
     */
    @Override
    public int insertProductBanner(ProductBanner productBanner)
    {
        return productBannerMapper.insertProductBanner(productBanner);
    }

    /**
     * 修改banner
     * 
     * @param productBanner banner
     * @return 结果
     */
    @Override
    public int updateProductBanner(ProductBanner productBanner)
    {
        return productBannerMapper.updateProductBanner(productBanner);
    }

    /**
     * 批量删除banner
     * 
     * @param ids 需要删除的banner主键
     * @return 结果
     */
    @Override
    public int deleteProductBannerByIds(Long[] ids)
    {
        return productBannerMapper.deleteProductBannerByIds(ids);
    }

    /**
     * 删除banner信息
     * 
     * @param id banner主键
     * @return 结果
     */
    @Override
    public int deleteProductBannerById(Long id)
    {
        return productBannerMapper.deleteProductBannerById(id);
    }
}
