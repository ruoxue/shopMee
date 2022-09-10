package com.ruoyi.shop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ProductCategoryMapper;
import com.ruoyi.shop.domain.ProductCategory;
import com.ruoyi.shop.service.IProductCategoryService;

/**
 * 商品分类Service业务层处理
 *
 * @author xiaoming
 * @date 2022-08-07
 */
@Service
public class ProductCategoryServiceImpl implements IProductCategoryService {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    /**
     * 查询商品分类
     *
     * @param id 商品分类主键
     * @return 商品分类
     */
    @Override
    public ProductCategory selectProductCategoryById(String id) {
        return productCategoryMapper.selectProductCategoryById(id);
    }

    /**
     * 查询商品分类列表
     *
     * @param productCategory 商品分类
     * @return 商品分类
     */
    @Override
    public List<ProductCategory> selectProductCategoryList(ProductCategory productCategory) {
        if (productCategory.getTree() != null && productCategory.getTree() == 1) {
            Long parentId = productCategory.getParentId();
            productCategory.setParentId(null);
            List<ProductCategory> productCategories = productCategoryMapper.selectProductCategoryList(productCategory);
            List<ProductCategory> catalogueList = new ArrayList<>();
            catalogueList.addAll(productCategories.parallelStream().filter(v ->
                    Objects.equals(v.getParentId(), parentId)).collect(Collectors.toList()));
            for (ProductCategory catalogue : productCategories) {
                buildChildren(catalogue, productCategories);
            }
            return catalogueList;
        } else {
            return productCategoryMapper.selectProductCategoryList(productCategory);
        }
    }

    private ProductCategory buildChildren(ProductCategory rootNode, List<ProductCategory> cList) {
        // 构建子树 层级不建议过大
        List<ProductCategory> childrenTree = new ArrayList<>();
        for (ProductCategory catalogue : cList) {
            Long pid = catalogue.getParentId();
            Long id = rootNode.getId();
            if (pid.equals(id)&&id!=0) {
                ProductCategory o = buildChildren(catalogue, cList);
                childrenTree.add(o);
            }
        }
        rootNode.setChildren(childrenTree);
        return rootNode;
    }


    /**
     * 新增商品分类
     *
     * @param productCategory 商品分类
     * @return 结果
     */
    @Override
    public int insertProductCategory(ProductCategory productCategory) {
        productCategory.setCreateTime(DateUtils.getNowDate());
        return productCategoryMapper.insertProductCategory(productCategory);
    }

    /**
     * 修改商品分类
     *
     * @param productCategory 商品分类
     * @return 结果
     */
    @Override
    public int updateProductCategory(ProductCategory productCategory) {
        productCategory.setUpdateTime(DateUtils.getNowDate());
        return productCategoryMapper.updateProductCategory(productCategory);
    }

    /**
     * 批量删除商品分类
     *
     * @param ids 需要删除的商品分类主键
     * @return 结果
     */
    @Override
    public int deleteProductCategoryByIds(String[] ids) {
        return productCategoryMapper.deleteProductCategoryByIds(ids);
    }

    /**
     * 删除商品分类信息
     *
     * @param id 商品分类主键
     * @return 结果
     */
    @Override
    public int deleteProductCategoryById(String id) {
        return productCategoryMapper.deleteProductCategoryById(id);
    }
}
