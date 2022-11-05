package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionRitualManagerMapper;
import com.ruoyi.religion.domain.ReligionRitualManager;
import com.ruoyi.religion.service.IReligionRitualManagerService;

/**
 * 法事登记备案Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@Service
public class ReligionRitualManagerServiceImpl implements IReligionRitualManagerService 
{
    @Autowired
    private ReligionRitualManagerMapper religionRitualManagerMapper;

    /**
     * 查询法事登记备案
     * 
     * @param id 法事登记备案主键
     * @return 法事登记备案
     */
    @Override
    public ReligionRitualManager selectReligionRitualManagerById(Long id)
    {
        return religionRitualManagerMapper.selectReligionRitualManagerById(id);
    }

    /**
     * 查询法事登记备案列表
     * 
     * @param religionRitualManager 法事登记备案
     * @return 法事登记备案
     */
    @Override
    public List<ReligionRitualManager> selectReligionRitualManagerList(ReligionRitualManager religionRitualManager)
    {
        return religionRitualManagerMapper.selectReligionRitualManagerList(religionRitualManager);
    }

    /**
     * 新增法事登记备案
     * 
     * @param religionRitualManager 法事登记备案
     * @return 结果
     */
    @Override
    public int insertReligionRitualManager(ReligionRitualManager religionRitualManager)
    {
        religionRitualManager.setCreateTime(DateUtils.getNowDate());
        return religionRitualManagerMapper.insertReligionRitualManager(religionRitualManager);
    }

    /**
     * 修改法事登记备案
     * 
     * @param religionRitualManager 法事登记备案
     * @return 结果
     */
    @Override
    public int updateReligionRitualManager(ReligionRitualManager religionRitualManager)
    {
        religionRitualManager.setUpdateTime(DateUtils.getNowDate());
        return religionRitualManagerMapper.updateReligionRitualManager(religionRitualManager);
    }

    /**
     * 批量删除法事登记备案
     * 
     * @param ids 需要删除的法事登记备案主键
     * @return 结果
     */
    @Override
    public int deleteReligionRitualManagerByIds(Long[] ids)
    {
        return religionRitualManagerMapper.deleteReligionRitualManagerByIds(ids);
    }

    /**
     * 删除法事登记备案信息
     * 
     * @param id 法事登记备案主键
     * @return 结果
     */
    @Override
    public int deleteReligionRitualManagerById(Long id)
    {
        return religionRitualManagerMapper.deleteReligionRitualManagerById(id);
    }
}
