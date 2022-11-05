package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionBuildingManager;

/**
 * 场所建设登记管理Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
public interface IReligionBuildingManagerService 
{
    /**
     * 查询场所建设登记管理
     * 
     * @param id 场所建设登记管理主键
     * @return 场所建设登记管理
     */
    public ReligionBuildingManager selectReligionBuildingManagerById(Long id);

    /**
     * 查询场所建设登记管理列表
     * 
     * @param religionBuildingManager 场所建设登记管理
     * @return 场所建设登记管理集合
     */
    public List<ReligionBuildingManager> selectReligionBuildingManagerList(ReligionBuildingManager religionBuildingManager);

    /**
     * 新增场所建设登记管理
     * 
     * @param religionBuildingManager 场所建设登记管理
     * @return 结果
     */
    public int insertReligionBuildingManager(ReligionBuildingManager religionBuildingManager);

    /**
     * 修改场所建设登记管理
     * 
     * @param religionBuildingManager 场所建设登记管理
     * @return 结果
     */
    public int updateReligionBuildingManager(ReligionBuildingManager religionBuildingManager);

    /**
     * 批量删除场所建设登记管理
     * 
     * @param ids 需要删除的场所建设登记管理主键集合
     * @return 结果
     */
    public int deleteReligionBuildingManagerByIds(Long[] ids);

    /**
     * 删除场所建设登记管理信息
     * 
     * @param id 场所建设登记管理主键
     * @return 结果
     */
    public int deleteReligionBuildingManagerById(Long id);
}
