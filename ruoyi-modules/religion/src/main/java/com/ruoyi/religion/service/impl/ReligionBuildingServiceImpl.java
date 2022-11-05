package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionBuildingMapper;
import com.ruoyi.religion.domain.ReligionBuilding;
import com.ruoyi.religion.service.IReligionBuildingService;

/**
 * 宗教建筑物Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@Service
public class ReligionBuildingServiceImpl implements IReligionBuildingService 
{
    @Autowired
    private ReligionBuildingMapper religionBuildingMapper;

    /**
     * 查询宗教建筑物
     * 
     * @param id 宗教建筑物主键
     * @return 宗教建筑物
     */
    @Override
    public ReligionBuilding selectReligionBuildingById(Long id)
    {
        return religionBuildingMapper.selectReligionBuildingById(id);
    }

    /**
     * 查询宗教建筑物列表
     * 
     * @param religionBuilding 宗教建筑物
     * @return 宗教建筑物
     */
    @Override
    public List<ReligionBuilding> selectReligionBuildingList(ReligionBuilding religionBuilding)
    {
        return religionBuildingMapper.selectReligionBuildingList(religionBuilding);
    }

    /**
     * 新增宗教建筑物
     * 
     * @param religionBuilding 宗教建筑物
     * @return 结果
     */
    @Override
    public int insertReligionBuilding(ReligionBuilding religionBuilding)
    {
        religionBuilding.setCreateTime(DateUtils.getNowDate());
        return religionBuildingMapper.insertReligionBuilding(religionBuilding);
    }

    /**
     * 修改宗教建筑物
     * 
     * @param religionBuilding 宗教建筑物
     * @return 结果
     */
    @Override
    public int updateReligionBuilding(ReligionBuilding religionBuilding)
    {
        religionBuilding.setUpdateTime(DateUtils.getNowDate());
        return religionBuildingMapper.updateReligionBuilding(religionBuilding);
    }

    /**
     * 批量删除宗教建筑物
     * 
     * @param ids 需要删除的宗教建筑物主键
     * @return 结果
     */
    @Override
    public int deleteReligionBuildingByIds(Long[] ids)
    {
        return religionBuildingMapper.deleteReligionBuildingByIds(ids);
    }

    /**
     * 删除宗教建筑物信息
     * 
     * @param id 宗教建筑物主键
     * @return 结果
     */
    @Override
    public int deleteReligionBuildingById(Long id)
    {
        return religionBuildingMapper.deleteReligionBuildingById(id);
    }
}
