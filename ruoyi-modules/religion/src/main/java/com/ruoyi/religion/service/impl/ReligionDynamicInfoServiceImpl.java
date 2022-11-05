package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionDynamicInfoMapper;
import com.ruoyi.religion.domain.ReligionDynamicInfo;
import com.ruoyi.religion.service.IReligionDynamicInfoService;

/**
 * 动态信息Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@Service
public class ReligionDynamicInfoServiceImpl implements IReligionDynamicInfoService 
{
    @Autowired
    private ReligionDynamicInfoMapper religionDynamicInfoMapper;

    /**
     * 查询动态信息
     * 
     * @param id 动态信息主键
     * @return 动态信息
     */
    @Override
    public ReligionDynamicInfo selectReligionDynamicInfoById(Long id)
    {
        return religionDynamicInfoMapper.selectReligionDynamicInfoById(id);
    }

    /**
     * 查询动态信息列表
     * 
     * @param religionDynamicInfo 动态信息
     * @return 动态信息
     */
    @Override
    public List<ReligionDynamicInfo> selectReligionDynamicInfoList(ReligionDynamicInfo religionDynamicInfo)
    {
        return religionDynamicInfoMapper.selectReligionDynamicInfoList(religionDynamicInfo);
    }

    /**
     * 新增动态信息
     * 
     * @param religionDynamicInfo 动态信息
     * @return 结果
     */
    @Override
    public int insertReligionDynamicInfo(ReligionDynamicInfo religionDynamicInfo)
    {
        religionDynamicInfo.setCreateTime(DateUtils.getNowDate());
        return religionDynamicInfoMapper.insertReligionDynamicInfo(religionDynamicInfo);
    }

    /**
     * 修改动态信息
     * 
     * @param religionDynamicInfo 动态信息
     * @return 结果
     */
    @Override
    public int updateReligionDynamicInfo(ReligionDynamicInfo religionDynamicInfo)
    {
        religionDynamicInfo.setUpdateTime(DateUtils.getNowDate());
        return religionDynamicInfoMapper.updateReligionDynamicInfo(religionDynamicInfo);
    }

    /**
     * 批量删除动态信息
     * 
     * @param ids 需要删除的动态信息主键
     * @return 结果
     */
    @Override
    public int deleteReligionDynamicInfoByIds(Long[] ids)
    {
        return religionDynamicInfoMapper.deleteReligionDynamicInfoByIds(ids);
    }

    /**
     * 删除动态信息信息
     * 
     * @param id 动态信息主键
     * @return 结果
     */
    @Override
    public int deleteReligionDynamicInfoById(Long id)
    {
        return religionDynamicInfoMapper.deleteReligionDynamicInfoById(id);
    }
}
