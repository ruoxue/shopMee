package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionFrenchManager;

/**
 * 法会登记备案Mapper接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
public interface ReligionFrenchManagerMapper 
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
     * 删除法会登记备案
     * 
     * @param id 法会登记备案主键
     * @return 结果
     */
    public int deleteReligionFrenchManagerById(Long id);

    /**
     * 批量删除法会登记备案
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionFrenchManagerByIds(Long[] ids);
}
