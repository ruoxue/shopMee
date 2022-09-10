package com.ruoyi.shop.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ProductCategoryMapMapper;
import com.ruoyi.shop.domain.ProductCategoryMap;
import com.ruoyi.shop.service.IProductCategoryMapService;

/**
 * 商品分类对应关系Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@Service
public class ProductCategoryMapServiceImpl implements IProductCategoryMapService 
{
    @Autowired
    private ProductCategoryMapMapper productCategoryMapMapper;

    /**
     * 查询商品分类对应关系
     * 
     * @param id 商品分类对应关系主键
     * @return 商品分类对应关系
     */
    @Override
    public ProductCategoryMap selectProductCategoryMapById(String id)
    {




        return productCategoryMapMapper.selectProductCategoryMapById(id);
    }

    /**
     * 查询商品分类对应关系列表
     * 
     * @param productCategoryMap 商品分类对应关系
     * @return 商品分类对应关系
     */
    @Override
    public List<ProductCategoryMap> selectProductCategoryMapList(ProductCategoryMap productCategoryMap)
    {
        return productCategoryMapMapper.selectProductCategoryMapList(productCategoryMap);
    }

    /**
     * 新增商品分类对应关系
     * 
     * @param productCategoryMap 商品分类对应关系
     * @return 结果
     */
    @Override
    public int insertProductCategoryMap(ProductCategoryMap productCategoryMap)
    {
        productCategoryMap.setCreateTime(DateUtils.getNowDate());
        return productCategoryMapMapper.insertProductCategoryMap(productCategoryMap);
    }

    /**
     * 修改商品分类对应关系
     * 
     * @param productCategoryMap 商品分类对应关系
     * @return 结果
     */
    @Override
    public int updateProductCategoryMap(ProductCategoryMap productCategoryMap)
    {
        productCategoryMap.setUpdateTime(DateUtils.getNowDate());
        return productCategoryMapMapper.updateProductCategoryMap(productCategoryMap);
    }

    /**
     * 批量删除商品分类对应关系
     * 
     * @param ids 需要删除的商品分类对应关系主键
     * @return 结果
     */
    @Override
    public int deleteProductCategoryMapByIds(String[] ids)
    {
        return productCategoryMapMapper.deleteProductCategoryMapByIds(ids);
    }

    /**
     * 删除商品分类对应关系信息
     * 
     * @param id 商品分类对应关系主键
     * @return 结果
     */
    @Override
    public int deleteProductCategoryMapById(String id)
    {
        return productCategoryMapMapper.deleteProductCategoryMapById(id);
    }

    @Override
    public ProductCategoryMap selectProductCategoryMapListByCId(ProductCategoryMap queryParam) {
        List<ProductCategoryMap> productCategoryMaps = productCategoryMapMapper.selectProductCategoryMapList(queryParam);
        if (productCategoryMaps.isEmpty())
            return null;
        return  productCategoryMaps.get(0);
    }
}
