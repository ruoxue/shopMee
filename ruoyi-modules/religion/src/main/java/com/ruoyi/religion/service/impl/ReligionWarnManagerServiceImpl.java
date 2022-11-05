package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionWarnManagerMapper;
import com.ruoyi.religion.domain.ReligionWarnManager;
import com.ruoyi.religion.service.IReligionWarnManagerService;

/**
 * 场所消防设施分布Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:33
 */
@Service
public class ReligionWarnManagerServiceImpl implements IReligionWarnManagerService 
{
    @Autowired
    private ReligionWarnManagerMapper religionWarnManagerMapper;

    /**
     * 查询场所消防设施分布
     * 
     * @param id 场所消防设施分布主键
     * @return 场所消防设施分布
     */
    @Override
    public ReligionWarnManager selectReligionWarnManagerById(Long id)
    {
        return religionWarnManagerMapper.selectReligionWarnManagerById(id);
    }

    /**
     * 查询场所消防设施分布列表
     * 
     * @param religionWarnManager 场所消防设施分布
     * @return 场所消防设施分布
     */
    @Override
    public List<ReligionWarnManager> selectReligionWarnManagerList(ReligionWarnManager religionWarnManager)
    {
        return religionWarnManagerMapper.selectReligionWarnManagerList(religionWarnManager);
    }

    /**
     * 新增场所消防设施分布
     * 
     * @param religionWarnManager 场所消防设施分布
     * @return 结果
     */
    @Override
    public int insertReligionWarnManager(ReligionWarnManager religionWarnManager)
    {
        religionWarnManager.setCreateTime(DateUtils.getNowDate());
        return religionWarnManagerMapper.insertReligionWarnManager(religionWarnManager);
    }

    /**
     * 修改场所消防设施分布
     * 
     * @param religionWarnManager 场所消防设施分布
     * @return 结果
     */
    @Override
    public int updateReligionWarnManager(ReligionWarnManager religionWarnManager)
    {
        religionWarnManager.setUpdateTime(DateUtils.getNowDate());
        return religionWarnManagerMapper.updateReligionWarnManager(religionWarnManager);
    }

    /**
     * 批量删除场所消防设施分布
     * 
     * @param ids 需要删除的场所消防设施分布主键
     * @return 结果
     */
    @Override
    public int deleteReligionWarnManagerByIds(Long[] ids)
    {
        return religionWarnManagerMapper.deleteReligionWarnManagerByIds(ids);
    }

    /**
     * 删除场所消防设施分布信息
     * 
     * @param id 场所消防设施分布主键
     * @return 结果
     */
    @Override
    public int deleteReligionWarnManagerById(Long id)
    {
        return religionWarnManagerMapper.deleteReligionWarnManagerById(id);
    }
}
