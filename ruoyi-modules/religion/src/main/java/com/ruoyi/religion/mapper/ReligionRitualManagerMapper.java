package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionRitualManager;

/**
 * 法事登记备案Mapper接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
public interface ReligionRitualManagerMapper 
{
    /**
     * 查询法事登记备案
     * 
     * @param id 法事登记备案主键
     * @return 法事登记备案
     */
    public ReligionRitualManager selectReligionRitualManagerById(Long id);

    /**
     * 查询法事登记备案列表
     * 
     * @param religionRitualManager 法事登记备案
     * @return 法事登记备案集合
     */
    public List<ReligionRitualManager> selectReligionRitualManagerList(ReligionRitualManager religionRitualManager);

    /**
     * 新增法事登记备案
     * 
     * @param religionRitualManager 法事登记备案
     * @return 结果
     */
    public int insertReligionRitualManager(ReligionRitualManager religionRitualManager);

    /**
     * 修改法事登记备案
     * 
     * @param religionRitualManager 法事登记备案
     * @return 结果
     */
    public int updateReligionRitualManager(ReligionRitualManager religionRitualManager);

    /**
     * 删除法事登记备案
     * 
     * @param id 法事登记备案主键
     * @return 结果
     */
    public int deleteReligionRitualManagerById(Long id);

    /**
     * 批量删除法事登记备案
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionRitualManagerByIds(Long[] ids);
}
