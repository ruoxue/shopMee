package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionBuildingManagerMapper;
import com.ruoyi.religion.domain.ReligionBuildingManager;
import com.ruoyi.religion.service.IReligionBuildingManagerService;

/**
 * 场所建设登记管理Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@Service
public class ReligionBuildingManagerServiceImpl implements IReligionBuildingManagerService 
{
    @Autowired
    private ReligionBuildingManagerMapper religionBuildingManagerMapper;

    /**
     * 查询场所建设登记管理
     * 
     * @param id 场所建设登记管理主键
     * @return 场所建设登记管理
     */
    @Override
    public ReligionBuildingManager selectReligionBuildingManagerById(Long id)
    {
        return religionBuildingManagerMapper.selectReligionBuildingManagerById(id);
    }

    /**
     * 查询场所建设登记管理列表
     * 
     * @param religionBuildingManager 场所建设登记管理
     * @return 场所建设登记管理
     */
    @Override
    public List<ReligionBuildingManager> selectReligionBuildingManagerList(ReligionBuildingManager religionBuildingManager)
    {
        return religionBuildingManagerMapper.selectReligionBuildingManagerList(religionBuildingManager);
    }

    /**
     * 新增场所建设登记管理
     * 
     * @param religionBuildingManager 场所建设登记管理
     * @return 结果
     */
    @Override
    public int insertReligionBuildingManager(ReligionBuildingManager religionBuildingManager)
    {
        religionBuildingManager.setCreateTime(DateUtils.getNowDate());
        return religionBuildingManagerMapper.insertReligionBuildingManager(religionBuildingManager);
    }

    /**
     * 修改场所建设登记管理
     * 
     * @param religionBuildingManager 场所建设登记管理
     * @return 结果
     */
    @Override
    public int updateReligionBuildingManager(ReligionBuildingManager religionBuildingManager)
    {
        religionBuildingManager.setUpdateTime(DateUtils.getNowDate());
        return religionBuildingManagerMapper.updateReligionBuildingManager(religionBuildingManager);
    }

    /**
     * 批量删除场所建设登记管理
     * 
     * @param ids 需要删除的场所建设登记管理主键
     * @return 结果
     */
    @Override
    public int deleteReligionBuildingManagerByIds(Long[] ids)
    {
        return religionBuildingManagerMapper.deleteReligionBuildingManagerByIds(ids);
    }

    /**
     * 删除场所建设登记管理信息
     * 
     * @param id 场所建设登记管理主键
     * @return 结果
     */
    @Override
    public int deleteReligionBuildingManagerById(Long id)
    {
        return religionBuildingManagerMapper.deleteReligionBuildingManagerById(id);
    }
}
