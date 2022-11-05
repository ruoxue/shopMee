package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionNationMapper;
import com.ruoyi.religion.domain.ReligionNation;
import com.ruoyi.religion.service.IReligionNationService;

/**
 * 民族Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@Service
public class ReligionNationServiceImpl implements IReligionNationService 
{
    @Autowired
    private ReligionNationMapper religionNationMapper;

    /**
     * 查询民族
     * 
     * @param id 民族主键
     * @return 民族
     */
    @Override
    public ReligionNation selectReligionNationById(Long id)
    {
        return religionNationMapper.selectReligionNationById(id);
    }

    /**
     * 查询民族列表
     * 
     * @param religionNation 民族
     * @return 民族
     */
    @Override
    public List<ReligionNation> selectReligionNationList(ReligionNation religionNation)
    {
        return religionNationMapper.selectReligionNationList(religionNation);
    }

    /**
     * 新增民族
     * 
     * @param religionNation 民族
     * @return 结果
     */
    @Override
    public int insertReligionNation(ReligionNation religionNation)
    {
        religionNation.setCreateTime(DateUtils.getNowDate());
        return religionNationMapper.insertReligionNation(religionNation);
    }

    /**
     * 修改民族
     * 
     * @param religionNation 民族
     * @return 结果
     */
    @Override
    public int updateReligionNation(ReligionNation religionNation)
    {
        religionNation.setUpdateTime(DateUtils.getNowDate());
        return religionNationMapper.updateReligionNation(religionNation);
    }

    /**
     * 批量删除民族
     * 
     * @param ids 需要删除的民族主键
     * @return 结果
     */
    @Override
    public int deleteReligionNationByIds(Long[] ids)
    {
        return religionNationMapper.deleteReligionNationByIds(ids);
    }

    /**
     * 删除民族信息
     * 
     * @param id 民族主键
     * @return 结果
     */
    @Override
    public int deleteReligionNationById(Long id)
    {
        return religionNationMapper.deleteReligionNationById(id);
    }
}
