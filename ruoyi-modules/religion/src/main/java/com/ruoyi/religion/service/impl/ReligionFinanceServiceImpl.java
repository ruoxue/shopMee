package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionFinanceMapper;
import com.ruoyi.religion.domain.ReligionFinance;
import com.ruoyi.religion.service.IReligionFinanceService;

/**
 * 财务数据Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@Service
public class ReligionFinanceServiceImpl implements IReligionFinanceService 
{
    @Autowired
    private ReligionFinanceMapper religionFinanceMapper;

    /**
     * 查询财务数据
     * 
     * @param id 财务数据主键
     * @return 财务数据
     */
    @Override
    public ReligionFinance selectReligionFinanceById(Long id)
    {
        return religionFinanceMapper.selectReligionFinanceById(id);
    }

    /**
     * 查询财务数据列表
     * 
     * @param religionFinance 财务数据
     * @return 财务数据
     */
    @Override
    public List<ReligionFinance> selectReligionFinanceList(ReligionFinance religionFinance)
    {
        return religionFinanceMapper.selectReligionFinanceList(religionFinance);
    }

    /**
     * 新增财务数据
     * 
     * @param religionFinance 财务数据
     * @return 结果
     */
    @Override
    public int insertReligionFinance(ReligionFinance religionFinance)
    {
        religionFinance.setCreateTime(DateUtils.getNowDate());
        return religionFinanceMapper.insertReligionFinance(religionFinance);
    }

    /**
     * 修改财务数据
     * 
     * @param religionFinance 财务数据
     * @return 结果
     */
    @Override
    public int updateReligionFinance(ReligionFinance religionFinance)
    {
        religionFinance.setUpdateTime(DateUtils.getNowDate());
        return religionFinanceMapper.updateReligionFinance(religionFinance);
    }

    /**
     * 批量删除财务数据
     * 
     * @param ids 需要删除的财务数据主键
     * @return 结果
     */
    @Override
    public int deleteReligionFinanceByIds(Long[] ids)
    {
        return religionFinanceMapper.deleteReligionFinanceByIds(ids);
    }

    /**
     * 删除财务数据信息
     * 
     * @param id 财务数据主键
     * @return 结果
     */
    @Override
    public int deleteReligionFinanceById(Long id)
    {
        return religionFinanceMapper.deleteReligionFinanceById(id);
    }
}
