package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionWork;

/**
 * 工单Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:33
 */
public interface IReligionWorkService 
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
     * 批量删除工单
     * 
     * @param ids 需要删除的工单主键集合
     * @return 结果
     */
    public int deleteReligionWorkByIds(Long[] ids);

    /**
     * 删除工单信息
     * 
     * @param id 工单主键
     * @return 结果
     */
    public int deleteReligionWorkById(Long id);
}
