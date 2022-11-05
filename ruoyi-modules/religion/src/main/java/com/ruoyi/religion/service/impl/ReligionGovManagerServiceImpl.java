package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionGovManagerMapper;
import com.ruoyi.religion.domain.ReligionGovManager;
import com.ruoyi.religion.service.IReligionGovManagerService;

/**
 * 行政许可备案Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@Service
public class ReligionGovManagerServiceImpl implements IReligionGovManagerService 
{
    @Autowired
    private ReligionGovManagerMapper religionGovManagerMapper;

    /**
     * 查询行政许可备案
     * 
     * @param id 行政许可备案主键
     * @return 行政许可备案
     */
    @Override
    public ReligionGovManager selectReligionGovManagerById(Long id)
    {
        return religionGovManagerMapper.selectReligionGovManagerById(id);
    }

    /**
     * 查询行政许可备案列表
     * 
     * @param religionGovManager 行政许可备案
     * @return 行政许可备案
     */
    @Override
    public List<ReligionGovManager> selectReligionGovManagerList(ReligionGovManager religionGovManager)
    {
        return religionGovManagerMapper.selectReligionGovManagerList(religionGovManager);
    }

    /**
     * 新增行政许可备案
     * 
     * @param religionGovManager 行政许可备案
     * @return 结果
     */
    @Override
    public int insertReligionGovManager(ReligionGovManager religionGovManager)
    {
        religionGovManager.setCreateTime(DateUtils.getNowDate());
        return religionGovManagerMapper.insertReligionGovManager(religionGovManager);
    }

    /**
     * 修改行政许可备案
     * 
     * @param religionGovManager 行政许可备案
     * @return 结果
     */
    @Override
    public int updateReligionGovManager(ReligionGovManager religionGovManager)
    {
        religionGovManager.setUpdateTime(DateUtils.getNowDate());
        return religionGovManagerMapper.updateReligionGovManager(religionGovManager);
    }

    /**
     * 批量删除行政许可备案
     * 
     * @param ids 需要删除的行政许可备案主键
     * @return 结果
     */
    @Override
    public int deleteReligionGovManagerByIds(Long[] ids)
    {
        return religionGovManagerMapper.deleteReligionGovManagerByIds(ids);
    }

    /**
     * 删除行政许可备案信息
     * 
     * @param id 行政许可备案主键
     * @return 结果
     */
    @Override
    public int deleteReligionGovManagerById(Long id)
    {
        return religionGovManagerMapper.deleteReligionGovManagerById(id);
    }
}
