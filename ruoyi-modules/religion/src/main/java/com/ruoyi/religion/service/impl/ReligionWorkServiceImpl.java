package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionWorkMapper;
import com.ruoyi.religion.domain.ReligionWork;
import com.ruoyi.religion.service.IReligionWorkService;

/**
 * 工单Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:33
 */
@Service
public class ReligionWorkServiceImpl implements IReligionWorkService 
{
    @Autowired
    private ReligionWorkMapper religionWorkMapper;

    /**
     * 查询工单
     * 
     * @param id 工单主键
     * @return 工单
     */
    @Override
    public ReligionWork selectReligionWorkById(Long id)
    {
        return religionWorkMapper.selectReligionWorkById(id);
    }

    /**
     * 查询工单列表
     * 
     * @param religionWork 工单
     * @return 工单
     */
    @Override
    public List<ReligionWork> selectReligionWorkList(ReligionWork religionWork)
    {
        return religionWorkMapper.selectReligionWorkList(religionWork);
    }

    /**
     * 新增工单
     * 
     * @param religionWork 工单
     * @return 结果
     */
    @Override
    public int insertReligionWork(ReligionWork religionWork)
    {
        religionWork.setCreateTime(DateUtils.getNowDate());
        return religionWorkMapper.insertReligionWork(religionWork);
    }

    /**
     * 修改工单
     * 
     * @param religionWork 工单
     * @return 结果
     */
    @Override
    public int updateReligionWork(ReligionWork religionWork)
    {
        religionWork.setUpdateTime(DateUtils.getNowDate());
        return religionWorkMapper.updateReligionWork(religionWork);
    }

    /**
     * 批量删除工单
     * 
     * @param ids 需要删除的工单主键
     * @return 结果
     */
    @Override
    public int deleteReligionWorkByIds(Long[] ids)
    {
        return religionWorkMapper.deleteReligionWorkByIds(ids);
    }

    /**
     * 删除工单信息
     * 
     * @param id 工单主键
     * @return 结果
     */
    @Override
    public int deleteReligionWorkById(Long id)
    {
        return religionWorkMapper.deleteReligionWorkById(id);
    }
}
