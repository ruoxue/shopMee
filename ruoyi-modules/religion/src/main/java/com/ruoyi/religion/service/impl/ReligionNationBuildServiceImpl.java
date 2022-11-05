package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionNationBuildMapper;
import com.ruoyi.religion.domain.ReligionNationBuild;
import com.ruoyi.religion.service.IReligionNationBuildService;

/**
 * 民族团结进步创建Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@Service
public class ReligionNationBuildServiceImpl implements IReligionNationBuildService 
{
    @Autowired
    private ReligionNationBuildMapper religionNationBuildMapper;

    /**
     * 查询民族团结进步创建
     * 
     * @param id 民族团结进步创建主键
     * @return 民族团结进步创建
     */
    @Override
    public ReligionNationBuild selectReligionNationBuildById(Long id)
    {
        return religionNationBuildMapper.selectReligionNationBuildById(id);
    }

    /**
     * 查询民族团结进步创建列表
     * 
     * @param religionNationBuild 民族团结进步创建
     * @return 民族团结进步创建
     */
    @Override
    public List<ReligionNationBuild> selectReligionNationBuildList(ReligionNationBuild religionNationBuild)
    {
        return religionNationBuildMapper.selectReligionNationBuildList(religionNationBuild);
    }

    /**
     * 新增民族团结进步创建
     * 
     * @param religionNationBuild 民族团结进步创建
     * @return 结果
     */
    @Override
    public int insertReligionNationBuild(ReligionNationBuild religionNationBuild)
    {
        religionNationBuild.setCreateTime(DateUtils.getNowDate());
        return religionNationBuildMapper.insertReligionNationBuild(religionNationBuild);
    }

    /**
     * 修改民族团结进步创建
     * 
     * @param religionNationBuild 民族团结进步创建
     * @return 结果
     */
    @Override
    public int updateReligionNationBuild(ReligionNationBuild religionNationBuild)
    {
        religionNationBuild.setUpdateTime(DateUtils.getNowDate());
        return religionNationBuildMapper.updateReligionNationBuild(religionNationBuild);
    }

    /**
     * 批量删除民族团结进步创建
     * 
     * @param ids 需要删除的民族团结进步创建主键
     * @return 结果
     */
    @Override
    public int deleteReligionNationBuildByIds(Long[] ids)
    {
        return religionNationBuildMapper.deleteReligionNationBuildByIds(ids);
    }

    /**
     * 删除民族团结进步创建信息
     * 
     * @param id 民族团结进步创建主键
     * @return 结果
     */
    @Override
    public int deleteReligionNationBuildById(Long id)
    {
        return religionNationBuildMapper.deleteReligionNationBuildById(id);
    }
}
