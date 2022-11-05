package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionLearnAssistMapper;
import com.ruoyi.religion.domain.ReligionLearnAssist;
import com.ruoyi.religion.service.IReligionLearnAssistService;

/**
 * 学习辅助Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 23:25:25
 */
@Service
public class ReligionLearnAssistServiceImpl implements IReligionLearnAssistService 
{
    @Autowired
    private ReligionLearnAssistMapper religionLearnAssistMapper;

    /**
     * 查询学习辅助
     * 
     * @param id 学习辅助主键
     * @return 学习辅助
     */
    @Override
    public ReligionLearnAssist selectReligionLearnAssistById(Long id)
    {
        return religionLearnAssistMapper.selectReligionLearnAssistById(id);
    }

    /**
     * 查询学习辅助列表
     * 
     * @param religionLearnAssist 学习辅助
     * @return 学习辅助
     */
    @Override
    public List<ReligionLearnAssist> selectReligionLearnAssistList(ReligionLearnAssist religionLearnAssist)
    {
        return religionLearnAssistMapper.selectReligionLearnAssistList(religionLearnAssist);
    }

    /**
     * 新增学习辅助
     * 
     * @param religionLearnAssist 学习辅助
     * @return 结果
     */
    @Override
    public int insertReligionLearnAssist(ReligionLearnAssist religionLearnAssist)
    {
        religionLearnAssist.setCreateTime(DateUtils.getNowDate());
        return religionLearnAssistMapper.insertReligionLearnAssist(religionLearnAssist);
    }

    /**
     * 修改学习辅助
     * 
     * @param religionLearnAssist 学习辅助
     * @return 结果
     */
    @Override
    public int updateReligionLearnAssist(ReligionLearnAssist religionLearnAssist)
    {
        religionLearnAssist.setUpdateTime(DateUtils.getNowDate());
        return religionLearnAssistMapper.updateReligionLearnAssist(religionLearnAssist);
    }

    /**
     * 批量删除学习辅助
     * 
     * @param ids 需要删除的学习辅助主键
     * @return 结果
     */
    @Override
    public int deleteReligionLearnAssistByIds(Long[] ids)
    {
        return religionLearnAssistMapper.deleteReligionLearnAssistByIds(ids);
    }

    /**
     * 删除学习辅助信息
     * 
     * @param id 学习辅助主键
     * @return 结果
     */
    @Override
    public int deleteReligionLearnAssistById(Long id)
    {
        return religionLearnAssistMapper.deleteReligionLearnAssistById(id);
    }
}
