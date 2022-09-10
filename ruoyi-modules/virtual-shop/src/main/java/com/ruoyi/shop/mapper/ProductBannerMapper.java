package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.ProductBanner;

/**
 * bannerMapper接口
 * 
 * @author xiaoming
 * @date 2022-08-29
 */
public interface ProductBannerMapper 
{
    /**
     * 查询banner
     * 
     * @param id banner主键
     * @return banner
     */
    public ProductBanner selectProductBannerById(Long id);

    /**
     * 查询banner列表
     * 
     * @param productBanner banner
     * @return banner集合
     */
    public List<ProductBanner> selectProductBannerList(ProductBanner productBanner);

    /**
     * 新增banner
     * 
     * @param productBanner banner
     * @return 结果
     */
    public int insertProductBanner(ProductBanner productBanner);

    /**
     * 修改banner
     * 
     * @param productBanner banner
     * @return 结果
     */
    public int updateProductBanner(ProductBanner productBanner);

    /**
     * 删除banner
     * 
     * @param id banner主键
     * @return 结果
     */
    public int deleteProductBannerById(Long id);

    /**
     * 批量删除banner
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductBannerByIds(Long[] ids);
}
