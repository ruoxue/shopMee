package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionDrillManagerMapper;
import com.ruoyi.religion.domain.ReligionDrillManager;
import com.ruoyi.religion.service.IReligionDrillManagerService;

/**
 * 消防演练管理Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@Service
public class ReligionDrillManagerServiceImpl implements IReligionDrillManagerService 
{
    @Autowired
    private ReligionDrillManagerMapper religionDrillManagerMapper;

    /**
     * 查询消防演练管理
     * 
     * @param id 消防演练管理主键
     * @return 消防演练管理
     */
    @Override
    public ReligionDrillManager selectReligionDrillManagerById(Long id)
    {
        return religionDrillManagerMapper.selectReligionDrillManagerById(id);
    }

    /**
     * 查询消防演练管理列表
     * 
     * @param religionDrillManager 消防演练管理
     * @return 消防演练管理
     */
    @Override
    public List<ReligionDrillManager> selectReligionDrillManagerList(ReligionDrillManager religionDrillManager)
    {
        return religionDrillManagerMapper.selectReligionDrillManagerList(religionDrillManager);
    }

    /**
     * 新增消防演练管理
     * 
     * @param religionDrillManager 消防演练管理
     * @return 结果
     */
    @Override
    public int insertReligionDrillManager(ReligionDrillManager religionDrillManager)
    {
        religionDrillManager.setCreateTime(DateUtils.getNowDate());
        return religionDrillManagerMapper.insertReligionDrillManager(religionDrillManager);
    }

    /**
     * 修改消防演练管理
     * 
     * @param religionDrillManager 消防演练管理
     * @return 结果
     */
    @Override
    public int updateReligionDrillManager(ReligionDrillManager religionDrillManager)
    {
        religionDrillManager.setUpdateTime(DateUtils.getNowDate());
        return religionDrillManagerMapper.updateReligionDrillManager(religionDrillManager);
    }

    /**
     * 批量删除消防演练管理
     * 
     * @param ids 需要删除的消防演练管理主键
     * @return 结果
     */
    @Override
    public int deleteReligionDrillManagerByIds(Long[] ids)
    {
        return religionDrillManagerMapper.deleteReligionDrillManagerByIds(ids);
    }

    /**
     * 删除消防演练管理信息
     * 
     * @param id 消防演练管理主键
     * @return 结果
     */
    @Override
    public int deleteReligionDrillManagerById(Long id)
    {
        return religionDrillManagerMapper.deleteReligionDrillManagerById(id);
    }
}
