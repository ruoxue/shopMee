package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionBuildSafeManager;

/**
 * 建筑安全隐患排查Mapper接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
public interface ReligionBuildSafeManagerMapper 
{
    /**
     * 查询建筑安全隐患排查
     * 
     * @param id 建筑安全隐患排查主键
     * @return 建筑安全隐患排查
     */
    public ReligionBuildSafeManager selectReligionBuildSafeManagerById(Long id);

    /**
     * 查询建筑安全隐患排查列表
     * 
     * @param religionBuildSafeManager 建筑安全隐患排查
     * @return 建筑安全隐患排查集合
     */
    public List<ReligionBuildSafeManager> selectReligionBuildSafeManagerList(ReligionBuildSafeManager religionBuildSafeManager);

    /**
     * 新增建筑安全隐患排查
     * 
     * @param religionBuildSafeManager 建筑安全隐患排查
     * @return 结果
     */
    public int insertReligionBuildSafeManager(ReligionBuildSafeManager religionBuildSafeManager);

    /**
     * 修改建筑安全隐患排查
     * 
     * @param religionBuildSafeManager 建筑安全隐患排查
     * @return 结果
     */
    public int updateReligionBuildSafeManager(ReligionBuildSafeManager religionBuildSafeManager);

    /**
     * 删除建筑安全隐患排查
     * 
     * @param id 建筑安全隐患排查主键
     * @return 结果
     */
    public int deleteReligionBuildSafeManagerById(Long id);

    /**
     * 批量删除建筑安全隐患排查
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionBuildSafeManagerByIds(Long[] ids);
}
