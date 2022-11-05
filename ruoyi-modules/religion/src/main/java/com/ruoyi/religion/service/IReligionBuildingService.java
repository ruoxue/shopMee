package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionBuilding;

/**
 * 宗教建筑物Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
public interface IReligionBuildingService 
{
    /**
     * 查询宗教建筑物
     * 
     * @param id 宗教建筑物主键
     * @return 宗教建筑物
     */
    public ReligionBuilding selectReligionBuildingById(Long id);

    /**
     * 查询宗教建筑物列表
     * 
     * @param religionBuilding 宗教建筑物
     * @return 宗教建筑物集合
     */
    public List<ReligionBuilding> selectReligionBuildingList(ReligionBuilding religionBuilding);

    /**
     * 新增宗教建筑物
     * 
     * @param religionBuilding 宗教建筑物
     * @return 结果
     */
    public int insertReligionBuilding(ReligionBuilding religionBuilding);

    /**
     * 修改宗教建筑物
     * 
     * @param religionBuilding 宗教建筑物
     * @return 结果
     */
    public int updateReligionBuilding(ReligionBuilding religionBuilding);

    /**
     * 批量删除宗教建筑物
     * 
     * @param ids 需要删除的宗教建筑物主键集合
     * @return 结果
     */
    public int deleteReligionBuildingByIds(Long[] ids);

    /**
     * 删除宗教建筑物信息
     * 
     * @param id 宗教建筑物主键
     * @return 结果
     */
    public int deleteReligionBuildingById(Long id);
}
