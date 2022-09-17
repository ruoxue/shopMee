package com.ruoyi.shop.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.shop.domain.*;
import com.ruoyi.shop.mapper.ProductCategoryMapMapper;
import com.ruoyi.shop.param.ProductPO;
import com.ruoyi.shop.service.IProductCategoryMapService;
import com.ruoyi.shop.service.IProductShopService;
import com.ruoyi.shop.service.IProductSkuService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ProductMapper;
import com.ruoyi.shop.service.IProductService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品基础信息Service业务层处理
 *
 * @author xiaoming
 * @date 2022-08-07
 */
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private IProductShopService iProductShopService;
    @Autowired
    private IProductCategoryMapService productCategoryMapService;
    @Autowired
    private IProductSkuService iProductSkuService;


    /**
     * 查询商品基础信息
     *
     * @param id 商品基础信息主键
     * @return 商品基础信息
     */
    @Override
    public ProductVO selectProductById(Long id) {
        return productMapper.selectProductById(id);
    }

    /**
     * 查询商品基础信息列表
     *
     * @param product 商品基础信息
     * @return 商品基础信息
     */
    @Override
    public List<ProductVO> selectProductList(ProductPO product) {
        product.setEndTime(new Date());
        return productMapper.selectProductList(product);
    }

    /**
     * 新增商品基础信息
     *
     * @param product 商品基础信息
     * @return 结果
     */


    @Transactional(rollbackFor = Exception.class)
    public int insertProduct(ProductPO product, Long categoryId) {

        ProductShop productShop = iProductShopService.selectProductShopByShopId(product.getShopId());
        if (!productShop.getUserId().equals((product.getUserId()))) {
            return 0;
        }

        int i = ((IProductService) AopContext.currentProxy()).insertProduct(product);
        ProductCategoryMap productCategoryMap = new ProductCategoryMap();
        productCategoryMap.setCategoryId(categoryId);
        productCategoryMap.setShopId(product.getShopId());
        productCategoryMap.setStatus(1);
        productCategoryMap.setCreateTime(DateUtils.getNowDate());
        productCategoryMap.setGoodsId(product.getId());
        productCategoryMapService.insertProductCategoryMap(productCategoryMap);

        ProductSku sku = new ProductSku();
        BeanUtils.copyProperties(product, sku);
        sku.setGoodsId(product.getId());
        iProductSkuService.insertProductSku(sku);
        return i;
    }


    @Override
    public int insertProduct(Product product) {
        product.setCreateTime(DateUtils.getNowDate());


        return productMapper.insertProduct(product);
    }

    /**
     * 修改商品基础信息
     *
     * @param product 商品基础信息
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateProduct(ProductPO product) {
        product.setUpdateTime(DateUtils.getNowDate());

        ProductShop productShop = iProductShopService.selectProductShopByShopId(product.getShopId());
        if (!productShop.getUserId().equals(Integer.parseInt(product.getUserId() + ""))) {
            return 0;
        }

        ProductCategoryMap queryParam = new ProductCategoryMap();
        queryParam.setGoodsId(product.getId());
        queryParam.setShopId(product.getShopId());
        ProductCategoryMap productCategoryMap = productCategoryMapService.selectProductCategoryMapListByCId(queryParam);
        if (productCategoryMap == null) {
            productCategoryMap = new ProductCategoryMap();
            productCategoryMap.setCreateTime(new Date());
        }
        productCategoryMap.setCategoryId(product.getCategoryId());
        productCategoryMap.setShopId(product.getShopId());
        productCategoryMap.setStatus(1);
        productCategoryMap.setUpdateTime(DateUtils.getNowDate());
        productCategoryMap.setGoodsId(product.getId());
        if (productCategoryMap.getId() != null) {
            productCategoryMapService.updateProductCategoryMap(productCategoryMap);
        } else {
            queryParam.setShopId(null);
            queryParam.setCategoryId(null);
            ProductCategoryMap productCategoryMap1 = productCategoryMapService.selectProductCategoryMapListByCId(queryParam);
            if (productCategoryMap1 != null && productCategoryMap1.getId() != null)
                productCategoryMapService.deleteProductCategoryMapById(productCategoryMap1.getId());
            productCategoryMapService.insertProductCategoryMap(productCategoryMap);

        }

//todo
        ProductSku sku = iProductSkuService.selectProductSkuByGoodsId(product.getId());
        if (sku == null)
            sku = new ProductSku();
        BeanUtils.copyProperties(product, sku);
        sku.setGoodsId(product.getId());
        if (sku.getId() <= 0) {
            iProductSkuService.insertProductSku(sku);
        } else {
            iProductSkuService.updateProductSku(sku);

        }


        return productMapper.updateProduct(product);
    }

    /**
     * 批量删除商品基础信息
     *
     * @param ids 需要删除的商品基础信息主键
     * @return 结果
     */
    @Override
    public int deleteProductByIds(Long[] ids) {
        return productMapper.deleteProductByIds(ids);
    }

    /**
     * 删除商品基础信息信息
     *
     * @param id 商品基础信息主键
     * @return 结果
     */
    @Override
    public int deleteProductById(Long id) {
        return productMapper.deleteProductById(id);
    }

    @Override
    public int updateSaleCount(Long id) {
        return productMapper.updateSaleCount(id);

    }
}
