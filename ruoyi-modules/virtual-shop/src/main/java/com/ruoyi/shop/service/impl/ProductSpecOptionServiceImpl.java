package com.ruoyi.shop.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ProductSpecOptionMapper;
import com.ruoyi.shop.domain.ProductSpecOption;
import com.ruoyi.shop.service.IProductSpecOptionService;

/**
 * 商品规格项Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@Service
public class ProductSpecOptionServiceImpl implements IProductSpecOptionService 
{
    @Autowired
    private ProductSpecOptionMapper productSpecOptionMapper;

    /**
     * 查询商品规格项
     * 
     * @param id 商品规格项主键
     * @return 商品规格项
     */
    @Override
    public ProductSpecOption selectProductSpecOptionById(Long id)
    {
        return productSpecOptionMapper.selectProductSpecOptionById(id);
    }

    /**
     * 查询商品规格项列表
     * 
     * @param productSpecOption 商品规格项
     * @return 商品规格项
     */
    @Override
    public List<ProductSpecOption> selectProductSpecOptionList(ProductSpecOption productSpecOption)
    {
        return productSpecOptionMapper.selectProductSpecOptionList(productSpecOption);
    }

    /**
     * 新增商品规格项
     * 
     * @param productSpecOption 商品规格项
     * @return 结果
     */
    @Override
    public int insertProductSpecOption(ProductSpecOption productSpecOption)
    {
        productSpecOption.setCreateTime(DateUtils.getNowDate());
        return productSpecOptionMapper.insertProductSpecOption(productSpecOption);
    }

    /**
     * 修改商品规格项
     * 
     * @param productSpecOption 商品规格项
     * @return 结果
     */
    @Override
    public int updateProductSpecOption(ProductSpecOption productSpecOption)
    {
        productSpecOption.setUpdateTime(DateUtils.getNowDate());
        return productSpecOptionMapper.updateProductSpecOption(productSpecOption);
    }

    /**
     * 批量删除商品规格项
     * 
     * @param ids 需要删除的商品规格项主键
     * @return 结果
     */
    @Override
    public int deleteProductSpecOptionByIds(String[] ids)
    {
        return productSpecOptionMapper.deleteProductSpecOptionByIds(ids);
    }

    /**
     * 删除商品规格项信息
     * 
     * @param id 商品规格项主键
     * @return 结果
     */
    @Override
    public int deleteProductSpecOptionById(String id)
    {
        return productSpecOptionMapper.deleteProductSpecOptionById(id);
    }

    @Override
    public List<ProductSpecOption> selectProductSpecOptionListBy(String specName, Long goodsId) {
        ProductSpecOption productSpecOption=new ProductSpecOption();
        productSpecOption.setGoodsId(goodsId);
        productSpecOption.setName(specName);
        return productSpecOptionMapper.selectProductSpecOptionList(productSpecOption);
    }

    @Override
    public List<ProductSpecOption> selectProductSpecOptionNameListBy(Long specId, Long goodsId) {
        ProductSpecOption productSpecOption=new ProductSpecOption();
        productSpecOption.setGoodsId(goodsId);
        productSpecOption.setSpecId(specId);
        return productSpecOptionMapper.selectProductSpecOptionList(productSpecOption);
    }
}
