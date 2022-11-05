package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionBuildsafeInfoManagerMapper;
import com.ruoyi.religion.domain.ReligionBuildsafeInfoManager;
import com.ruoyi.religion.service.IReligionBuildsafeInfoManagerService;

/**
 * 建筑隐患信息上报Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@Service
public class ReligionBuildsafeInfoManagerServiceImpl implements IReligionBuildsafeInfoManagerService 
{
    @Autowired
    private ReligionBuildsafeInfoManagerMapper religionBuildsafeInfoManagerMapper;

    /**
     * 查询建筑隐患信息上报
     * 
     * @param id 建筑隐患信息上报主键
     * @return 建筑隐患信息上报
     */
    @Override
    public ReligionBuildsafeInfoManager selectReligionBuildsafeInfoManagerById(Long id)
    {
        return religionBuildsafeInfoManagerMapper.selectReligionBuildsafeInfoManagerById(id);
    }

    /**
     * 查询建筑隐患信息上报列表
     * 
     * @param religionBuildsafeInfoManager 建筑隐患信息上报
     * @return 建筑隐患信息上报
     */
    @Override
    public List<ReligionBuildsafeInfoManager> selectReligionBuildsafeInfoManagerList(ReligionBuildsafeInfoManager religionBuildsafeInfoManager)
    {
        return religionBuildsafeInfoManagerMapper.selectReligionBuildsafeInfoManagerList(religionBuildsafeInfoManager);
    }

    /**
     * 新增建筑隐患信息上报
     * 
     * @param religionBuildsafeInfoManager 建筑隐患信息上报
     * @return 结果
     */
    @Override
    public int insertReligionBuildsafeInfoManager(ReligionBuildsafeInfoManager religionBuildsafeInfoManager)
    {
        religionBuildsafeInfoManager.setCreateTime(DateUtils.getNowDate());
        return religionBuildsafeInfoManagerMapper.insertReligionBuildsafeInfoManager(religionBuildsafeInfoManager);
    }

    /**
     * 修改建筑隐患信息上报
     * 
     * @param religionBuildsafeInfoManager 建筑隐患信息上报
     * @return 结果
     */
    @Override
    public int updateReligionBuildsafeInfoManager(ReligionBuildsafeInfoManager religionBuildsafeInfoManager)
    {
        religionBuildsafeInfoManager.setUpdateTime(DateUtils.getNowDate());
        return religionBuildsafeInfoManagerMapper.updateReligionBuildsafeInfoManager(religionBuildsafeInfoManager);
    }

    /**
     * 批量删除建筑隐患信息上报
     * 
     * @param ids 需要删除的建筑隐患信息上报主键
     * @return 结果
     */
    @Override
    public int deleteReligionBuildsafeInfoManagerByIds(Long[] ids)
    {
        return religionBuildsafeInfoManagerMapper.deleteReligionBuildsafeInfoManagerByIds(ids);
    }

    /**
     * 删除建筑隐患信息上报信息
     * 
     * @param id 建筑隐患信息上报主键
     * @return 结果
     */
    @Override
    public int deleteReligionBuildsafeInfoManagerById(Long id)
    {
        return religionBuildsafeInfoManagerMapper.deleteReligionBuildsafeInfoManagerById(id);
    }
}
