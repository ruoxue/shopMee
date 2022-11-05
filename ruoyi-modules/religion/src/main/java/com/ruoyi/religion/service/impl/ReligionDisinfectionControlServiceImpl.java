package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionDisinfectionControlMapper;
import com.ruoyi.religion.domain.ReligionDisinfectionControl;
import com.ruoyi.religion.service.IReligionDisinfectionControlService;

/**
 * 场所消杀管理Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@Service
public class ReligionDisinfectionControlServiceImpl implements IReligionDisinfectionControlService 
{
    @Autowired
    private ReligionDisinfectionControlMapper religionDisinfectionControlMapper;

    /**
     * 查询场所消杀管理
     * 
     * @param id 场所消杀管理主键
     * @return 场所消杀管理
     */
    @Override
    public ReligionDisinfectionControl selectReligionDisinfectionControlById(Long id)
    {
        return religionDisinfectionControlMapper.selectReligionDisinfectionControlById(id);
    }

    /**
     * 查询场所消杀管理列表
     * 
     * @param religionDisinfectionControl 场所消杀管理
     * @return 场所消杀管理
     */
    @Override
    public List<ReligionDisinfectionControl> selectReligionDisinfectionControlList(ReligionDisinfectionControl religionDisinfectionControl)
    {
        return religionDisinfectionControlMapper.selectReligionDisinfectionControlList(religionDisinfectionControl);
    }

    /**
     * 新增场所消杀管理
     * 
     * @param religionDisinfectionControl 场所消杀管理
     * @return 结果
     */
    @Override
    public int insertReligionDisinfectionControl(ReligionDisinfectionControl religionDisinfectionControl)
    {
        religionDisinfectionControl.setCreateTime(DateUtils.getNowDate());
        return religionDisinfectionControlMapper.insertReligionDisinfectionControl(religionDisinfectionControl);
    }

    /**
     * 修改场所消杀管理
     * 
     * @param religionDisinfectionControl 场所消杀管理
     * @return 结果
     */
    @Override
    public int updateReligionDisinfectionControl(ReligionDisinfectionControl religionDisinfectionControl)
    {
        religionDisinfectionControl.setUpdateTime(DateUtils.getNowDate());
        return religionDisinfectionControlMapper.updateReligionDisinfectionControl(religionDisinfectionControl);
    }

    /**
     * 批量删除场所消杀管理
     * 
     * @param ids 需要删除的场所消杀管理主键
     * @return 结果
     */
    @Override
    public int deleteReligionDisinfectionControlByIds(Long[] ids)
    {
        return religionDisinfectionControlMapper.deleteReligionDisinfectionControlByIds(ids);
    }

    /**
     * 删除场所消杀管理信息
     * 
     * @param id 场所消杀管理主键
     * @return 结果
     */
    @Override
    public int deleteReligionDisinfectionControlById(Long id)
    {
        return religionDisinfectionControlMapper.deleteReligionDisinfectionControlById(id);
    }
}
