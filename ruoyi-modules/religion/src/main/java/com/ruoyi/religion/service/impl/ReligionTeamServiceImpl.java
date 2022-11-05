package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionTeamMapper;
import com.ruoyi.religion.domain.ReligionTeam;
import com.ruoyi.religion.service.IReligionTeamService;

/**
 * 团体Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:33
 */
@Service
public class ReligionTeamServiceImpl implements IReligionTeamService 
{
    @Autowired
    private ReligionTeamMapper religionTeamMapper;

    /**
     * 查询团体
     * 
     * @param id 团体主键
     * @return 团体
     */
    @Override
    public ReligionTeam selectReligionTeamById(Long id)
    {
        return religionTeamMapper.selectReligionTeamById(id);
    }

    /**
     * 查询团体列表
     * 
     * @param religionTeam 团体
     * @return 团体
     */
    @Override
    public List<ReligionTeam> selectReligionTeamList(ReligionTeam religionTeam)
    {
        return religionTeamMapper.selectReligionTeamList(religionTeam);
    }

    /**
     * 新增团体
     * 
     * @param religionTeam 团体
     * @return 结果
     */
    @Override
    public int insertReligionTeam(ReligionTeam religionTeam)
    {
        religionTeam.setCreateTime(DateUtils.getNowDate());
        return religionTeamMapper.insertReligionTeam(religionTeam);
    }

    /**
     * 修改团体
     * 
     * @param religionTeam 团体
     * @return 结果
     */
    @Override
    public int updateReligionTeam(ReligionTeam religionTeam)
    {
        religionTeam.setUpdateTime(DateUtils.getNowDate());
        return religionTeamMapper.updateReligionTeam(religionTeam);
    }

    /**
     * 批量删除团体
     * 
     * @param ids 需要删除的团体主键
     * @return 结果
     */
    @Override
    public int deleteReligionTeamByIds(Long[] ids)
    {
        return religionTeamMapper.deleteReligionTeamByIds(ids);
    }

    /**
     * 删除团体信息
     * 
     * @param id 团体主键
     * @return 结果
     */
    @Override
    public int deleteReligionTeamById(Long id)
    {
        return religionTeamMapper.deleteReligionTeamById(id);
    }
}
