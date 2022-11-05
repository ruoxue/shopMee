package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionLaw;

/**
 * 政策法规Mapper接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
public interface ReligionLawMapper 
{
    /**
     * 查询政策法规
     * 
     * @param id 政策法规主键
     * @return 政策法规
     */
    public ReligionLaw selectReligionLawById(Long id);

    /**
     * 查询政策法规列表
     * 
     * @param religionLaw 政策法规
     * @return 政策法规集合
     */
    public List<ReligionLaw> selectReligionLawList(ReligionLaw religionLaw);

    /**
     * 新增政策法规
     * 
     * @param religionLaw 政策法规
     * @return 结果
     */
    public int insertReligionLaw(ReligionLaw religionLaw);

    /**
     * 修改政策法规
     * 
     * @param religionLaw 政策法规
     * @return 结果
     */
    public int updateReligionLaw(ReligionLaw religionLaw);

    /**
     * 删除政策法规
     * 
     * @param id 政策法规主键
     * @return 结果
     */
    public int deleteReligionLawById(Long id);

    /**
     * 批量删除政策法规
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionLawByIds(Long[] ids);
}
