package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionAreaMapper;
import com.ruoyi.religion.domain.ReligionArea;
import com.ruoyi.religion.service.IReligionAreaService;

/**
 * 宗教场所Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:30
 */
@Service
public class ReligionAreaServiceImpl implements IReligionAreaService 
{
    @Autowired
    private ReligionAreaMapper religionAreaMapper;

    /**
     * 查询宗教场所
     * 
     * @param id 宗教场所主键
     * @return 宗教场所
     */
    @Override
    public ReligionArea selectReligionAreaById(Long id)
    {
        return religionAreaMapper.selectReligionAreaById(id);
    }

    /**
     * 查询宗教场所列表
     * 
     * @param religionArea 宗教场所
     * @return 宗教场所
     */
    @Override
    public List<ReligionArea> selectReligionAreaList(ReligionArea religionArea)
    {
        return religionAreaMapper.selectReligionAreaList(religionArea);
    }

    /**
     * 新增宗教场所
     * 
     * @param religionArea 宗教场所
     * @return 结果
     */
    @Override
    public int insertReligionArea(ReligionArea religionArea)
    {
        religionArea.setCreateTime(DateUtils.getNowDate());
        return religionAreaMapper.insertReligionArea(religionArea);
    }

    /**
     * 修改宗教场所
     * 
     * @param religionArea 宗教场所
     * @return 结果
     */
    @Override
    public int updateReligionArea(ReligionArea religionArea)
    {
        religionArea.setUpdateTime(DateUtils.getNowDate());
        return religionAreaMapper.updateReligionArea(religionArea);
    }

    /**
     * 批量删除宗教场所
     * 
     * @param ids 需要删除的宗教场所主键
     * @return 结果
     */
    @Override
    public int deleteReligionAreaByIds(Long[] ids)
    {
        return religionAreaMapper.deleteReligionAreaByIds(ids);
    }

    /**
     * 删除宗教场所信息
     * 
     * @param id 宗教场所主键
     * @return 结果
     */
    @Override
    public int deleteReligionAreaById(Long id)
    {
        return religionAreaMapper.deleteReligionAreaById(id);
    }
}
