package com.ruoyi.shop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ProductShopMapper;
import com.ruoyi.shop.domain.ProductShop;
import com.ruoyi.shop.service.IProductShopService;

/**
 * 商户店铺Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-10
 */
@Service
public class ProductShopServiceImpl implements IProductShopService 
{
    @Autowired
    private ProductShopMapper productShopMapper;

    /**
     * 查询商户店铺
     * 
     * @param shopId 商户店铺主键
     * @return 商户店铺
     */
    @Override
    public ProductShop selectProductShopByShopId(Long shopId)
    {
        return productShopMapper.selectProductShopByShopId(shopId);
    }

    /**
     * 查询商户店铺列表
     * 
     * @param productShop 商户店铺
     * @return 商户店铺
     */
    @Override
    public List<ProductShop> selectProductShopList(ProductShop productShop)
    {
        return productShopMapper.selectProductShopList(productShop);
    }

    /**
     * 新增商户店铺
     * 
     * @param productShop 商户店铺
     * @return 结果
     */
    @Override
    public int insertProductShop(ProductShop productShop)
    {
        return productShopMapper.insertProductShop(productShop);
    }

    /**
     * 修改商户店铺
     * 
     * @param productShop 商户店铺
     * @return 结果
     */
    @Override
    public int updateProductShop(ProductShop productShop)
    {
        return productShopMapper.updateProductShop(productShop);
    }

    /**
     * 批量删除商户店铺
     * 
     * @param shopIds 需要删除的商户店铺主键
     * @return 结果
     */
    @Override
    public int deleteProductShopByShopIds(Long[] shopIds)
    {
        return productShopMapper.deleteProductShopByShopIds(shopIds);
    }

    /**
     * 删除商户店铺信息
     * 
     * @param shopId 商户店铺主键
     * @return 结果
     */
    @Override
    public int deleteProductShopByShopId(Long shopId)
    {
        return productShopMapper.deleteProductShopByShopId(shopId);
    }
}
