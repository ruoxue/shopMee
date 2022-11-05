package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionEmergencyRecord;

/**
 * 突发事件记录Mapper接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
public interface ReligionEmergencyRecordMapper 
{
    /**
     * 查询突发事件记录
     * 
     * @param id 突发事件记录主键
     * @return 突发事件记录
     */
    public ReligionEmergencyRecord selectReligionEmergencyRecordById(Long id);

    /**
     * 查询突发事件记录列表
     * 
     * @param religionEmergencyRecord 突发事件记录
     * @return 突发事件记录集合
     */
    public List<ReligionEmergencyRecord> selectReligionEmergencyRecordList(ReligionEmergencyRecord religionEmergencyRecord);

    /**
     * 新增突发事件记录
     * 
     * @param religionEmergencyRecord 突发事件记录
     * @return 结果
     */
    public int insertReligionEmergencyRecord(ReligionEmergencyRecord religionEmergencyRecord);

    /**
     * 修改突发事件记录
     * 
     * @param religionEmergencyRecord 突发事件记录
     * @return 结果
     */
    public int updateReligionEmergencyRecord(ReligionEmergencyRecord religionEmergencyRecord);

    /**
     * 删除突发事件记录
     * 
     * @param id 突发事件记录主键
     * @return 结果
     */
    public int deleteReligionEmergencyRecordById(Long id);

    /**
     * 批量删除突发事件记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionEmergencyRecordByIds(Long[] ids);
}
