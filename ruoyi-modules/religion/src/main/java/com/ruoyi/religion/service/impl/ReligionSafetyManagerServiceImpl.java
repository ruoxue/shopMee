package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionSafetyManagerMapper;
import com.ruoyi.religion.domain.ReligionSafetyManager;
import com.ruoyi.religion.service.IReligionSafetyManagerService;

/**
 * 场所消防检查Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@Service
public class ReligionSafetyManagerServiceImpl implements IReligionSafetyManagerService 
{
    @Autowired
    private ReligionSafetyManagerMapper religionSafetyManagerMapper;

    /**
     * 查询场所消防检查
     * 
     * @param id 场所消防检查主键
     * @return 场所消防检查
     */
    @Override
    public ReligionSafetyManager selectReligionSafetyManagerById(Long id)
    {
        return religionSafetyManagerMapper.selectReligionSafetyManagerById(id);
    }

    /**
     * 查询场所消防检查列表
     * 
     * @param religionSafetyManager 场所消防检查
     * @return 场所消防检查
     */
    @Override
    public List<ReligionSafetyManager> selectReligionSafetyManagerList(ReligionSafetyManager religionSafetyManager)
    {
        return religionSafetyManagerMapper.selectReligionSafetyManagerList(religionSafetyManager);
    }

    /**
     * 新增场所消防检查
     * 
     * @param religionSafetyManager 场所消防检查
     * @return 结果
     */
    @Override
    public int insertReligionSafetyManager(ReligionSafetyManager religionSafetyManager)
    {
        religionSafetyManager.setCreateTime(DateUtils.getNowDate());
        return religionSafetyManagerMapper.insertReligionSafetyManager(religionSafetyManager);
    }

    /**
     * 修改场所消防检查
     * 
     * @param religionSafetyManager 场所消防检查
     * @return 结果
     */
    @Override
    public int updateReligionSafetyManager(ReligionSafetyManager religionSafetyManager)
    {
        religionSafetyManager.setUpdateTime(DateUtils.getNowDate());
        return religionSafetyManagerMapper.updateReligionSafetyManager(religionSafetyManager);
    }

    /**
     * 批量删除场所消防检查
     * 
     * @param ids 需要删除的场所消防检查主键
     * @return 结果
     */
    @Override
    public int deleteReligionSafetyManagerByIds(Long[] ids)
    {
        return religionSafetyManagerMapper.deleteReligionSafetyManagerByIds(ids);
    }

    /**
     * 删除场所消防检查信息
     * 
     * @param id 场所消防检查主键
     * @return 结果
     */
    @Override
    public int deleteReligionSafetyManagerById(Long id)
    {
        return religionSafetyManagerMapper.deleteReligionSafetyManagerById(id);
    }
}
