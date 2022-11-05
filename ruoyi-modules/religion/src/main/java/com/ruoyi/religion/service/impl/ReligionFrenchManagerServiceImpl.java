package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionFrenchManagerMapper;
import com.ruoyi.religion.domain.ReligionFrenchManager;
import com.ruoyi.religion.service.IReligionFrenchManagerService;

/**
 * 法会登记备案Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@Service
public class ReligionFrenchManagerServiceImpl implements IReligionFrenchManagerService 
{
    @Autowired
    private ReligionFrenchManagerMapper religionFrenchManagerMapper;

    /**
     * 查询法会登记备案
     * 
     * @param id 法会登记备案主键
     * @return 法会登记备案
     */
    @Override
    public ReligionFrenchManager selectReligionFrenchManagerById(Long id)
    {
        return religionFrenchManagerMapper.selectReligionFrenchManagerById(id);
    }

    /**
     * 查询法会登记备案列表
     * 
     * @param religionFrenchManager 法会登记备案
     * @return 法会登记备案
     */
    @Override
    public List<ReligionFrenchManager> selectReligionFrenchManagerList(ReligionFrenchManager religionFrenchManager)
    {
        return religionFrenchManagerMapper.selectReligionFrenchManagerList(religionFrenchManager);
    }

    /**
     * 新增法会登记备案
     * 
     * @param religionFrenchManager 法会登记备案
     * @return 结果
     */
    @Override
    public int insertReligionFrenchManager(ReligionFrenchManager religionFrenchManager)
    {
        religionFrenchManager.setCreateTime(DateUtils.getNowDate());
        return religionFrenchManagerMapper.insertReligionFrenchManager(religionFrenchManager);
    }

    /**
     * 修改法会登记备案
     * 
     * @param religionFrenchManager 法会登记备案
     * @return 结果
     */
    @Override
    public int updateReligionFrenchManager(ReligionFrenchManager religionFrenchManager)
    {
        religionFrenchManager.setUpdateTime(DateUtils.getNowDate());
        return religionFrenchManagerMapper.updateReligionFrenchManager(religionFrenchManager);
    }

    /**
     * 批量删除法会登记备案
     * 
     * @param ids 需要删除的法会登记备案主键
     * @return 结果
     */
    @Override
    public int deleteReligionFrenchManagerByIds(Long[] ids)
    {
        return religionFrenchManagerMapper.deleteReligionFrenchManagerByIds(ids);
    }

    /**
     * 删除法会登记备案信息
     * 
     * @param id 法会登记备案主键
     * @return 结果
     */
    @Override
    public int deleteReligionFrenchManagerById(Long id)
    {
        return religionFrenchManagerMapper.deleteReligionFrenchManagerById(id);
    }
}
