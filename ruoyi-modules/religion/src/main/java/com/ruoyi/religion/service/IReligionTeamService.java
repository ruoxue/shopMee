package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionTeam;

/**
 * 团体Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:33
 */
public interface IReligionTeamService 
{
    /**
     * 查询团体
     * 
     * @param id 团体主键
     * @return 团体
     */
    public ReligionTeam selectReligionTeamById(Long id);

    /**
     * 查询团体列表
     * 
     * @param religionTeam 团体
     * @return 团体集合
     */
    public List<ReligionTeam> selectReligionTeamList(ReligionTeam religionTeam);

    /**
     * 新增团体
     * 
     * @param religionTeam 团体
     * @return 结果
     */
    public int insertReligionTeam(ReligionTeam religionTeam);

    /**
     * 修改团体
     * 
     * @param religionTeam 团体
     * @return 结果
     */
    public int updateReligionTeam(ReligionTeam religionTeam);

    /**
     * 批量删除团体
     * 
     * @param ids 需要删除的团体主键集合
     * @return 结果
     */
    public int deleteReligionTeamByIds(Long[] ids);

    /**
     * 删除团体信息
     * 
     * @param id 团体主键
     * @return 结果
     */
    public int deleteReligionTeamById(Long id);
}
