package com.ruoyi.shop.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ProductLabelMapMapper;
import com.ruoyi.shop.domain.ProductLabelMap;
import com.ruoyi.shop.service.IProductLabelMapService;

/**
 * 商品标签对应关系Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@Service
public class ProductLabelMapServiceImpl implements IProductLabelMapService 
{
    @Autowired
    private ProductLabelMapMapper productLabelMapMapper;

    /**
     * 查询商品标签对应关系
     * 
     * @param id 商品标签对应关系主键
     * @return 商品标签对应关系
     */
    @Override
    public ProductLabelMap selectProductLabelMapById(String id)
    {
        return productLabelMapMapper.selectProductLabelMapById(id);
    }

    /**
     * 查询商品标签对应关系列表
     * 
     * @param productLabelMap 商品标签对应关系
     * @return 商品标签对应关系
     */
    @Override
    public List<ProductLabelMap> selectProductLabelMapList(ProductLabelMap productLabelMap)
    {
        return productLabelMapMapper.selectProductLabelMapList(productLabelMap);
    }

    /**
     * 新增商品标签对应关系
     * 
     * @param productLabelMap 商品标签对应关系
     * @return 结果
     */
    @Override
    public int insertProductLabelMap(ProductLabelMap productLabelMap)
    {
        productLabelMap.setCreateTime(DateUtils.getNowDate());
        return productLabelMapMapper.insertProductLabelMap(productLabelMap);
    }

    /**
     * 修改商品标签对应关系
     * 
     * @param productLabelMap 商品标签对应关系
     * @return 结果
     */
    @Override
    public int updateProductLabelMap(ProductLabelMap productLabelMap)
    {
        productLabelMap.setUpdateTime(DateUtils.getNowDate());
        return productLabelMapMapper.updateProductLabelMap(productLabelMap);
    }

    /**
     * 批量删除商品标签对应关系
     * 
     * @param ids 需要删除的商品标签对应关系主键
     * @return 结果
     */
    @Override
    public int deleteProductLabelMapByIds(String[] ids)
    {
        return productLabelMapMapper.deleteProductLabelMapByIds(ids);
    }

    /**
     * 删除商品标签对应关系信息
     * 
     * @param id 商品标签对应关系主键
     * @return 结果
     */
    @Override
    public int deleteProductLabelMapById(String id)
    {
        return productLabelMapMapper.deleteProductLabelMapById(id);
    }
}
