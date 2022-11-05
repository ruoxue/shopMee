package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionEpidemicControl;

/**
 * 疫情防控检查Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
public interface IReligionEpidemicControlService 
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
     * 批量删除疫情防控检查
     * 
     * @param ids 需要删除的疫情防控检查主键集合
     * @return 结果
     */
    public int deleteReligionEpidemicControlByIds(Long[] ids);

    /**
     * 删除疫情防控检查信息
     * 
     * @param id 疫情防控检查主键
     * @return 结果
     */
    public int deleteReligionEpidemicControlById(Long id);
}
