package com.ruoyi.shop.service;

import java.util.List;

import com.ruoyi.shop.domain.Product;
import com.ruoyi.shop.domain.ProductVO;
import com.ruoyi.shop.param.ProductPO;

/**
 * 商品基础信息Service接口
 *
 * @author xiaoming
 * @date 2022-08-07
 */
public interface IProductService {
    /**
     * 查询商品基础信息
     *
     * @param id 商品基础信息主键
     * @return 商品基础信息
     */
    public ProductVO selectProductById(Long id);

    /**
     * 查询商品基础信息列表
     *
     * @param product 商品基础信息
     * @return 商品基础信息集合
     */
    public List<ProductVO> selectProductList(ProductPO product);

    /**
     * 新增商品基础信息
     *
     * @param product 商品基础信息
     * @return 结果
     */
    String getOptionIdsByName(List<String> specs, Long id);

    public int insertProduct(Product product);

    public int insertProduct(ProductPO product, Long categoryId);

    /**
     * 修改商品基础信息
     *
     * @param product 商品基础信息
     * @return 结果
     */
    public int updateProduct(ProductPO product);

    /**
     * 批量删除商品基础信息
     *
     * @param ids 需要删除的商品基础信息主键集合
     * @return 结果
     */
    public int deleteProductByIds(Long[] ids);

    /**
     * 删除商品基础信息信息
     *
     * @param id 商品基础信息主键
     * @return 结果
     */
    public int deleteProductById(Long id);

    int updateSaleCount(Long id);
}
