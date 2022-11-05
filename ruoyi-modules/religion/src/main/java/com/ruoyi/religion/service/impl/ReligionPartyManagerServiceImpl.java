package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionPartyManagerMapper;
import com.ruoyi.religion.domain.ReligionPartyManager;
import com.ruoyi.religion.service.IReligionPartyManagerService;

/**
 * 集会登记Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@Service
public class ReligionPartyManagerServiceImpl implements IReligionPartyManagerService 
{
    @Autowired
    private ReligionPartyManagerMapper religionPartyManagerMapper;

    /**
     * 查询集会登记
     * 
     * @param id 集会登记主键
     * @return 集会登记
     */
    @Override
    public ReligionPartyManager selectReligionPartyManagerById(Long id)
    {
        return religionPartyManagerMapper.selectReligionPartyManagerById(id);
    }

    /**
     * 查询集会登记列表
     * 
     * @param religionPartyManager 集会登记
     * @return 集会登记
     */
    @Override
    public List<ReligionPartyManager> selectReligionPartyManagerList(ReligionPartyManager religionPartyManager)
    {
        return religionPartyManagerMapper.selectReligionPartyManagerList(religionPartyManager);
    }

    /**
     * 新增集会登记
     * 
     * @param religionPartyManager 集会登记
     * @return 结果
     */
    @Override
    public int insertReligionPartyManager(ReligionPartyManager religionPartyManager)
    {
        religionPartyManager.setCreateTime(DateUtils.getNowDate());
        return religionPartyManagerMapper.insertReligionPartyManager(religionPartyManager);
    }

    /**
     * 修改集会登记
     * 
     * @param religionPartyManager 集会登记
     * @return 结果
     */
    @Override
    public int updateReligionPartyManager(ReligionPartyManager religionPartyManager)
    {
        religionPartyManager.setUpdateTime(DateUtils.getNowDate());
        return religionPartyManagerMapper.updateReligionPartyManager(religionPartyManager);
    }

    /**
     * 批量删除集会登记
     * 
     * @param ids 需要删除的集会登记主键
     * @return 结果
     */
    @Override
    public int deleteReligionPartyManagerByIds(Long[] ids)
    {
        return religionPartyManagerMapper.deleteReligionPartyManagerByIds(ids);
    }

    /**
     * 删除集会登记信息
     * 
     * @param id 集会登记主键
     * @return 结果
     */
    @Override
    public int deleteReligionPartyManagerById(Long id)
    {
        return religionPartyManagerMapper.deleteReligionPartyManagerById(id);
    }
}
