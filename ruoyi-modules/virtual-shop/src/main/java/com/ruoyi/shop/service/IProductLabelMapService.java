package com.ruoyi.shop.service;

import java.util.List;
import com.ruoyi.shop.domain.ProductLabelMap;

/**
 * 商品标签对应关系Service接口
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public interface IProductLabelMapService 
{
    /**
     * 查询商品标签对应关系
     * 
     * @param id 商品标签对应关系主键
     * @return 商品标签对应关系
     */
    public ProductLabelMap selectProductLabelMapById(String id);

    /**
     * 查询商品标签对应关系列表
     * 
     * @param productLabelMap 商品标签对应关系
     * @return 商品标签对应关系集合
     */
    public List<ProductLabelMap> selectProductLabelMapList(ProductLabelMap productLabelMap);

    /**
     * 新增商品标签对应关系
     * 
     * @param productLabelMap 商品标签对应关系
     * @return 结果
     */
    public int insertProductLabelMap(ProductLabelMap productLabelMap);

    /**
     * 修改商品标签对应关系
     * 
     * @param productLabelMap 商品标签对应关系
     * @return 结果
     */
    public int updateProductLabelMap(ProductLabelMap productLabelMap);

    /**
     * 批量删除商品标签对应关系
     * 
     * @param ids 需要删除的商品标签对应关系主键集合
     * @return 结果
     */
    public int deleteProductLabelMapByIds(String[] ids);

    /**
     * 删除商品标签对应关系信息
     * 
     * @param id 商品标签对应关系主键
     * @return 结果
     */
    public int deleteProductLabelMapById(String id);
}
