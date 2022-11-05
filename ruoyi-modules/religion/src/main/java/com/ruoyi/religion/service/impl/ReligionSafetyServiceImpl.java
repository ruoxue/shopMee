package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionSafetyMapper;
import com.ruoyi.religion.domain.ReligionSafety;
import com.ruoyi.religion.service.IReligionSafetyService;

/**
 * 消防场所Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@Service
public class ReligionSafetyServiceImpl implements IReligionSafetyService 
{
    @Autowired
    private ReligionSafetyMapper religionSafetyMapper;

    /**
     * 查询消防场所
     * 
     * @param id 消防场所主键
     * @return 消防场所
     */
    @Override
    public ReligionSafety selectReligionSafetyById(Long id)
    {
        return religionSafetyMapper.selectReligionSafetyById(id);
    }

    /**
     * 查询消防场所列表
     * 
     * @param religionSafety 消防场所
     * @return 消防场所
     */
    @Override
    public List<ReligionSafety> selectReligionSafetyList(ReligionSafety religionSafety)
    {
        return religionSafetyMapper.selectReligionSafetyList(religionSafety);
    }

    /**
     * 新增消防场所
     * 
     * @param religionSafety 消防场所
     * @return 结果
     */
    @Override
    public int insertReligionSafety(ReligionSafety religionSafety)
    {
        religionSafety.setCreateTime(DateUtils.getNowDate());
        return religionSafetyMapper.insertReligionSafety(religionSafety);
    }

    /**
     * 修改消防场所
     * 
     * @param religionSafety 消防场所
     * @return 结果
     */
    @Override
    public int updateReligionSafety(ReligionSafety religionSafety)
    {
        religionSafety.setUpdateTime(DateUtils.getNowDate());
        return religionSafetyMapper.updateReligionSafety(religionSafety);
    }

    /**
     * 批量删除消防场所
     * 
     * @param ids 需要删除的消防场所主键
     * @return 结果
     */
    @Override
    public int deleteReligionSafetyByIds(Long[] ids)
    {
        return religionSafetyMapper.deleteReligionSafetyByIds(ids);
    }

    /**
     * 删除消防场所信息
     * 
     * @param id 消防场所主键
     * @return 结果
     */
    @Override
    public int deleteReligionSafetyById(Long id)
    {
        return religionSafetyMapper.deleteReligionSafetyById(id);
    }
}
