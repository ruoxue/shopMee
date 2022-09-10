package com.ruoyi.shop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.GdptAdvertMapper;
import com.ruoyi.shop.domain.GdptAdvert;
import com.ruoyi.shop.service.IGdptAdvertService;

/**
 * 广告Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@Service
public class GdptAdvertServiceImpl implements IGdptAdvertService 
{
    @Autowired
    private GdptAdvertMapper gdptAdvertMapper;

    /**
     * 查询广告
     * 
     * @param id 广告主键
     * @return 广告
     */
    @Override
    public GdptAdvert selectGdptAdvertById(String id)
    {
        return gdptAdvertMapper.selectGdptAdvertById(id);
    }

    /**
     * 查询广告列表
     * 
     * @param gdptAdvert 广告
     * @return 广告
     */
    @Override
    public List<GdptAdvert> selectGdptAdvertList(GdptAdvert gdptAdvert)
    {
        return gdptAdvertMapper.selectGdptAdvertList(gdptAdvert);
    }

    /**
     * 新增广告
     * 
     * @param gdptAdvert 广告
     * @return 结果
     */
    @Override
    public int insertGdptAdvert(GdptAdvert gdptAdvert)
    {
        return gdptAdvertMapper.insertGdptAdvert(gdptAdvert);
    }

    /**
     * 修改广告
     * 
     * @param gdptAdvert 广告
     * @return 结果
     */
    @Override
    public int updateGdptAdvert(GdptAdvert gdptAdvert)
    {
        return gdptAdvertMapper.updateGdptAdvert(gdptAdvert);
    }

    /**
     * 批量删除广告
     * 
     * @param ids 需要删除的广告主键
     * @return 结果
     */
    @Override
    public int deleteGdptAdvertByIds(String[] ids)
    {
        return gdptAdvertMapper.deleteGdptAdvertByIds(ids);
    }

    /**
     * 删除广告信息
     * 
     * @param id 广告主键
     * @return 结果
     */
    @Override
    public int deleteGdptAdvertById(String id)
    {
        return gdptAdvertMapper.deleteGdptAdvertById(id);
    }
}
