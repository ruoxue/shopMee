package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionMemorialManagerMapper;
import com.ruoyi.religion.domain.ReligionMemorialManager;
import com.ruoyi.religion.service.IReligionMemorialManagerService;

/**
 * 牌位登记备案Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@Service
public class ReligionMemorialManagerServiceImpl implements IReligionMemorialManagerService 
{
    @Autowired
    private ReligionMemorialManagerMapper religionMemorialManagerMapper;

    /**
     * 查询牌位登记备案
     * 
     * @param id 牌位登记备案主键
     * @return 牌位登记备案
     */
    @Override
    public ReligionMemorialManager selectReligionMemorialManagerById(Long id)
    {
        return religionMemorialManagerMapper.selectReligionMemorialManagerById(id);
    }

    /**
     * 查询牌位登记备案列表
     * 
     * @param religionMemorialManager 牌位登记备案
     * @return 牌位登记备案
     */
    @Override
    public List<ReligionMemorialManager> selectReligionMemorialManagerList(ReligionMemorialManager religionMemorialManager)
    {
        return religionMemorialManagerMapper.selectReligionMemorialManagerList(religionMemorialManager);
    }

    /**
     * 新增牌位登记备案
     * 
     * @param religionMemorialManager 牌位登记备案
     * @return 结果
     */
    @Override
    public int insertReligionMemorialManager(ReligionMemorialManager religionMemorialManager)
    {
        religionMemorialManager.setCreateTime(DateUtils.getNowDate());
        return religionMemorialManagerMapper.insertReligionMemorialManager(religionMemorialManager);
    }

    /**
     * 修改牌位登记备案
     * 
     * @param religionMemorialManager 牌位登记备案
     * @return 结果
     */
    @Override
    public int updateReligionMemorialManager(ReligionMemorialManager religionMemorialManager)
    {
        religionMemorialManager.setUpdateTime(DateUtils.getNowDate());
        return religionMemorialManagerMapper.updateReligionMemorialManager(religionMemorialManager);
    }

    /**
     * 批量删除牌位登记备案
     * 
     * @param ids 需要删除的牌位登记备案主键
     * @return 结果
     */
    @Override
    public int deleteReligionMemorialManagerByIds(Long[] ids)
    {
        return religionMemorialManagerMapper.deleteReligionMemorialManagerByIds(ids);
    }

    /**
     * 删除牌位登记备案信息
     * 
     * @param id 牌位登记备案主键
     * @return 结果
     */
    @Override
    public int deleteReligionMemorialManagerById(Long id)
    {
        return religionMemorialManagerMapper.deleteReligionMemorialManagerById(id);
    }
}
