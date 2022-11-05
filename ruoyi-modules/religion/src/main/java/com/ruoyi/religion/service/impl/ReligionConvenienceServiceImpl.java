package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionConvenienceMapper;
import com.ruoyi.religion.domain.ReligionConvenience;
import com.ruoyi.religion.service.IReligionConvenienceService;

/**
 * 便民服务Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@Service
public class ReligionConvenienceServiceImpl implements IReligionConvenienceService 
{
    @Autowired
    private ReligionConvenienceMapper religionConvenienceMapper;

    /**
     * 查询便民服务
     * 
     * @param id 便民服务主键
     * @return 便民服务
     */
    @Override
    public ReligionConvenience selectReligionConvenienceById(Long id)
    {
        return religionConvenienceMapper.selectReligionConvenienceById(id);
    }

    /**
     * 查询便民服务列表
     * 
     * @param religionConvenience 便民服务
     * @return 便民服务
     */
    @Override
    public List<ReligionConvenience> selectReligionConvenienceList(ReligionConvenience religionConvenience)
    {
        return religionConvenienceMapper.selectReligionConvenienceList(religionConvenience);
    }

    /**
     * 新增便民服务
     * 
     * @param religionConvenience 便民服务
     * @return 结果
     */
    @Override
    public int insertReligionConvenience(ReligionConvenience religionConvenience)
    {
        religionConvenience.setCreateTime(DateUtils.getNowDate());
        return religionConvenienceMapper.insertReligionConvenience(religionConvenience);
    }

    /**
     * 修改便民服务
     * 
     * @param religionConvenience 便民服务
     * @return 结果
     */
    @Override
    public int updateReligionConvenience(ReligionConvenience religionConvenience)
    {
        religionConvenience.setUpdateTime(DateUtils.getNowDate());
        return religionConvenienceMapper.updateReligionConvenience(religionConvenience);
    }

    /**
     * 批量删除便民服务
     * 
     * @param ids 需要删除的便民服务主键
     * @return 结果
     */
    @Override
    public int deleteReligionConvenienceByIds(Long[] ids)
    {
        return religionConvenienceMapper.deleteReligionConvenienceByIds(ids);
    }

    /**
     * 删除便民服务信息
     * 
     * @param id 便民服务主键
     * @return 结果
     */
    @Override
    public int deleteReligionConvenienceById(Long id)
    {
        return religionConvenienceMapper.deleteReligionConvenienceById(id);
    }
}
