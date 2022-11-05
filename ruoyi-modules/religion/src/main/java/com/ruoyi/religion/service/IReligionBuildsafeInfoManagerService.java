package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionBuildsafeInfoManager;

/**
 * 建筑隐患信息上报Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
public interface IReligionBuildsafeInfoManagerService 
{
    /**
     * 查询建筑隐患信息上报
     * 
     * @param id 建筑隐患信息上报主键
     * @return 建筑隐患信息上报
     */
    public ReligionBuildsafeInfoManager selectReligionBuildsafeInfoManagerById(Long id);

    /**
     * 查询建筑隐患信息上报列表
     * 
     * @param religionBuildsafeInfoManager 建筑隐患信息上报
     * @return 建筑隐患信息上报集合
     */
    public List<ReligionBuildsafeInfoManager> selectReligionBuildsafeInfoManagerList(ReligionBuildsafeInfoManager religionBuildsafeInfoManager);

    /**
     * 新增建筑隐患信息上报
     * 
     * @param religionBuildsafeInfoManager 建筑隐患信息上报
     * @return 结果
     */
    public int insertReligionBuildsafeInfoManager(ReligionBuildsafeInfoManager religionBuildsafeInfoManager);

    /**
     * 修改建筑隐患信息上报
     * 
     * @param religionBuildsafeInfoManager 建筑隐患信息上报
     * @return 结果
     */
    public int updateReligionBuildsafeInfoManager(ReligionBuildsafeInfoManager religionBuildsafeInfoManager);

    /**
     * 批量删除建筑隐患信息上报
     * 
     * @param ids 需要删除的建筑隐患信息上报主键集合
     * @return 结果
     */
    public int deleteReligionBuildsafeInfoManagerByIds(Long[] ids);

    /**
     * 删除建筑隐患信息上报信息
     * 
     * @param id 建筑隐患信息上报主键
     * @return 结果
     */
    public int deleteReligionBuildsafeInfoManagerById(Long id);
}
