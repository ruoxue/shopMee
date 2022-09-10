package com.ruoyi.shop.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ProductGroupMapMapper;
import com.ruoyi.shop.domain.ProductGroupMap;
import com.ruoyi.shop.service.IProductGroupMapService;

/**
 * 商品分组对应关系Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@Service
public class ProductGroupMapServiceImpl implements IProductGroupMapService 
{
    @Autowired
    private ProductGroupMapMapper productGroupMapMapper;

    /**
     * 查询商品分组对应关系
     * 
     * @param id 商品分组对应关系主键
     * @return 商品分组对应关系
     */
    @Override
    public ProductGroupMap selectProductGroupMapById(String id)
    {
        return productGroupMapMapper.selectProductGroupMapById(id);
    }

    /**
     * 查询商品分组对应关系列表
     * 
     * @param productGroupMap 商品分组对应关系
     * @return 商品分组对应关系
     */
    @Override
    public List<ProductGroupMap> selectProductGroupMapList(ProductGroupMap productGroupMap)
    {
        return productGroupMapMapper.selectProductGroupMapList(productGroupMap);
    }

    /**
     * 新增商品分组对应关系
     * 
     * @param productGroupMap 商品分组对应关系
     * @return 结果
     */
    @Override
    public int insertProductGroupMap(ProductGroupMap productGroupMap)
    {
        productGroupMap.setCreateTime(DateUtils.getNowDate());
        return productGroupMapMapper.insertProductGroupMap(productGroupMap);
    }

    /**
     * 修改商品分组对应关系
     * 
     * @param productGroupMap 商品分组对应关系
     * @return 结果
     */
    @Override
    public int updateProductGroupMap(ProductGroupMap productGroupMap)
    {
        productGroupMap.setUpdateTime(DateUtils.getNowDate());
        return productGroupMapMapper.updateProductGroupMap(productGroupMap);
    }

    /**
     * 批量删除商品分组对应关系
     * 
     * @param ids 需要删除的商品分组对应关系主键
     * @return 结果
     */
    @Override
    public int deleteProductGroupMapByIds(String[] ids)
    {
        return productGroupMapMapper.deleteProductGroupMapByIds(ids);
    }

    /**
     * 删除商品分组对应关系信息
     * 
     * @param id 商品分组对应关系主键
     * @return 结果
     */
    @Override
    public int deleteProductGroupMapById(String id)
    {
        return productGroupMapMapper.deleteProductGroupMapById(id);
    }
}
