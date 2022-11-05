package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionFinanceComplainMapper;
import com.ruoyi.religion.domain.ReligionFinanceComplain;
import com.ruoyi.religion.service.IReligionFinanceComplainService;

/**
 * 财务投诉Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@Service
public class ReligionFinanceComplainServiceImpl implements IReligionFinanceComplainService 
{
    @Autowired
    private ReligionFinanceComplainMapper religionFinanceComplainMapper;

    /**
     * 查询财务投诉
     * 
     * @param id 财务投诉主键
     * @return 财务投诉
     */
    @Override
    public ReligionFinanceComplain selectReligionFinanceComplainById(Long id)
    {
        return religionFinanceComplainMapper.selectReligionFinanceComplainById(id);
    }

    /**
     * 查询财务投诉列表
     * 
     * @param religionFinanceComplain 财务投诉
     * @return 财务投诉
     */
    @Override
    public List<ReligionFinanceComplain> selectReligionFinanceComplainList(ReligionFinanceComplain religionFinanceComplain)
    {
        return religionFinanceComplainMapper.selectReligionFinanceComplainList(religionFinanceComplain);
    }

    /**
     * 新增财务投诉
     * 
     * @param religionFinanceComplain 财务投诉
     * @return 结果
     */
    @Override
    public int insertReligionFinanceComplain(ReligionFinanceComplain religionFinanceComplain)
    {
        religionFinanceComplain.setCreateTime(DateUtils.getNowDate());
        return religionFinanceComplainMapper.insertReligionFinanceComplain(religionFinanceComplain);
    }

    /**
     * 修改财务投诉
     * 
     * @param religionFinanceComplain 财务投诉
     * @return 结果
     */
    @Override
    public int updateReligionFinanceComplain(ReligionFinanceComplain religionFinanceComplain)
    {
        religionFinanceComplain.setUpdateTime(DateUtils.getNowDate());
        return religionFinanceComplainMapper.updateReligionFinanceComplain(religionFinanceComplain);
    }

    /**
     * 批量删除财务投诉
     * 
     * @param ids 需要删除的财务投诉主键
     * @return 结果
     */
    @Override
    public int deleteReligionFinanceComplainByIds(Long[] ids)
    {
        return religionFinanceComplainMapper.deleteReligionFinanceComplainByIds(ids);
    }

    /**
     * 删除财务投诉信息
     * 
     * @param id 财务投诉主键
     * @return 结果
     */
    @Override
    public int deleteReligionFinanceComplainById(Long id)
    {
        return religionFinanceComplainMapper.deleteReligionFinanceComplainById(id);
    }
}
