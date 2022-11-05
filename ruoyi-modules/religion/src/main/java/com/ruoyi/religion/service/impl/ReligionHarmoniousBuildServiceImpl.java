package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionHarmoniousBuildMapper;
import com.ruoyi.religion.domain.ReligionHarmoniousBuild;
import com.ruoyi.religion.service.IReligionHarmoniousBuildService;

/**
 * 和谐建设Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@Service
public class ReligionHarmoniousBuildServiceImpl implements IReligionHarmoniousBuildService 
{
    @Autowired
    private ReligionHarmoniousBuildMapper religionHarmoniousBuildMapper;

    /**
     * 查询和谐建设
     * 
     * @param id 和谐建设主键
     * @return 和谐建设
     */
    @Override
    public ReligionHarmoniousBuild selectReligionHarmoniousBuildById(Long id)
    {
        return religionHarmoniousBuildMapper.selectReligionHarmoniousBuildById(id);
    }

    /**
     * 查询和谐建设列表
     * 
     * @param religionHarmoniousBuild 和谐建设
     * @return 和谐建设
     */
    @Override
    public List<ReligionHarmoniousBuild> selectReligionHarmoniousBuildList(ReligionHarmoniousBuild religionHarmoniousBuild)
    {
        return religionHarmoniousBuildMapper.selectReligionHarmoniousBuildList(religionHarmoniousBuild);
    }

    /**
     * 新增和谐建设
     * 
     * @param religionHarmoniousBuild 和谐建设
     * @return 结果
     */
    @Override
    public int insertReligionHarmoniousBuild(ReligionHarmoniousBuild religionHarmoniousBuild)
    {
        religionHarmoniousBuild.setCreateTime(DateUtils.getNowDate());
        return religionHarmoniousBuildMapper.insertReligionHarmoniousBuild(religionHarmoniousBuild);
    }

    /**
     * 修改和谐建设
     * 
     * @param religionHarmoniousBuild 和谐建设
     * @return 结果
     */
    @Override
    public int updateReligionHarmoniousBuild(ReligionHarmoniousBuild religionHarmoniousBuild)
    {
        religionHarmoniousBuild.setUpdateTime(DateUtils.getNowDate());
        return religionHarmoniousBuildMapper.updateReligionHarmoniousBuild(religionHarmoniousBuild);
    }

    /**
     * 批量删除和谐建设
     * 
     * @param ids 需要删除的和谐建设主键
     * @return 结果
     */
    @Override
    public int deleteReligionHarmoniousBuildByIds(Long[] ids)
    {
        return religionHarmoniousBuildMapper.deleteReligionHarmoniousBuildByIds(ids);
    }

    /**
     * 删除和谐建设信息
     * 
     * @param id 和谐建设主键
     * @return 结果
     */
    @Override
    public int deleteReligionHarmoniousBuildById(Long id)
    {
        return religionHarmoniousBuildMapper.deleteReligionHarmoniousBuildById(id);
    }
}
