package com.ruoyi.shop.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ProductSpecTitleMapper;
import com.ruoyi.shop.domain.ProductSpecTitle;
import com.ruoyi.shop.service.IProductSpecTitleService;

/**
 * 商品规格项Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@Service
public class ProductSpecTitleServiceImpl implements IProductSpecTitleService 
{
    @Autowired
    private ProductSpecTitleMapper productSpecTitleMapper;

    /**
     * 查询商品规格项
     * 
     * @param id 商品规格项主键
     * @return 商品规格项
     */
    @Override
    public ProductSpecTitle selectProductSpecTitleById(String id)
    {
        return productSpecTitleMapper.selectProductSpecTitleById(id);
    }

    /**
     * 查询商品规格项列表
     * 
     * @param productSpecTitle 商品规格项
     * @return 商品规格项
     */
    @Override
    public List<ProductSpecTitle> selectProductSpecTitleList(ProductSpecTitle productSpecTitle)
    {
        return productSpecTitleMapper.selectProductSpecTitleList(productSpecTitle);
    }

    /**
     * 新增商品规格项
     * 
     * @param productSpecTitle 商品规格项
     * @return 结果
     */
    @Override
    public int insertProductSpecTitle(ProductSpecTitle productSpecTitle)
    {
        productSpecTitle.setCreateTime(DateUtils.getNowDate());
        return productSpecTitleMapper.insertProductSpecTitle(productSpecTitle);
    }

    /**
     * 修改商品规格项
     * 
     * @param productSpecTitle 商品规格项
     * @return 结果
     */
    @Override
    public int updateProductSpecTitle(ProductSpecTitle productSpecTitle)
    {
        productSpecTitle.setUpdateTime(DateUtils.getNowDate());
        return productSpecTitleMapper.updateProductSpecTitle(productSpecTitle);
    }

    /**
     * 批量删除商品规格项
     * 
     * @param ids 需要删除的商品规格项主键
     * @return 结果
     */
    @Override
    public int deleteProductSpecTitleByIds(String[] ids)
    {
        return productSpecTitleMapper.deleteProductSpecTitleByIds(ids);
    }

    /**
     * 删除商品规格项信息
     * 
     * @param id 商品规格项主键
     * @return 结果
     */
    @Override
    public int deleteProductSpecTitleById(String id)
    {
        return productSpecTitleMapper.deleteProductSpecTitleById(id);
    }
}
