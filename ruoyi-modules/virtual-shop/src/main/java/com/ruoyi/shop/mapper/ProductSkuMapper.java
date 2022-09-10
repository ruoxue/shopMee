package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.ProductSku;

/**
 * 商品规格信息Mapper接口
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public interface ProductSkuMapper 
{
    /**
     * 查询商品规格信息
     * 
     * @param id 商品规格信息主键
     * @return 商品规格信息
     */
    public ProductSku selectProductSkuById(String id);

    /**
     * 查询商品规格信息列表
     * 
     * @param productSku 商品规格信息
     * @return 商品规格信息集合
     */
    public List<ProductSku> selectProductSkuList(ProductSku productSku);

    /**
     * 新增商品规格信息
     * 
     * @param productSku 商品规格信息
     * @return 结果
     */
    public int insertProductSku(ProductSku productSku);

    /**
     * 修改商品规格信息
     * 
     * @param productSku 商品规格信息
     * @return 结果
     */
    public int updateProductSku(ProductSku productSku);

    /**
     * 删除商品规格信息
     * 
     * @param id 商品规格信息主键
     * @return 结果
     */
    public int deleteProductSkuById(String id);

    /**
     * 批量删除商品规格信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductSkuByIds(String[] ids);
}
