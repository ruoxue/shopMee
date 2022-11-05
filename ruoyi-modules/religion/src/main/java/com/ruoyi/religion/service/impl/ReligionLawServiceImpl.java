package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionLawMapper;
import com.ruoyi.religion.domain.ReligionLaw;
import com.ruoyi.religion.service.IReligionLawService;

/**
 * 政策法规Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@Service
public class ReligionLawServiceImpl implements IReligionLawService 
{
    @Autowired
    private ReligionLawMapper religionLawMapper;

    /**
     * 查询政策法规
     * 
     * @param id 政策法规主键
     * @return 政策法规
     */
    @Override
    public ReligionLaw selectReligionLawById(Long id)
    {
        return religionLawMapper.selectReligionLawById(id);
    }

    /**
     * 查询政策法规列表
     * 
     * @param religionLaw 政策法规
     * @return 政策法规
     */
    @Override
    public List<ReligionLaw> selectReligionLawList(ReligionLaw religionLaw)
    {
        return religionLawMapper.selectReligionLawList(religionLaw);
    }

    /**
     * 新增政策法规
     * 
     * @param religionLaw 政策法规
     * @return 结果
     */
    @Override
    public int insertReligionLaw(ReligionLaw religionLaw)
    {
        religionLaw.setCreateTime(DateUtils.getNowDate());
        return religionLawMapper.insertReligionLaw(religionLaw);
    }

    /**
     * 修改政策法规
     * 
     * @param religionLaw 政策法规
     * @return 结果
     */
    @Override
    public int updateReligionLaw(ReligionLaw religionLaw)
    {
        religionLaw.setUpdateTime(DateUtils.getNowDate());
        return religionLawMapper.updateReligionLaw(religionLaw);
    }

    /**
     * 批量删除政策法规
     * 
     * @param ids 需要删除的政策法规主键
     * @return 结果
     */
    @Override
    public int deleteReligionLawByIds(Long[] ids)
    {
        return religionLawMapper.deleteReligionLawByIds(ids);
    }

    /**
     * 删除政策法规信息
     * 
     * @param id 政策法规主键
     * @return 结果
     */
    @Override
    public int deleteReligionLawById(Long id)
    {
        return religionLawMapper.deleteReligionLawById(id);
    }
}
