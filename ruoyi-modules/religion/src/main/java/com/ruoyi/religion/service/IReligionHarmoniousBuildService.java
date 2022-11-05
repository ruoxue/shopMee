package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionHarmoniousBuild;

/**
 * 和谐建设Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
public interface IReligionHarmoniousBuildService 
{
    /**
     * 查询和谐建设
     * 
     * @param id 和谐建设主键
     * @return 和谐建设
     */
    public ReligionHarmoniousBuild selectReligionHarmoniousBuildById(Long id);

    /**
     * 查询和谐建设列表
     * 
     * @param religionHarmoniousBuild 和谐建设
     * @return 和谐建设集合
     */
    public List<ReligionHarmoniousBuild> selectReligionHarmoniousBuildList(ReligionHarmoniousBuild religionHarmoniousBuild);

    /**
     * 新增和谐建设
     * 
     * @param religionHarmoniousBuild 和谐建设
     * @return 结果
     */
    public int insertReligionHarmoniousBuild(ReligionHarmoniousBuild religionHarmoniousBuild);

    /**
     * 修改和谐建设
     * 
     * @param religionHarmoniousBuild 和谐建设
     * @return 结果
     */
    public int updateReligionHarmoniousBuild(ReligionHarmoniousBuild religionHarmoniousBuild);

    /**
     * 批量删除和谐建设
     * 
     * @param ids 需要删除的和谐建设主键集合
     * @return 结果
     */
    public int deleteReligionHarmoniousBuildByIds(Long[] ids);

    /**
     * 删除和谐建设信息
     * 
     * @param id 和谐建设主键
     * @return 结果
     */
    public int deleteReligionHarmoniousBuildById(Long id);
}
