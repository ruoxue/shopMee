package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionDayCheck;

/**
 * 日常检查Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 23:25:24
 */
public interface IReligionDayCheckService 
{
    /**
     * 查询日常检查
     * 
     * @param id 日常检查主键
     * @return 日常检查
     */
    public ReligionDayCheck selectReligionDayCheckById(Long id);

    /**
     * 查询日常检查列表
     * 
     * @param religionDayCheck 日常检查
     * @return 日常检查集合
     */
    public List<ReligionDayCheck> selectReligionDayCheckList(ReligionDayCheck religionDayCheck);

    /**
     * 新增日常检查
     * 
     * @param religionDayCheck 日常检查
     * @return 结果
     */
    public int insertReligionDayCheck(ReligionDayCheck religionDayCheck);

    /**
     * 修改日常检查
     * 
     * @param religionDayCheck 日常检查
     * @return 结果
     */
    public int updateReligionDayCheck(ReligionDayCheck religionDayCheck);

    /**
     * 批量删除日常检查
     * 
     * @param ids 需要删除的日常检查主键集合
     * @return 结果
     */
    public int deleteReligionDayCheckByIds(Long[] ids);

    /**
     * 删除日常检查信息
     * 
     * @param id 日常检查主键
     * @return 结果
     */
    public int deleteReligionDayCheckById(Long id);
}
