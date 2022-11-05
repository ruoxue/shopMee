package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionFrenchManager;

/**
 * 法会登记备案Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
public interface IReligionFrenchManagerService 
{
    /**
     * 查询法会登记备案
     * 
     * @param id 法会登记备案主键
     * @return 法会登记备案
     */
    public ReligionFrenchManager selectReligionFrenchManagerById(Long id);

    /**
     * 查询法会登记备案列表
     * 
     * @param religionFrenchManager 法会登记备案
     * @return 法会登记备案集合
     */
    public List<ReligionFrenchManager> selectReligionFrenchManagerList(ReligionFrenchManager religionFrenchManager);

    /**
     * 新增法会登记备案
     * 
     * @param religionFrenchManager 法会登记备案
     * @return 结果
     */
    public int insertReligionFrenchManager(ReligionFrenchManager religionFrenchManager);

    /**
     * 修改法会登记备案
     * 
     * @param religionFrenchManager 法会登记备案
     * @return 结果
     */
    public int updateReligionFrenchManager(ReligionFrenchManager religionFrenchManager);

    /**
     * 批量删除法会登记备案
     * 
     * @param ids 需要删除的法会登记备案主键集合
     * @return 结果
     */
    public int deleteReligionFrenchManagerByIds(Long[] ids);

    /**
     * 删除法会登记备案信息
     * 
     * @param id 法会登记备案主键
     * @return 结果
     */
    public int deleteReligionFrenchManagerById(Long id);
}
