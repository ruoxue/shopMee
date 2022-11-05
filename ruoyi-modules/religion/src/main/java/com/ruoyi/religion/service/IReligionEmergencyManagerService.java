package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionEmergencyManager;

/**
 * 应急预案管理Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
public interface IReligionEmergencyManagerService 
{
    /**
     * 查询应急预案管理
     * 
     * @param id 应急预案管理主键
     * @return 应急预案管理
     */
    public ReligionEmergencyManager selectReligionEmergencyManagerById(Long id);

    /**
     * 查询应急预案管理列表
     * 
     * @param religionEmergencyManager 应急预案管理
     * @return 应急预案管理集合
     */
    public List<ReligionEmergencyManager> selectReligionEmergencyManagerList(ReligionEmergencyManager religionEmergencyManager);

    /**
     * 新增应急预案管理
     * 
     * @param religionEmergencyManager 应急预案管理
     * @return 结果
     */
    public int insertReligionEmergencyManager(ReligionEmergencyManager religionEmergencyManager);

    /**
     * 修改应急预案管理
     * 
     * @param religionEmergencyManager 应急预案管理
     * @return 结果
     */
    public int updateReligionEmergencyManager(ReligionEmergencyManager religionEmergencyManager);

    /**
     * 批量删除应急预案管理
     * 
     * @param ids 需要删除的应急预案管理主键集合
     * @return 结果
     */
    public int deleteReligionEmergencyManagerByIds(Long[] ids);

    /**
     * 删除应急预案管理信息
     * 
     * @param id 应急预案管理主键
     * @return 结果
     */
    public int deleteReligionEmergencyManagerById(Long id);
}
