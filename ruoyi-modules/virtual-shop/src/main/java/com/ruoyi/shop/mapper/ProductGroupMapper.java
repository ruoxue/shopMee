package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.ProductGroup;

/**
 * 商品分组Mapper接口
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public interface ProductGroupMapper 
{
    /**
     * 查询商品分组
     * 
     * @param id 商品分组主键
     * @return 商品分组
     */
    public ProductGroup selectProductGroupById(Long id);

    /**
     * 查询商品分组列表
     * 
     * @param productGroup 商品分组
     * @return 商品分组集合
     */
    public List<ProductGroup> selectProductGroupList(ProductGroup productGroup);

    /**
     * 新增商品分组
     * 
     * @param productGroup 商品分组
     * @return 结果
     */
    public int insertProductGroup(ProductGroup productGroup);

    /**
     * 修改商品分组
     * 
     * @param productGroup 商品分组
     * @return 结果
     */
    public int updateProductGroup(ProductGroup productGroup);

    /**
     * 删除商品分组
     * 
     * @param id 商品分组主键
     * @return 结果
     */
    public int deleteProductGroupById(Long id);

    /**
     * 批量删除商品分组
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductGroupByIds(Long[] ids);
}
