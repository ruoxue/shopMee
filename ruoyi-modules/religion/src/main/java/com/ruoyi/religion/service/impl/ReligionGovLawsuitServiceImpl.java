package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionGovLawsuitMapper;
import com.ruoyi.religion.domain.ReligionGovLawsuit;
import com.ruoyi.religion.service.IReligionGovLawsuitService;

/**
 * 行政诉讼登记Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@Service
public class ReligionGovLawsuitServiceImpl implements IReligionGovLawsuitService 
{
    @Autowired
    private ReligionGovLawsuitMapper religionGovLawsuitMapper;

    /**
     * 查询行政诉讼登记
     * 
     * @param id 行政诉讼登记主键
     * @return 行政诉讼登记
     */
    @Override
    public ReligionGovLawsuit selectReligionGovLawsuitById(Long id)
    {
        return religionGovLawsuitMapper.selectReligionGovLawsuitById(id);
    }

    /**
     * 查询行政诉讼登记列表
     * 
     * @param religionGovLawsuit 行政诉讼登记
     * @return 行政诉讼登记
     */
    @Override
    public List<ReligionGovLawsuit> selectReligionGovLawsuitList(ReligionGovLawsuit religionGovLawsuit)
    {
        return religionGovLawsuitMapper.selectReligionGovLawsuitList(religionGovLawsuit);
    }

    /**
     * 新增行政诉讼登记
     * 
     * @param religionGovLawsuit 行政诉讼登记
     * @return 结果
     */
    @Override
    public int insertReligionGovLawsuit(ReligionGovLawsuit religionGovLawsuit)
    {
        religionGovLawsuit.setCreateTime(DateUtils.getNowDate());
        return religionGovLawsuitMapper.insertReligionGovLawsuit(religionGovLawsuit);
    }

    /**
     * 修改行政诉讼登记
     * 
     * @param religionGovLawsuit 行政诉讼登记
     * @return 结果
     */
    @Override
    public int updateReligionGovLawsuit(ReligionGovLawsuit religionGovLawsuit)
    {
        religionGovLawsuit.setUpdateTime(DateUtils.getNowDate());
        return religionGovLawsuitMapper.updateReligionGovLawsuit(religionGovLawsuit);
    }

    /**
     * 批量删除行政诉讼登记
     * 
     * @param ids 需要删除的行政诉讼登记主键
     * @return 结果
     */
    @Override
    public int deleteReligionGovLawsuitByIds(Long[] ids)
    {
        return religionGovLawsuitMapper.deleteReligionGovLawsuitByIds(ids);
    }

    /**
     * 删除行政诉讼登记信息
     * 
     * @param id 行政诉讼登记主键
     * @return 结果
     */
    @Override
    public int deleteReligionGovLawsuitById(Long id)
    {
        return religionGovLawsuitMapper.deleteReligionGovLawsuitById(id);
    }
}
