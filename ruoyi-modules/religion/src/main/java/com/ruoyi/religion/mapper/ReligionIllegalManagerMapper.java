package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionIllegalManager;

/**
 * 非法活动管理Mapper接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
public interface ReligionIllegalManagerMapper 
{
    /**
     * 查询非法活动管理
     * 
     * @param id 非法活动管理主键
     * @return 非法活动管理
     */
    public ReligionIllegalManager selectReligionIllegalManagerById(Long id);

    /**
     * 查询非法活动管理列表
     * 
     * @param religionIllegalManager 非法活动管理
     * @return 非法活动管理集合
     */
    public List<ReligionIllegalManager> selectReligionIllegalManagerList(ReligionIllegalManager religionIllegalManager);

    /**
     * 新增非法活动管理
     * 
     * @param religionIllegalManager 非法活动管理
     * @return 结果
     */
    public int insertReligionIllegalManager(ReligionIllegalManager religionIllegalManager);

    /**
     * 修改非法活动管理
     * 
     * @param religionIllegalManager 非法活动管理
     * @return 结果
     */
    public int updateReligionIllegalManager(ReligionIllegalManager religionIllegalManager);

    /**
     * 删除非法活动管理
     * 
     * @param id 非法活动管理主键
     * @return 结果
     */
    public int deleteReligionIllegalManagerById(Long id);

    /**
     * 批量删除非法活动管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionIllegalManagerByIds(Long[] ids);
}
