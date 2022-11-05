package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionOutuserManagerMapper;
import com.ruoyi.religion.domain.ReligionOutuserManager;
import com.ruoyi.religion.service.IReligionOutuserManagerService;

/**
 * 临时人员登记Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@Service
public class ReligionOutuserManagerServiceImpl implements IReligionOutuserManagerService 
{
    @Autowired
    private ReligionOutuserManagerMapper religionOutuserManagerMapper;

    /**
     * 查询临时人员登记
     * 
     * @param id 临时人员登记主键
     * @return 临时人员登记
     */
    @Override
    public ReligionOutuserManager selectReligionOutuserManagerById(Long id)
    {
        return religionOutuserManagerMapper.selectReligionOutuserManagerById(id);
    }

    /**
     * 查询临时人员登记列表
     * 
     * @param religionOutuserManager 临时人员登记
     * @return 临时人员登记
     */
    @Override
    public List<ReligionOutuserManager> selectReligionOutuserManagerList(ReligionOutuserManager religionOutuserManager)
    {
        return religionOutuserManagerMapper.selectReligionOutuserManagerList(religionOutuserManager);
    }

    /**
     * 新增临时人员登记
     * 
     * @param religionOutuserManager 临时人员登记
     * @return 结果
     */
    @Override
    public int insertReligionOutuserManager(ReligionOutuserManager religionOutuserManager)
    {
        religionOutuserManager.setCreateTime(DateUtils.getNowDate());
        return religionOutuserManagerMapper.insertReligionOutuserManager(religionOutuserManager);
    }

    /**
     * 修改临时人员登记
     * 
     * @param religionOutuserManager 临时人员登记
     * @return 结果
     */
    @Override
    public int updateReligionOutuserManager(ReligionOutuserManager religionOutuserManager)
    {
        religionOutuserManager.setUpdateTime(DateUtils.getNowDate());
        return religionOutuserManagerMapper.updateReligionOutuserManager(religionOutuserManager);
    }

    /**
     * 批量删除临时人员登记
     * 
     * @param ids 需要删除的临时人员登记主键
     * @return 结果
     */
    @Override
    public int deleteReligionOutuserManagerByIds(Long[] ids)
    {
        return religionOutuserManagerMapper.deleteReligionOutuserManagerByIds(ids);
    }

    /**
     * 删除临时人员登记信息
     * 
     * @param id 临时人员登记主键
     * @return 结果
     */
    @Override
    public int deleteReligionOutuserManagerById(Long id)
    {
        return religionOutuserManagerMapper.deleteReligionOutuserManagerById(id);
    }
}
