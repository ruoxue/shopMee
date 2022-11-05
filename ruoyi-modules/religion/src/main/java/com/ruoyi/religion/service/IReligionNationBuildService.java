package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionNationBuild;

/**
 * 民族团结进步创建Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
public interface IReligionNationBuildService 
{
    /**
     * 查询民族团结进步创建
     * 
     * @param id 民族团结进步创建主键
     * @return 民族团结进步创建
     */
    public ReligionNationBuild selectReligionNationBuildById(Long id);

    /**
     * 查询民族团结进步创建列表
     * 
     * @param religionNationBuild 民族团结进步创建
     * @return 民族团结进步创建集合
     */
    public List<ReligionNationBuild> selectReligionNationBuildList(ReligionNationBuild religionNationBuild);

    /**
     * 新增民族团结进步创建
     * 
     * @param religionNationBuild 民族团结进步创建
     * @return 结果
     */
    public int insertReligionNationBuild(ReligionNationBuild religionNationBuild);

    /**
     * 修改民族团结进步创建
     * 
     * @param religionNationBuild 民族团结进步创建
     * @return 结果
     */
    public int updateReligionNationBuild(ReligionNationBuild religionNationBuild);

    /**
     * 批量删除民族团结进步创建
     * 
     * @param ids 需要删除的民族团结进步创建主键集合
     * @return 结果
     */
    public int deleteReligionNationBuildByIds(Long[] ids);

    /**
     * 删除民族团结进步创建信息
     * 
     * @param id 民族团结进步创建主键
     * @return 结果
     */
    public int deleteReligionNationBuildById(Long id);
}
