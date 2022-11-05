package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionEmergencyTypeMapper;
import com.ruoyi.religion.domain.ReligionEmergencyType;
import com.ruoyi.religion.service.IReligionEmergencyTypeService;

/**
 * 场所突发应急管理Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@Service
public class ReligionEmergencyTypeServiceImpl implements IReligionEmergencyTypeService 
{
    @Autowired
    private ReligionEmergencyTypeMapper religionEmergencyTypeMapper;

    /**
     * 查询场所突发应急管理
     * 
     * @param id 场所突发应急管理主键
     * @return 场所突发应急管理
     */
    @Override
    public ReligionEmergencyType selectReligionEmergencyTypeById(Long id)
    {
        return religionEmergencyTypeMapper.selectReligionEmergencyTypeById(id);
    }

    /**
     * 查询场所突发应急管理列表
     * 
     * @param religionEmergencyType 场所突发应急管理
     * @return 场所突发应急管理
     */
    @Override
    public List<ReligionEmergencyType> selectReligionEmergencyTypeList(ReligionEmergencyType religionEmergencyType)
    {
        return religionEmergencyTypeMapper.selectReligionEmergencyTypeList(religionEmergencyType);
    }

    /**
     * 新增场所突发应急管理
     * 
     * @param religionEmergencyType 场所突发应急管理
     * @return 结果
     */
    @Override
    public int insertReligionEmergencyType(ReligionEmergencyType religionEmergencyType)
    {
        religionEmergencyType.setCreateTime(DateUtils.getNowDate());
        return religionEmergencyTypeMapper.insertReligionEmergencyType(religionEmergencyType);
    }

    /**
     * 修改场所突发应急管理
     * 
     * @param religionEmergencyType 场所突发应急管理
     * @return 结果
     */
    @Override
    public int updateReligionEmergencyType(ReligionEmergencyType religionEmergencyType)
    {
        religionEmergencyType.setUpdateTime(DateUtils.getNowDate());
        return religionEmergencyTypeMapper.updateReligionEmergencyType(religionEmergencyType);
    }

    /**
     * 批量删除场所突发应急管理
     * 
     * @param ids 需要删除的场所突发应急管理主键
     * @return 结果
     */
    @Override
    public int deleteReligionEmergencyTypeByIds(Long[] ids)
    {
        return religionEmergencyTypeMapper.deleteReligionEmergencyTypeByIds(ids);
    }

    /**
     * 删除场所突发应急管理信息
     * 
     * @param id 场所突发应急管理主键
     * @return 结果
     */
    @Override
    public int deleteReligionEmergencyTypeById(Long id)
    {
        return religionEmergencyTypeMapper.deleteReligionEmergencyTypeById(id);
    }
}
