package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.ProductSpecTitle;

/**
 * 商品规格项Mapper接口
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public interface ProductSpecTitleMapper 
{
    /**
     * 查询商品规格项
     * 
     * @param id 商品规格项主键
     * @return 商品规格项
     */
    public ProductSpecTitle selectProductSpecTitleById(String id);

    /**
     * 查询商品规格项列表
     * 
     * @param productSpecTitle 商品规格项
     * @return 商品规格项集合
     */
    public List<ProductSpecTitle> selectProductSpecTitleList(ProductSpecTitle productSpecTitle);

    /**
     * 新增商品规格项
     * 
     * @param productSpecTitle 商品规格项
     * @return 结果
     */
    public int insertProductSpecTitle(ProductSpecTitle productSpecTitle);

    /**
     * 修改商品规格项
     * 
     * @param productSpecTitle 商品规格项
     * @return 结果
     */
    public int updateProductSpecTitle(ProductSpecTitle productSpecTitle);

    /**
     * 删除商品规格项
     * 
     * @param id 商品规格项主键
     * @return 结果
     */
    public int deleteProductSpecTitleById(String id);

    /**
     * 批量删除商品规格项
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductSpecTitleByIds(String[] ids);

    List<ProductSpecTitle> selectProductSpecTitleAndSpecList(ProductSpecTitle productSpecTitle);
}
