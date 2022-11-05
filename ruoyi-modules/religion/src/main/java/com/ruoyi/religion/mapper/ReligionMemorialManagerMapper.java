package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionMemorialManager;

/**
 * 牌位登记备案Mapper接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
public interface ReligionMemorialManagerMapper 
{
    /**
     * 查询牌位登记备案
     * 
     * @param id 牌位登记备案主键
     * @return 牌位登记备案
     */
    public ReligionMemorialManager selectReligionMemorialManagerById(Long id);

    /**
     * 查询牌位登记备案列表
     * 
     * @param religionMemorialManager 牌位登记备案
     * @return 牌位登记备案集合
     */
    public List<ReligionMemorialManager> selectReligionMemorialManagerList(ReligionMemorialManager religionMemorialManager);

    /**
     * 新增牌位登记备案
     * 
     * @param religionMemorialManager 牌位登记备案
     * @return 结果
     */
    public int insertReligionMemorialManager(ReligionMemorialManager religionMemorialManager);

    /**
     * 修改牌位登记备案
     * 
     * @param religionMemorialManager 牌位登记备案
     * @return 结果
     */
    public int updateReligionMemorialManager(ReligionMemorialManager religionMemorialManager);

    /**
     * 删除牌位登记备案
     * 
     * @param id 牌位登记备案主键
     * @return 结果
     */
    public int deleteReligionMemorialManagerById(Long id);

    /**
     * 批量删除牌位登记备案
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionMemorialManagerByIds(Long[] ids);
}
