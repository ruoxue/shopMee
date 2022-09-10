package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.ProductCategory;

/**
 * 商品分类Mapper接口
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public interface ProductCategoryMapper 
{
    /**
     * 查询商品分类
     * 
     * @param id 商品分类主键
     * @return 商品分类
     */
    public ProductCategory selectProductCategoryById(String id);

    /**
     * 查询商品分类列表
     * 
     * @param productCategory 商品分类
     * @return 商品分类集合
     */
    public List<ProductCategory> selectProductCategoryList(ProductCategory productCategory);

    /**
     * 新增商品分类
     * 
     * @param productCategory 商品分类
     * @return 结果
     */
    public int insertProductCategory(ProductCategory productCategory);

    /**
     * 修改商品分类
     * 
     * @param productCategory 商品分类
     * @return 结果
     */
    public int updateProductCategory(ProductCategory productCategory);

    /**
     * 删除商品分类
     * 
     * @param id 商品分类主键
     * @return 结果
     */
    public int deleteProductCategoryById(String id);

    /**
     * 批量删除商品分类
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductCategoryByIds(String[] ids);
}
