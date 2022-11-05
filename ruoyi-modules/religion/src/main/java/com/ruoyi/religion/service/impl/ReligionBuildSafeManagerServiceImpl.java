package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionBuildSafeManagerMapper;
import com.ruoyi.religion.domain.ReligionBuildSafeManager;
import com.ruoyi.religion.service.IReligionBuildSafeManagerService;

/**
 * 建筑安全隐患排查Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@Service
public class ReligionBuildSafeManagerServiceImpl implements IReligionBuildSafeManagerService 
{
    @Autowired
    private ReligionBuildSafeManagerMapper religionBuildSafeManagerMapper;

    /**
     * 查询建筑安全隐患排查
     * 
     * @param id 建筑安全隐患排查主键
     * @return 建筑安全隐患排查
     */
    @Override
    public ReligionBuildSafeManager selectReligionBuildSafeManagerById(Long id)
    {
        return religionBuildSafeManagerMapper.selectReligionBuildSafeManagerById(id);
    }

    /**
     * 查询建筑安全隐患排查列表
     * 
     * @param religionBuildSafeManager 建筑安全隐患排查
     * @return 建筑安全隐患排查
     */
    @Override
    public List<ReligionBuildSafeManager> selectReligionBuildSafeManagerList(ReligionBuildSafeManager religionBuildSafeManager)
    {
        return religionBuildSafeManagerMapper.selectReligionBuildSafeManagerList(religionBuildSafeManager);
    }

    /**
     * 新增建筑安全隐患排查
     * 
     * @param religionBuildSafeManager 建筑安全隐患排查
     * @return 结果
     */
    @Override
    public int insertReligionBuildSafeManager(ReligionBuildSafeManager religionBuildSafeManager)
    {
        religionBuildSafeManager.setCreateTime(DateUtils.getNowDate());
        return religionBuildSafeManagerMapper.insertReligionBuildSafeManager(religionBuildSafeManager);
    }

    /**
     * 修改建筑安全隐患排查
     * 
     * @param religionBuildSafeManager 建筑安全隐患排查
     * @return 结果
     */
    @Override
    public int updateReligionBuildSafeManager(ReligionBuildSafeManager religionBuildSafeManager)
    {
        religionBuildSafeManager.setUpdateTime(DateUtils.getNowDate());
        return religionBuildSafeManagerMapper.updateReligionBuildSafeManager(religionBuildSafeManager);
    }

    /**
     * 批量删除建筑安全隐患排查
     * 
     * @param ids 需要删除的建筑安全隐患排查主键
     * @return 结果
     */
    @Override
    public int deleteReligionBuildSafeManagerByIds(Long[] ids)
    {
        return religionBuildSafeManagerMapper.deleteReligionBuildSafeManagerByIds(ids);
    }

    /**
     * 删除建筑安全隐患排查信息
     * 
     * @param id 建筑安全隐患排查主键
     * @return 结果
     */
    @Override
    public int deleteReligionBuildSafeManagerById(Long id)
    {
        return religionBuildSafeManagerMapper.deleteReligionBuildSafeManagerById(id);
    }
}
