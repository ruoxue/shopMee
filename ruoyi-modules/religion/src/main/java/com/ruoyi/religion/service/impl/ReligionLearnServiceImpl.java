package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionLearnMapper;
import com.ruoyi.religion.domain.ReligionLearn;
import com.ruoyi.religion.service.IReligionLearnService;

/**
 * 文化学习Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@Service
public class ReligionLearnServiceImpl implements IReligionLearnService 
{
    @Autowired
    private ReligionLearnMapper religionLearnMapper;

    /**
     * 查询文化学习
     * 
     * @param id 文化学习主键
     * @return 文化学习
     */
    @Override
    public ReligionLearn selectReligionLearnById(Long id)
    {
        return religionLearnMapper.selectReligionLearnById(id);
    }

    /**
     * 查询文化学习列表
     * 
     * @param religionLearn 文化学习
     * @return 文化学习
     */
    @Override
    public List<ReligionLearn> selectReligionLearnList(ReligionLearn religionLearn)
    {
        return religionLearnMapper.selectReligionLearnList(religionLearn);
    }

    /**
     * 新增文化学习
     * 
     * @param religionLearn 文化学习
     * @return 结果
     */
    @Override
    public int insertReligionLearn(ReligionLearn religionLearn)
    {
        religionLearn.setCreateTime(DateUtils.getNowDate());
        return religionLearnMapper.insertReligionLearn(religionLearn);
    }

    /**
     * 修改文化学习
     * 
     * @param religionLearn 文化学习
     * @return 结果
     */
    @Override
    public int updateReligionLearn(ReligionLearn religionLearn)
    {
        religionLearn.setUpdateTime(DateUtils.getNowDate());
        return religionLearnMapper.updateReligionLearn(religionLearn);
    }

    /**
     * 批量删除文化学习
     * 
     * @param ids 需要删除的文化学习主键
     * @return 结果
     */
    @Override
    public int deleteReligionLearnByIds(Long[] ids)
    {
        return religionLearnMapper.deleteReligionLearnByIds(ids);
    }

    /**
     * 删除文化学习信息
     * 
     * @param id 文化学习主键
     * @return 结果
     */
    @Override
    public int deleteReligionLearnById(Long id)
    {
        return religionLearnMapper.deleteReligionLearnById(id);
    }
}
