package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionNation;

/**
 * 民族Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
public interface IReligionNationService 
{
    /**
     * 查询民族
     * 
     * @param id 民族主键
     * @return 民族
     */
    public ReligionNation selectReligionNationById(Long id);

    /**
     * 查询民族列表
     * 
     * @param religionNation 民族
     * @return 民族集合
     */
    public List<ReligionNation> selectReligionNationList(ReligionNation religionNation);

    /**
     * 新增民族
     * 
     * @param religionNation 民族
     * @return 结果
     */
    public int insertReligionNation(ReligionNation religionNation);

    /**
     * 修改民族
     * 
     * @param religionNation 民族
     * @return 结果
     */
    public int updateReligionNation(ReligionNation religionNation);

    /**
     * 批量删除民族
     * 
     * @param ids 需要删除的民族主键集合
     * @return 结果
     */
    public int deleteReligionNationByIds(Long[] ids);

    /**
     * 删除民族信息
     * 
     * @param id 民族主键
     * @return 结果
     */
    public int deleteReligionNationById(Long id);
}
