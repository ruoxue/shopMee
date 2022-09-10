package com.ruoyi.mobile.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mobile.mapper.ProductMapper;
import com.ruoyi.mobile.domain.Product;
import com.ruoyi.mobile.service.IProductService;

/**
 * 商品基础信息Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-08
 */
@Service
public class ProductServiceImpl implements IProductService 
{
    @Autowired
    private ProductMapper productMapper;

    /**
     * 查询商品基础信息
     * 
     * @param id 商品基础信息主键
     * @return 商品基础信息
     */
    @Override
    public Product selectProductById(Long id)
    {
        return productMapper.selectProductById(id);
    }

    /**
     * 查询商品基础信息列表
     * 
     * @param product 商品基础信息
     * @return 商品基础信息
     */
    @Override
    public List<Product> selectProductList(Product product)
    {
        return productMapper.selectProductList(product);
    }

    /**
     * 新增商品基础信息
     * 
     * @param product 商品基础信息
     * @return 结果
     */
    @Override
    public int insertProduct(Product product)
    {
        product.setCreateTime(DateUtils.getNowDate());
        return productMapper.insertProduct(product);
    }

    /**
     * 修改商品基础信息
     * 
     * @param product 商品基础信息
     * @return 结果
     */
    @Override
    public int updateProduct(Product product)
    {
        product.setUpdateTime(DateUtils.getNowDate());
        return productMapper.updateProduct(product);
    }

    /**
     * 批量删除商品基础信息
     * 
     * @param ids 需要删除的商品基础信息主键
     * @return 结果
     */
    @Override
    public int deleteProductByIds(Long[] ids)
    {
        return productMapper.deleteProductByIds(ids);
    }

    /**
     * 删除商品基础信息信息
     * 
     * @param id 商品基础信息主键
     * @return 结果
     */
    @Override
    public int deleteProductById(Long id)
    {
        return productMapper.deleteProductById(id);
    }
}
