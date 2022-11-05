package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionEmergencyRecordMapper;
import com.ruoyi.religion.domain.ReligionEmergencyRecord;
import com.ruoyi.religion.service.IReligionEmergencyRecordService;

/**
 * 突发事件记录Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@Service
public class ReligionEmergencyRecordServiceImpl implements IReligionEmergencyRecordService 
{
    @Autowired
    private ReligionEmergencyRecordMapper religionEmergencyRecordMapper;

    /**
     * 查询突发事件记录
     * 
     * @param id 突发事件记录主键
     * @return 突发事件记录
     */
    @Override
    public ReligionEmergencyRecord selectReligionEmergencyRecordById(Long id)
    {
        return religionEmergencyRecordMapper.selectReligionEmergencyRecordById(id);
    }

    /**
     * 查询突发事件记录列表
     * 
     * @param religionEmergencyRecord 突发事件记录
     * @return 突发事件记录
     */
    @Override
    public List<ReligionEmergencyRecord> selectReligionEmergencyRecordList(ReligionEmergencyRecord religionEmergencyRecord)
    {
        return religionEmergencyRecordMapper.selectReligionEmergencyRecordList(religionEmergencyRecord);
    }

    /**
     * 新增突发事件记录
     * 
     * @param religionEmergencyRecord 突发事件记录
     * @return 结果
     */
    @Override
    public int insertReligionEmergencyRecord(ReligionEmergencyRecord religionEmergencyRecord)
    {
        religionEmergencyRecord.setCreateTime(DateUtils.getNowDate());
        return religionEmergencyRecordMapper.insertReligionEmergencyRecord(religionEmergencyRecord);
    }

    /**
     * 修改突发事件记录
     * 
     * @param religionEmergencyRecord 突发事件记录
     * @return 结果
     */
    @Override
    public int updateReligionEmergencyRecord(ReligionEmergencyRecord religionEmergencyRecord)
    {
        religionEmergencyRecord.setUpdateTime(DateUtils.getNowDate());
        return religionEmergencyRecordMapper.updateReligionEmergencyRecord(religionEmergencyRecord);
    }

    /**
     * 批量删除突发事件记录
     * 
     * @param ids 需要删除的突发事件记录主键
     * @return 结果
     */
    @Override
    public int deleteReligionEmergencyRecordByIds(Long[] ids)
    {
        return religionEmergencyRecordMapper.deleteReligionEmergencyRecordByIds(ids);
    }

    /**
     * 删除突发事件记录信息
     * 
     * @param id 突发事件记录主键
     * @return 结果
     */
    @Override
    public int deleteReligionEmergencyRecordById(Long id)
    {
        return religionEmergencyRecordMapper.deleteReligionEmergencyRecordById(id);
    }
}
