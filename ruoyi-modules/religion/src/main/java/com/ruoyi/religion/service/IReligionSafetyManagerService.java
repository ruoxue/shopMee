package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionSafetyManager;

/**
 * 场所消防检查Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
public interface IReligionSafetyManagerService 
{
    /**
     * 查询场所消防检查
     * 
     * @param id 场所消防检查主键
     * @return 场所消防检查
     */
    public ReligionSafetyManager selectReligionSafetyManagerById(Long id);

    /**
     * 查询场所消防检查列表
     * 
     * @param religionSafetyManager 场所消防检查
     * @return 场所消防检查集合
     */
    public List<ReligionSafetyManager> selectReligionSafetyManagerList(ReligionSafetyManager religionSafetyManager);

    /**
     * 新增场所消防检查
     * 
     * @param religionSafetyManager 场所消防检查
     * @return 结果
     */
    public int insertReligionSafetyManager(ReligionSafetyManager religionSafetyManager);

    /**
     * 修改场所消防检查
     * 
     * @param religionSafetyManager 场所消防检查
     * @return 结果
     */
    public int updateReligionSafetyManager(ReligionSafetyManager religionSafetyManager);

    /**
     * 批量删除场所消防检查
     * 
     * @param ids 需要删除的场所消防检查主键集合
     * @return 结果
     */
    public int deleteReligionSafetyManagerByIds(Long[] ids);

    /**
     * 删除场所消防检查信息
     * 
     * @param id 场所消防检查主键
     * @return 结果
     */
    public int deleteReligionSafetyManagerById(Long id);
}
