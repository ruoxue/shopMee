package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionEmergencyManagerMapper;
import com.ruoyi.religion.domain.ReligionEmergencyManager;
import com.ruoyi.religion.service.IReligionEmergencyManagerService;

/**
 * 应急预案管理Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@Service
public class ReligionEmergencyManagerServiceImpl implements IReligionEmergencyManagerService 
{
    @Autowired
    private ReligionEmergencyManagerMapper religionEmergencyManagerMapper;

    /**
     * 查询应急预案管理
     * 
     * @param id 应急预案管理主键
     * @return 应急预案管理
     */
    @Override
    public ReligionEmergencyManager selectReligionEmergencyManagerById(Long id)
    {
        return religionEmergencyManagerMapper.selectReligionEmergencyManagerById(id);
    }

    /**
     * 查询应急预案管理列表
     * 
     * @param religionEmergencyManager 应急预案管理
     * @return 应急预案管理
     */
    @Override
    public List<ReligionEmergencyManager> selectReligionEmergencyManagerList(ReligionEmergencyManager religionEmergencyManager)
    {
        return religionEmergencyManagerMapper.selectReligionEmergencyManagerList(religionEmergencyManager);
    }

    /**
     * 新增应急预案管理
     * 
     * @param religionEmergencyManager 应急预案管理
     * @return 结果
     */
    @Override
    public int insertReligionEmergencyManager(ReligionEmergencyManager religionEmergencyManager)
    {
        religionEmergencyManager.setCreateTime(DateUtils.getNowDate());
        return religionEmergencyManagerMapper.insertReligionEmergencyManager(religionEmergencyManager);
    }

    /**
     * 修改应急预案管理
     * 
     * @param religionEmergencyManager 应急预案管理
     * @return 结果
     */
    @Override
    public int updateReligionEmergencyManager(ReligionEmergencyManager religionEmergencyManager)
    {
        religionEmergencyManager.setUpdateTime(DateUtils.getNowDate());
        return religionEmergencyManagerMapper.updateReligionEmergencyManager(religionEmergencyManager);
    }

    /**
     * 批量删除应急预案管理
     * 
     * @param ids 需要删除的应急预案管理主键
     * @return 结果
     */
    @Override
    public int deleteReligionEmergencyManagerByIds(Long[] ids)
    {
        return religionEmergencyManagerMapper.deleteReligionEmergencyManagerByIds(ids);
    }

    /**
     * 删除应急预案管理信息
     * 
     * @param id 应急预案管理主键
     * @return 结果
     */
    @Override
    public int deleteReligionEmergencyManagerById(Long id)
    {
        return religionEmergencyManagerMapper.deleteReligionEmergencyManagerById(id);
    }
}
