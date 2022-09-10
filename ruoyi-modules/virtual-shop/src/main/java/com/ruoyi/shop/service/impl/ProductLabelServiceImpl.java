package com.ruoyi.shop.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ProductLabelMapper;
import com.ruoyi.shop.domain.ProductLabel;
import com.ruoyi.shop.service.IProductLabelService;

/**
 * 商品标签Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@Service
public class ProductLabelServiceImpl implements IProductLabelService 
{
    @Autowired
    private ProductLabelMapper productLabelMapper;

    /**
     * 查询商品标签
     * 
     * @param id 商品标签主键
     * @return 商品标签
     */
    @Override
    public ProductLabel selectProductLabelById(Long id)
    {
        return productLabelMapper.selectProductLabelById(id);
    }

    /**
     * 查询商品标签列表
     * 
     * @param productLabel 商品标签
     * @return 商品标签
     */
    @Override
    public List<ProductLabel> selectProductLabelList(ProductLabel productLabel)
    {
        return productLabelMapper.selectProductLabelList(productLabel);
    }

    /**
     * 新增商品标签
     * 
     * @param productLabel 商品标签
     * @return 结果
     */
    @Override
    public int insertProductLabel(ProductLabel productLabel)
    {
        productLabel.setCreateTime(DateUtils.getNowDate());
        return productLabelMapper.insertProductLabel(productLabel);
    }

    /**
     * 修改商品标签
     * 
     * @param productLabel 商品标签
     * @return 结果
     */
    @Override
    public int updateProductLabel(ProductLabel productLabel)
    {
        productLabel.setUpdateTime(DateUtils.getNowDate());
        return productLabelMapper.updateProductLabel(productLabel);
    }

    /**
     * 批量删除商品标签
     * 
     * @param ids 需要删除的商品标签主键
     * @return 结果
     */
    @Override
    public int deleteProductLabelByIds(Long[] ids)
    {
        return productLabelMapper.deleteProductLabelByIds(ids);
    }

    /**
     * 删除商品标签信息
     * 
     * @param id 商品标签主键
     * @return 结果
     */
    @Override
    public int deleteProductLabelById(Long id)
    {
        return productLabelMapper.deleteProductLabelById(id);
    }
}
