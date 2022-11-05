package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionHalalManager;

/**
 * 清真食品备案Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
public interface IReligionHalalManagerService 
{
    /**
     * 查询清真食品备案
     * 
     * @param id 清真食品备案主键
     * @return 清真食品备案
     */
    public ReligionHalalManager selectReligionHalalManagerById(Long id);

    /**
     * 查询清真食品备案列表
     * 
     * @param religionHalalManager 清真食品备案
     * @return 清真食品备案集合
     */
    public List<ReligionHalalManager> selectReligionHalalManagerList(ReligionHalalManager religionHalalManager);

    /**
     * 新增清真食品备案
     * 
     * @param religionHalalManager 清真食品备案
     * @return 结果
     */
    public int insertReligionHalalManager(ReligionHalalManager religionHalalManager);

    /**
     * 修改清真食品备案
     * 
     * @param religionHalalManager 清真食品备案
     * @return 结果
     */
    public int updateReligionHalalManager(ReligionHalalManager religionHalalManager);

    /**
     * 批量删除清真食品备案
     * 
     * @param ids 需要删除的清真食品备案主键集合
     * @return 结果
     */
    public int deleteReligionHalalManagerByIds(Long[] ids);

    /**
     * 删除清真食品备案信息
     * 
     * @param id 清真食品备案主键
     * @return 结果
     */
    public int deleteReligionHalalManagerById(Long id);
}
