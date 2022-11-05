package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionEpidemicControl;

/**
 * 疫情防控检查Mapper接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
public interface ReligionEpidemicControlMapper 
{
    /**
     * 查询疫情防控检查
     * 
     * @param id 疫情防控检查主键
     * @return 疫情防控检查
     */
    public ReligionEpidemicControl selectReligionEpidemicControlById(Long id);

    /**
     * 查询疫情防控检查列表
     * 
     * @param religionEpidemicControl 疫情防控检查
     * @return 疫情防控检查集合
     */
    public List<ReligionEpidemicControl> selectReligionEpidemicControlList(ReligionEpidemicControl religionEpidemicControl);

    /**
     * 新增疫情防控检查
     * 
     * @param religionEpidemicControl 疫情防控检查
     * @return 结果
     */
    public int insertReligionEpidemicControl(ReligionEpidemicControl religionEpidemicControl);

    /**
     * 修改疫情防控检查
     * 
     * @param religionEpidemicControl 疫情防控检查
     * @return 结果
     */
    public int updateReligionEpidemicControl(ReligionEpidemicControl religionEpidemicControl);

    /**
     * 删除疫情防控检查
     * 
     * @param id 疫情防控检查主键
     * @return 结果
     */
    public int deleteReligionEpidemicControlById(Long id);

    /**
     * 批量删除疫情防控检查
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionEpidemicControlByIds(Long[] ids);
}
