package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionWork;

/**
 * 工单Mapper接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:33
 */
public interface ReligionWorkMapper 
{
    /**
     * 查询工单
     * 
     * @param id 工单主键
     * @return 工单
     */
    public ReligionWork selectReligionWorkById(Long id);

    /**
     * 查询工单列表
     * 
     * @param religionWork 工单
     * @return 工单集合
     */
    public List<ReligionWork> selectReligionWorkList(ReligionWork religionWork);

    /**
     * 新增工单
     * 
     * @param religionWork 工单
     * @return 结果
     */
    public int insertReligionWork(ReligionWork religionWork);

    /**
     * 修改工单
     * 
     * @param religionWork 工单
     * @return 结果
     */
    public int updateReligionWork(ReligionWork religionWork);

    /**
     * 删除工单
     * 
     * @param id 工单主键
     * @return 结果
     */
    public int deleteReligionWorkById(Long id);

    /**
     * 批量删除工单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionWorkByIds(Long[] ids);
}
