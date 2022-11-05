package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionRitualManager;

/**
 * 法事登记备案Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
public interface IReligionRitualManagerService 
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
     * 批量删除法事登记备案
     * 
     * @param ids 需要删除的法事登记备案主键集合
     * @return 结果
     */
    public int deleteReligionRitualManagerByIds(Long[] ids);

    /**
     * 删除法事登记备案信息
     * 
     * @param id 法事登记备案主键
     * @return 结果
     */
    public int deleteReligionRitualManagerById(Long id);
}
