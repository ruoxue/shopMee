package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionIllegalUseManager;

/**
 * 违法用地场所Mapper接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:30
 */
public interface ReligionIllegalUseManagerMapper 
{
    /**
     * 查询违法用地场所
     * 
     * @param id 违法用地场所主键
     * @return 违法用地场所
     */
    public ReligionIllegalUseManager selectReligionIllegalUseManagerById(Long id);

    /**
     * 查询违法用地场所列表
     * 
     * @param religionIllegalUseManager 违法用地场所
     * @return 违法用地场所集合
     */
    public List<ReligionIllegalUseManager> selectReligionIllegalUseManagerList(ReligionIllegalUseManager religionIllegalUseManager);

    /**
     * 新增违法用地场所
     * 
     * @param religionIllegalUseManager 违法用地场所
     * @return 结果
     */
    public int insertReligionIllegalUseManager(ReligionIllegalUseManager religionIllegalUseManager);

    /**
     * 修改违法用地场所
     * 
     * @param religionIllegalUseManager 违法用地场所
     * @return 结果
     */
    public int updateReligionIllegalUseManager(ReligionIllegalUseManager religionIllegalUseManager);

    /**
     * 删除违法用地场所
     * 
     * @param id 违法用地场所主键
     * @return 结果
     */
    public int deleteReligionIllegalUseManagerById(Long id);

    /**
     * 批量删除违法用地场所
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionIllegalUseManagerByIds(Long[] ids);
}
