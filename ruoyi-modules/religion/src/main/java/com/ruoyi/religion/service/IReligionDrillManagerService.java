package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionDrillManager;

/**
 * 消防演练管理Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
public interface IReligionDrillManagerService 
{
    /**
     * 查询消防演练管理
     * 
     * @param id 消防演练管理主键
     * @return 消防演练管理
     */
    public ReligionDrillManager selectReligionDrillManagerById(Long id);

    /**
     * 查询消防演练管理列表
     * 
     * @param religionDrillManager 消防演练管理
     * @return 消防演练管理集合
     */
    public List<ReligionDrillManager> selectReligionDrillManagerList(ReligionDrillManager religionDrillManager);

    /**
     * 新增消防演练管理
     * 
     * @param religionDrillManager 消防演练管理
     * @return 结果
     */
    public int insertReligionDrillManager(ReligionDrillManager religionDrillManager);

    /**
     * 修改消防演练管理
     * 
     * @param religionDrillManager 消防演练管理
     * @return 结果
     */
    public int updateReligionDrillManager(ReligionDrillManager religionDrillManager);

    /**
     * 批量删除消防演练管理
     * 
     * @param ids 需要删除的消防演练管理主键集合
     * @return 结果
     */
    public int deleteReligionDrillManagerByIds(Long[] ids);

    /**
     * 删除消防演练管理信息
     * 
     * @param id 消防演练管理主键
     * @return 结果
     */
    public int deleteReligionDrillManagerById(Long id);
}
