package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionEpidemicControlMapper;
import com.ruoyi.religion.domain.ReligionEpidemicControl;
import com.ruoyi.religion.service.IReligionEpidemicControlService;

/**
 * 疫情防控检查Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@Service
public class ReligionEpidemicControlServiceImpl implements IReligionEpidemicControlService 
{
    @Autowired
    private ReligionEpidemicControlMapper religionEpidemicControlMapper;

    /**
     * 查询疫情防控检查
     * 
     * @param id 疫情防控检查主键
     * @return 疫情防控检查
     */
    @Override
    public ReligionEpidemicControl selectReligionEpidemicControlById(Long id)
    {
        return religionEpidemicControlMapper.selectReligionEpidemicControlById(id);
    }

    /**
     * 查询疫情防控检查列表
     * 
     * @param religionEpidemicControl 疫情防控检查
     * @return 疫情防控检查
     */
    @Override
    public List<ReligionEpidemicControl> selectReligionEpidemicControlList(ReligionEpidemicControl religionEpidemicControl)
    {
        return religionEpidemicControlMapper.selectReligionEpidemicControlList(religionEpidemicControl);
    }

    /**
     * 新增疫情防控检查
     * 
     * @param religionEpidemicControl 疫情防控检查
     * @return 结果
     */
    @Override
    public int insertReligionEpidemicControl(ReligionEpidemicControl religionEpidemicControl)
    {
        religionEpidemicControl.setCreateTime(DateUtils.getNowDate());
        return religionEpidemicControlMapper.insertReligionEpidemicControl(religionEpidemicControl);
    }

    /**
     * 修改疫情防控检查
     * 
     * @param religionEpidemicControl 疫情防控检查
     * @return 结果
     */
    @Override
    public int updateReligionEpidemicControl(ReligionEpidemicControl religionEpidemicControl)
    {
        religionEpidemicControl.setUpdateTime(DateUtils.getNowDate());
        return religionEpidemicControlMapper.updateReligionEpidemicControl(religionEpidemicControl);
    }

    /**
     * 批量删除疫情防控检查
     * 
     * @param ids 需要删除的疫情防控检查主键
     * @return 结果
     */
    @Override
    public int deleteReligionEpidemicControlByIds(Long[] ids)
    {
        return religionEpidemicControlMapper.deleteReligionEpidemicControlByIds(ids);
    }

    /**
     * 删除疫情防控检查信息
     * 
     * @param id 疫情防控检查主键
     * @return 结果
     */
    @Override
    public int deleteReligionEpidemicControlById(Long id)
    {
        return religionEpidemicControlMapper.deleteReligionEpidemicControlById(id);
    }
}
