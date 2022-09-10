package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.ProductShop;

/**
 * 商户店铺Mapper接口
 * 
 * @author xiaoming
 * @date 2022-08-10
 */
public interface ProductShopMapper 
{
    /**
     * 查询商户店铺
     * 
     * @param shopId 商户店铺主键
     * @return 商户店铺
     */
    public ProductShop selectProductShopByShopId(Long shopId);

    /**
     * 查询商户店铺列表
     * 
     * @param productShop 商户店铺
     * @return 商户店铺集合
     */
    public List<ProductShop> selectProductShopList(ProductShop productShop);

    /**
     * 新增商户店铺
     * 
     * @param productShop 商户店铺
     * @return 结果
     */
    public int insertProductShop(ProductShop productShop);

    /**
     * 修改商户店铺
     * 
     * @param productShop 商户店铺
     * @return 结果
     */
    public int updateProductShop(ProductShop productShop);

    /**
     * 删除商户店铺
     * 
     * @param shopId 商户店铺主键
     * @return 结果
     */
    public int deleteProductShopByShopId(Long shopId);

    /**
     * 批量删除商户店铺
     * 
     * @param shopIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductShopByShopIds(Long[] shopIds);
}
