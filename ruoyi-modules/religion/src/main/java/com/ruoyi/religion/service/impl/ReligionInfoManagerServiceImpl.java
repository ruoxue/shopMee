package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionInfoManagerMapper;
import com.ruoyi.religion.domain.ReligionInfoManager;
import com.ruoyi.religion.service.IReligionInfoManagerService;

/**
 * 信息登记Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 23:25:25
 */
@Service
public class ReligionInfoManagerServiceImpl implements IReligionInfoManagerService 
{
    @Autowired
    private ReligionInfoManagerMapper religionInfoManagerMapper;

    /**
     * 查询信息登记
     * 
     * @param id 信息登记主键
     * @return 信息登记
     */
    @Override
    public ReligionInfoManager selectReligionInfoManagerById(Long id)
    {
        return religionInfoManagerMapper.selectReligionInfoManagerById(id);
    }

    /**
     * 查询信息登记列表
     * 
     * @param religionInfoManager 信息登记
     * @return 信息登记
     */
    @Override
    public List<ReligionInfoManager> selectReligionInfoManagerList(ReligionInfoManager religionInfoManager)
    {
        return religionInfoManagerMapper.selectReligionInfoManagerList(religionInfoManager);
    }

    /**
     * 新增信息登记
     * 
     * @param religionInfoManager 信息登记
     * @return 结果
     */
    @Override
    public int insertReligionInfoManager(ReligionInfoManager religionInfoManager)
    {
        religionInfoManager.setCreateTime(DateUtils.getNowDate());
        return religionInfoManagerMapper.insertReligionInfoManager(religionInfoManager);
    }

    /**
     * 修改信息登记
     * 
     * @param religionInfoManager 信息登记
     * @return 结果
     */
    @Override
    public int updateReligionInfoManager(ReligionInfoManager religionInfoManager)
    {
        religionInfoManager.setUpdateTime(DateUtils.getNowDate());
        return religionInfoManagerMapper.updateReligionInfoManager(religionInfoManager);
    }

    /**
     * 批量删除信息登记
     * 
     * @param ids 需要删除的信息登记主键
     * @return 结果
     */
    @Override
    public int deleteReligionInfoManagerByIds(Long[] ids)
    {
        return religionInfoManagerMapper.deleteReligionInfoManagerByIds(ids);
    }

    /**
     * 删除信息登记信息
     * 
     * @param id 信息登记主键
     * @return 结果
     */
    @Override
    public int deleteReligionInfoManagerById(Long id)
    {
        return religionInfoManagerMapper.deleteReligionInfoManagerById(id);
    }
}
