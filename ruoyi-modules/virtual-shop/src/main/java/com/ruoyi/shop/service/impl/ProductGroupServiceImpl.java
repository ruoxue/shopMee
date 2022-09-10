package com.ruoyi.shop.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ProductGroupMapper;
import com.ruoyi.shop.domain.ProductGroup;
import com.ruoyi.shop.service.IProductGroupService;

/**
 * 商品分组Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@Service
public class ProductGroupServiceImpl implements IProductGroupService 
{
    @Autowired
    private ProductGroupMapper productGroupMapper;

    /**
     * 查询商品分组
     * 
     * @param id 商品分组主键
     * @return 商品分组
     */
    @Override
    public ProductGroup selectProductGroupById(Long id)
    {
        return productGroupMapper.selectProductGroupById(id);
    }

    /**
     * 查询商品分组列表
     * 
     * @param productGroup 商品分组
     * @return 商品分组
     */
    @Override
    public List<ProductGroup> selectProductGroupList(ProductGroup productGroup)
    {
        return productGroupMapper.selectProductGroupList(productGroup);
    }

    /**
     * 新增商品分组
     * 
     * @param productGroup 商品分组
     * @return 结果
     */
    @Override
    public int insertProductGroup(ProductGroup productGroup)
    {
        productGroup.setCreateTime(DateUtils.getNowDate());
        return productGroupMapper.insertProductGroup(productGroup);
    }

    /**
     * 修改商品分组
     * 
     * @param productGroup 商品分组
     * @return 结果
     */
    @Override
    public int updateProductGroup(ProductGroup productGroup)
    {
        productGroup.setUpdateTime(DateUtils.getNowDate());
        return productGroupMapper.updateProductGroup(productGroup);
    }

    /**
     * 批量删除商品分组
     * 
     * @param ids 需要删除的商品分组主键
     * @return 结果
     */
    @Override
    public int deleteProductGroupByIds(Long[] ids)
    {
        return productGroupMapper.deleteProductGroupByIds(ids);
    }

    /**
     * 删除商品分组信息
     * 
     * @param id 商品分组主键
     * @return 结果
     */
    @Override
    public int deleteProductGroupById(Long id)
    {
        return productGroupMapper.deleteProductGroupById(id);
    }
}
