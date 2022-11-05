package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionHalalManagerMapper;
import com.ruoyi.religion.domain.ReligionHalalManager;
import com.ruoyi.religion.service.IReligionHalalManagerService;

/**
 * 清真食品备案Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@Service
public class ReligionHalalManagerServiceImpl implements IReligionHalalManagerService 
{
    @Autowired
    private ReligionHalalManagerMapper religionHalalManagerMapper;

    /**
     * 查询清真食品备案
     * 
     * @param id 清真食品备案主键
     * @return 清真食品备案
     */
    @Override
    public ReligionHalalManager selectReligionHalalManagerById(Long id)
    {
        return religionHalalManagerMapper.selectReligionHalalManagerById(id);
    }

    /**
     * 查询清真食品备案列表
     * 
     * @param religionHalalManager 清真食品备案
     * @return 清真食品备案
     */
    @Override
    public List<ReligionHalalManager> selectReligionHalalManagerList(ReligionHalalManager religionHalalManager)
    {
        return religionHalalManagerMapper.selectReligionHalalManagerList(religionHalalManager);
    }

    /**
     * 新增清真食品备案
     * 
     * @param religionHalalManager 清真食品备案
     * @return 结果
     */
    @Override
    public int insertReligionHalalManager(ReligionHalalManager religionHalalManager)
    {
        religionHalalManager.setCreateTime(DateUtils.getNowDate());
        return religionHalalManagerMapper.insertReligionHalalManager(religionHalalManager);
    }

    /**
     * 修改清真食品备案
     * 
     * @param religionHalalManager 清真食品备案
     * @return 结果
     */
    @Override
    public int updateReligionHalalManager(ReligionHalalManager religionHalalManager)
    {
        religionHalalManager.setUpdateTime(DateUtils.getNowDate());
        return religionHalalManagerMapper.updateReligionHalalManager(religionHalalManager);
    }

    /**
     * 批量删除清真食品备案
     * 
     * @param ids 需要删除的清真食品备案主键
     * @return 结果
     */
    @Override
    public int deleteReligionHalalManagerByIds(Long[] ids)
    {
        return religionHalalManagerMapper.deleteReligionHalalManagerByIds(ids);
    }

    /**
     * 删除清真食品备案信息
     * 
     * @param id 清真食品备案主键
     * @return 结果
     */
    @Override
    public int deleteReligionHalalManagerById(Long id)
    {
        return religionHalalManagerMapper.deleteReligionHalalManagerById(id);
    }
}
