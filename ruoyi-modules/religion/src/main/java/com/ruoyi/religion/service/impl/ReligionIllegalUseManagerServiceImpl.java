package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionIllegalUseManagerMapper;
import com.ruoyi.religion.domain.ReligionIllegalUseManager;
import com.ruoyi.religion.service.IReligionIllegalUseManagerService;

/**
 * 违法用地场所Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:30
 */
@Service
public class ReligionIllegalUseManagerServiceImpl implements IReligionIllegalUseManagerService 
{
    @Autowired
    private ReligionIllegalUseManagerMapper religionIllegalUseManagerMapper;

    /**
     * 查询违法用地场所
     * 
     * @param id 违法用地场所主键
     * @return 违法用地场所
     */
    @Override
    public ReligionIllegalUseManager selectReligionIllegalUseManagerById(Long id)
    {
        return religionIllegalUseManagerMapper.selectReligionIllegalUseManagerById(id);
    }

    /**
     * 查询违法用地场所列表
     * 
     * @param religionIllegalUseManager 违法用地场所
     * @return 违法用地场所
     */
    @Override
    public List<ReligionIllegalUseManager> selectReligionIllegalUseManagerList(ReligionIllegalUseManager religionIllegalUseManager)
    {
        return religionIllegalUseManagerMapper.selectReligionIllegalUseManagerList(religionIllegalUseManager);
    }

    /**
     * 新增违法用地场所
     * 
     * @param religionIllegalUseManager 违法用地场所
     * @return 结果
     */
    @Override
    public int insertReligionIllegalUseManager(ReligionIllegalUseManager religionIllegalUseManager)
    {
        religionIllegalUseManager.setCreateTime(DateUtils.getNowDate());
        return religionIllegalUseManagerMapper.insertReligionIllegalUseManager(religionIllegalUseManager);
    }

    /**
     * 修改违法用地场所
     * 
     * @param religionIllegalUseManager 违法用地场所
     * @return 结果
     */
    @Override
    public int updateReligionIllegalUseManager(ReligionIllegalUseManager religionIllegalUseManager)
    {
        religionIllegalUseManager.setUpdateTime(DateUtils.getNowDate());
        return religionIllegalUseManagerMapper.updateReligionIllegalUseManager(religionIllegalUseManager);
    }

    /**
     * 批量删除违法用地场所
     * 
     * @param ids 需要删除的违法用地场所主键
     * @return 结果
     */
    @Override
    public int deleteReligionIllegalUseManagerByIds(Long[] ids)
    {
        return religionIllegalUseManagerMapper.deleteReligionIllegalUseManagerByIds(ids);
    }

    /**
     * 删除违法用地场所信息
     * 
     * @param id 违法用地场所主键
     * @return 结果
     */
    @Override
    public int deleteReligionIllegalUseManagerById(Long id)
    {
        return religionIllegalUseManagerMapper.deleteReligionIllegalUseManagerById(id);
    }
}
