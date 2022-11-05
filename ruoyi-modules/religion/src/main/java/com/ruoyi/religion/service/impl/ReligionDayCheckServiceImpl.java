package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionDayCheckMapper;
import com.ruoyi.religion.domain.ReligionDayCheck;
import com.ruoyi.religion.service.IReligionDayCheckService;

/**
 * 日常检查Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 23:25:24
 */
@Service
public class ReligionDayCheckServiceImpl implements IReligionDayCheckService 
{
    @Autowired
    private ReligionDayCheckMapper religionDayCheckMapper;

    /**
     * 查询日常检查
     * 
     * @param id 日常检查主键
     * @return 日常检查
     */
    @Override
    public ReligionDayCheck selectReligionDayCheckById(Long id)
    {
        return religionDayCheckMapper.selectReligionDayCheckById(id);
    }

    /**
     * 查询日常检查列表
     * 
     * @param religionDayCheck 日常检查
     * @return 日常检查
     */
    @Override
    public List<ReligionDayCheck> selectReligionDayCheckList(ReligionDayCheck religionDayCheck)
    {
        return religionDayCheckMapper.selectReligionDayCheckList(religionDayCheck);
    }

    /**
     * 新增日常检查
     * 
     * @param religionDayCheck 日常检查
     * @return 结果
     */
    @Override
    public int insertReligionDayCheck(ReligionDayCheck religionDayCheck)
    {
        religionDayCheck.setCreateTime(DateUtils.getNowDate());
        return religionDayCheckMapper.insertReligionDayCheck(religionDayCheck);
    }

    /**
     * 修改日常检查
     * 
     * @param religionDayCheck 日常检查
     * @return 结果
     */
    @Override
    public int updateReligionDayCheck(ReligionDayCheck religionDayCheck)
    {
        religionDayCheck.setUpdateTime(DateUtils.getNowDate());
        return religionDayCheckMapper.updateReligionDayCheck(religionDayCheck);
    }

    /**
     * 批量删除日常检查
     * 
     * @param ids 需要删除的日常检查主键
     * @return 结果
     */
    @Override
    public int deleteReligionDayCheckByIds(Long[] ids)
    {
        return religionDayCheckMapper.deleteReligionDayCheckByIds(ids);
    }

    /**
     * 删除日常检查信息
     * 
     * @param id 日常检查主键
     * @return 结果
     */
    @Override
    public int deleteReligionDayCheckById(Long id)
    {
        return religionDayCheckMapper.deleteReligionDayCheckById(id);
    }
}
