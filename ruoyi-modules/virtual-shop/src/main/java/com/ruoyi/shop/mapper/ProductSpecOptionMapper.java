package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.ProductSpecOption;

/**
 * 商品规格项Mapper接口
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public interface ProductSpecOptionMapper 
{
    /**
     * 查询商品规格项
     * 
     * @param id 商品规格项主键
     * @return 商品规格项
     */
    public ProductSpecOption selectProductSpecOptionById(String id);

    /**
     * 查询商品规格项列表
     * 
     * @param productSpecOption 商品规格项
     * @return 商品规格项集合
     */
    public List<ProductSpecOption> selectProductSpecOptionList(ProductSpecOption productSpecOption);

    /**
     * 新增商品规格项
     * 
     * @param productSpecOption 商品规格项
     * @return 结果
     */
    public int insertProductSpecOption(ProductSpecOption productSpecOption);

    /**
     * 修改商品规格项
     * 
     * @param productSpecOption 商品规格项
     * @return 结果
     */
    public int updateProductSpecOption(ProductSpecOption productSpecOption);

    /**
     * 删除商品规格项
     * 
     * @param id 商品规格项主键
     * @return 结果
     */
    public int deleteProductSpecOptionById(String id);

    /**
     * 批量删除商品规格项
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductSpecOptionByIds(String[] ids);
}
