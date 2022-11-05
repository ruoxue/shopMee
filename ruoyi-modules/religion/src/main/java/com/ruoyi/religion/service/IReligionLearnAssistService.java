package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionLearnAssist;

/**
 * 学习辅助Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 23:25:25
 */
public interface IReligionLearnAssistService 
{
    /**
     * 查询学习辅助
     * 
     * @param id 学习辅助主键
     * @return 学习辅助
     */
    public ReligionLearnAssist selectReligionLearnAssistById(Long id);

    /**
     * 查询学习辅助列表
     * 
     * @param religionLearnAssist 学习辅助
     * @return 学习辅助集合
     */
    public List<ReligionLearnAssist> selectReligionLearnAssistList(ReligionLearnAssist religionLearnAssist);

    /**
     * 新增学习辅助
     * 
     * @param religionLearnAssist 学习辅助
     * @return 结果
     */
    public int insertReligionLearnAssist(ReligionLearnAssist religionLearnAssist);

    /**
     * 修改学习辅助
     * 
     * @param religionLearnAssist 学习辅助
     * @return 结果
     */
    public int updateReligionLearnAssist(ReligionLearnAssist religionLearnAssist);

    /**
     * 批量删除学习辅助
     * 
     * @param ids 需要删除的学习辅助主键集合
     * @return 结果
     */
    public int deleteReligionLearnAssistByIds(Long[] ids);

    /**
     * 删除学习辅助信息
     * 
     * @param id 学习辅助主键
     * @return 结果
     */
    public int deleteReligionLearnAssistById(Long id);
}
