package com.ruoyi.order.mapper;

import java.util.List;
import com.ruoyi.order.domain.ProductBanner;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author xiaoming
 * @date 2022-08-28
 */
public interface ProductBannerMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public ProductBanner selectProductBannerById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param productBanner 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ProductBanner> selectProductBannerList(ProductBanner productBanner);

    /**
     * 新增【请填写功能名称】
     * 
     * @param productBanner 【请填写功能名称】
     * @return 结果
     */
    public int insertProductBanner(ProductBanner productBanner);

    /**
     * 修改【请填写功能名称】
     * 
     * @param productBanner 【请填写功能名称】
     * @return 结果
     */
    public int updateProductBanner(ProductBanner productBanner);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteProductBannerById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductBannerByIds(Long[] ids);
}
