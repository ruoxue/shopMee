package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.ProductLabel;

/**
 * 商品标签Mapper接口
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public interface ProductLabelMapper 
{
    /**
     * 查询商品标签
     * 
     * @param id 商品标签主键
     * @return 商品标签
     */
    public ProductLabel selectProductLabelById(Long id);

    /**
     * 查询商品标签列表
     * 
     * @param productLabel 商品标签
     * @return 商品标签集合
     */
    public List<ProductLabel> selectProductLabelList(ProductLabel productLabel);

    /**
     * 新增商品标签
     * 
     * @param productLabel 商品标签
     * @return 结果
     */
    public int insertProductLabel(ProductLabel productLabel);

    /**
     * 修改商品标签
     * 
     * @param productLabel 商品标签
     * @return 结果
     */
    public int updateProductLabel(ProductLabel productLabel);

    /**
     * 删除商品标签
     * 
     * @param id 商品标签主键
     * @return 结果
     */
    public int deleteProductLabelById(Long id);

    /**
     * 批量删除商品标签
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductLabelByIds(Long[] ids);
}
