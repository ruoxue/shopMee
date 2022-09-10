package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.ProductGroupMap;

/**
 * 商品分组对应关系Mapper接口
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public interface ProductGroupMapMapper 
{
    /**
     * 查询商品分组对应关系
     * 
     * @param id 商品分组对应关系主键
     * @return 商品分组对应关系
     */
    public ProductGroupMap selectProductGroupMapById(String id);

    /**
     * 查询商品分组对应关系列表
     * 
     * @param productGroupMap 商品分组对应关系
     * @return 商品分组对应关系集合
     */
    public List<ProductGroupMap> selectProductGroupMapList(ProductGroupMap productGroupMap);

    /**
     * 新增商品分组对应关系
     * 
     * @param productGroupMap 商品分组对应关系
     * @return 结果
     */
    public int insertProductGroupMap(ProductGroupMap productGroupMap);

    /**
     * 修改商品分组对应关系
     * 
     * @param productGroupMap 商品分组对应关系
     * @return 结果
     */
    public int updateProductGroupMap(ProductGroupMap productGroupMap);

    /**
     * 删除商品分组对应关系
     * 
     * @param id 商品分组对应关系主键
     * @return 结果
     */
    public int deleteProductGroupMapById(String id);

    /**
     * 批量删除商品分组对应关系
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductGroupMapByIds(String[] ids);
}
