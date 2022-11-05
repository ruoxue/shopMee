package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionIllegalManagerMapper;
import com.ruoyi.religion.domain.ReligionIllegalManager;
import com.ruoyi.religion.service.IReligionIllegalManagerService;

/**
 * 非法活动管理Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@Service
public class ReligionIllegalManagerServiceImpl implements IReligionIllegalManagerService 
{
    @Autowired
    private ReligionIllegalManagerMapper religionIllegalManagerMapper;

    /**
     * 查询非法活动管理
     * 
     * @param id 非法活动管理主键
     * @return 非法活动管理
     */
    @Override
    public ReligionIllegalManager selectReligionIllegalManagerById(Long id)
    {
        return religionIllegalManagerMapper.selectReligionIllegalManagerById(id);
    }

    /**
     * 查询非法活动管理列表
     * 
     * @param religionIllegalManager 非法活动管理
     * @return 非法活动管理
     */
    @Override
    public List<ReligionIllegalManager> selectReligionIllegalManagerList(ReligionIllegalManager religionIllegalManager)
    {
        return religionIllegalManagerMapper.selectReligionIllegalManagerList(religionIllegalManager);
    }

    /**
     * 新增非法活动管理
     * 
     * @param religionIllegalManager 非法活动管理
     * @return 结果
     */
    @Override
    public int insertReligionIllegalManager(ReligionIllegalManager religionIllegalManager)
    {
        religionIllegalManager.setCreateTime(DateUtils.getNowDate());
        return religionIllegalManagerMapper.insertReligionIllegalManager(religionIllegalManager);
    }

    /**
     * 修改非法活动管理
     * 
     * @param religionIllegalManager 非法活动管理
     * @return 结果
     */
    @Override
    public int updateReligionIllegalManager(ReligionIllegalManager religionIllegalManager)
    {
        religionIllegalManager.setUpdateTime(DateUtils.getNowDate());
        return religionIllegalManagerMapper.updateReligionIllegalManager(religionIllegalManager);
    }

    /**
     * 批量删除非法活动管理
     * 
     * @param ids 需要删除的非法活动管理主键
     * @return 结果
     */
    @Override
    public int deleteReligionIllegalManagerByIds(Long[] ids)
    {
        return religionIllegalManagerMapper.deleteReligionIllegalManagerByIds(ids);
    }

    /**
     * 删除非法活动管理信息
     * 
     * @param id 非法活动管理主键
     * @return 结果
     */
    @Override
    public int deleteReligionIllegalManagerById(Long id)
    {
        return religionIllegalManagerMapper.deleteReligionIllegalManagerById(id);
    }
}
