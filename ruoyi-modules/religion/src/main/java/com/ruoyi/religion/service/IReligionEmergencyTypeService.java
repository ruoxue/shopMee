package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionEmergencyType;

/**
 * 场所突发应急管理Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
public interface IReligionEmergencyTypeService 
{
    /**
     * 查询场所突发应急管理
     * 
     * @param id 场所突发应急管理主键
     * @return 场所突发应急管理
     */
    public ReligionEmergencyType selectReligionEmergencyTypeById(Long id);

    /**
     * 查询场所突发应急管理列表
     * 
     * @param religionEmergencyType 场所突发应急管理
     * @return 场所突发应急管理集合
     */
    public List<ReligionEmergencyType> selectReligionEmergencyTypeList(ReligionEmergencyType religionEmergencyType);

    /**
     * 新增场所突发应急管理
     * 
     * @param religionEmergencyType 场所突发应急管理
     * @return 结果
     */
    public int insertReligionEmergencyType(ReligionEmergencyType religionEmergencyType);

    /**
     * 修改场所突发应急管理
     * 
     * @param religionEmergencyType 场所突发应急管理
     * @return 结果
     */
    public int updateReligionEmergencyType(ReligionEmergencyType religionEmergencyType);

    /**
     * 批量删除场所突发应急管理
     * 
     * @param ids 需要删除的场所突发应急管理主键集合
     * @return 结果
     */
    public int deleteReligionEmergencyTypeByIds(Long[] ids);

    /**
     * 删除场所突发应急管理信息
     * 
     * @param id 场所突发应急管理主键
     * @return 结果
     */
    public int deleteReligionEmergencyTypeById(Long id);
}
