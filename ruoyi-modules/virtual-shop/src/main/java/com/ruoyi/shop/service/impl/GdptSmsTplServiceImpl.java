package com.ruoyi.shop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.GdptSmsTplMapper;
import com.ruoyi.shop.domain.GdptSmsTpl;
import com.ruoyi.shop.service.IGdptSmsTplService;

/**
 * 短信模板Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@Service
public class GdptSmsTplServiceImpl implements IGdptSmsTplService 
{
    @Autowired
    private GdptSmsTplMapper gdptSmsTplMapper;

    /**
     * 查询短信模板
     * 
     * @param id 短信模板主键
     * @return 短信模板
     */
    @Override
    public GdptSmsTpl selectGdptSmsTplById(String id)
    {
        return gdptSmsTplMapper.selectGdptSmsTplById(id);
    }

    /**
     * 查询短信模板列表
     * 
     * @param gdptSmsTpl 短信模板
     * @return 短信模板
     */
    @Override
    public List<GdptSmsTpl> selectGdptSmsTplList(GdptSmsTpl gdptSmsTpl)
    {
        return gdptSmsTplMapper.selectGdptSmsTplList(gdptSmsTpl);
    }

    /**
     * 新增短信模板
     * 
     * @param gdptSmsTpl 短信模板
     * @return 结果
     */
    @Override
    public int insertGdptSmsTpl(GdptSmsTpl gdptSmsTpl)
    {
        return gdptSmsTplMapper.insertGdptSmsTpl(gdptSmsTpl);
    }

    /**
     * 修改短信模板
     * 
     * @param gdptSmsTpl 短信模板
     * @return 结果
     */
    @Override
    public int updateGdptSmsTpl(GdptSmsTpl gdptSmsTpl)
    {
        return gdptSmsTplMapper.updateGdptSmsTpl(gdptSmsTpl);
    }

    /**
     * 批量删除短信模板
     * 
     * @param ids 需要删除的短信模板主键
     * @return 结果
     */
    @Override
    public int deleteGdptSmsTplByIds(String[] ids)
    {
        return gdptSmsTplMapper.deleteGdptSmsTplByIds(ids);
    }

    /**
     * 删除短信模板信息
     * 
     * @param id 短信模板主键
     * @return 结果
     */
    @Override
    public int deleteGdptSmsTplById(String id)
    {
        return gdptSmsTplMapper.deleteGdptSmsTplById(id);
    }
}
