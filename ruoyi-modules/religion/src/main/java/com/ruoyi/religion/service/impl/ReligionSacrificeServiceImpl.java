package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionSacrificeMapper;
import com.ruoyi.religion.domain.ReligionSacrifice;
import com.ruoyi.religion.service.IReligionSacrificeService;

/**
 * 民间烧香点Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@Service
public class ReligionSacrificeServiceImpl implements IReligionSacrificeService 
{
    @Autowired
    private ReligionSacrificeMapper religionSacrificeMapper;

    /**
     * 查询民间烧香点
     * 
     * @param id 民间烧香点主键
     * @return 民间烧香点
     */
    @Override
    public ReligionSacrifice selectReligionSacrificeById(Long id)
    {
        return religionSacrificeMapper.selectReligionSacrificeById(id);
    }

    /**
     * 查询民间烧香点列表
     * 
     * @param religionSacrifice 民间烧香点
     * @return 民间烧香点
     */
    @Override
    public List<ReligionSacrifice> selectReligionSacrificeList(ReligionSacrifice religionSacrifice)
    {
        return religionSacrificeMapper.selectReligionSacrificeList(religionSacrifice);
    }

    /**
     * 新增民间烧香点
     * 
     * @param religionSacrifice 民间烧香点
     * @return 结果
     */
    @Override
    public int insertReligionSacrifice(ReligionSacrifice religionSacrifice)
    {
        religionSacrifice.setCreateTime(DateUtils.getNowDate());
        return religionSacrificeMapper.insertReligionSacrifice(religionSacrifice);
    }

    /**
     * 修改民间烧香点
     * 
     * @param religionSacrifice 民间烧香点
     * @return 结果
     */
    @Override
    public int updateReligionSacrifice(ReligionSacrifice religionSacrifice)
    {
        religionSacrifice.setUpdateTime(DateUtils.getNowDate());
        return religionSacrificeMapper.updateReligionSacrifice(religionSacrifice);
    }

    /**
     * 批量删除民间烧香点
     * 
     * @param ids 需要删除的民间烧香点主键
     * @return 结果
     */
    @Override
    public int deleteReligionSacrificeByIds(Long[] ids)
    {
        return religionSacrificeMapper.deleteReligionSacrificeByIds(ids);
    }

    /**
     * 删除民间烧香点信息
     * 
     * @param id 民间烧香点主键
     * @return 结果
     */
    @Override
    public int deleteReligionSacrificeById(Long id)
    {
        return religionSacrificeMapper.deleteReligionSacrificeById(id);
    }
}
