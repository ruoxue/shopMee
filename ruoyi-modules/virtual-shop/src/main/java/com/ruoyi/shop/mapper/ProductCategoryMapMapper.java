package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.ProductCategoryMap;

/**
 * 商品分类对应关系Mapper接口
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public interface ProductCategoryMapMapper 
{
    /**
     * 查询商品分类对应关系
     * 
     * @param id 商品分类对应关系主键
     * @return 商品分类对应关系
     */
    public ProductCategoryMap selectProductCategoryMapById(String id);

    /**
     * 查询商品分类对应关系列表
     * 
     * @param productCategoryMap 商品分类对应关系
     * @return 商品分类对应关系集合
     */
    public List<ProductCategoryMap> selectProductCategoryMapList(ProductCategoryMap productCategoryMap);

    /**
     * 新增商品分类对应关系
     * 
     * @param productCategoryMap 商品分类对应关系
     * @return 结果
     */
    public int insertProductCategoryMap(ProductCategoryMap productCategoryMap);

    /**
     * 修改商品分类对应关系
     * 
     * @param productCategoryMap 商品分类对应关系
     * @return 结果
     */
    public int updateProductCategoryMap(ProductCategoryMap productCategoryMap);

    /**
     * 删除商品分类对应关系
     * 
     * @param id 商品分类对应关系主键
     * @return 结果
     */
    public int deleteProductCategoryMapById(String id);

    /**
     * 批量删除商品分类对应关系
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductCategoryMapByIds(String[] ids);
}
