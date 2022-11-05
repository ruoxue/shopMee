package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionDynamicInfo;

/**
 * 动态信息Mapper接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
public interface ReligionDynamicInfoMapper 
{
    /**
     * 查询动态信息
     * 
     * @param id 动态信息主键
     * @return 动态信息
     */
    public ReligionDynamicInfo selectReligionDynamicInfoById(Long id);

    /**
     * 查询动态信息列表
     * 
     * @param religionDynamicInfo 动态信息
     * @return 动态信息集合
     */
    public List<ReligionDynamicInfo> selectReligionDynamicInfoList(ReligionDynamicInfo religionDynamicInfo);

    /**
     * 新增动态信息
     * 
     * @param religionDynamicInfo 动态信息
     * @return 结果
     */
    public int insertReligionDynamicInfo(ReligionDynamicInfo religionDynamicInfo);

    /**
     * 修改动态信息
     * 
     * @param religionDynamicInfo 动态信息
     * @return 结果
     */
    public int updateReligionDynamicInfo(ReligionDynamicInfo religionDynamicInfo);

    /**
     * 删除动态信息
     * 
     * @param id 动态信息主键
     * @return 结果
     */
    public int deleteReligionDynamicInfoById(Long id);

    /**
     * 批量删除动态信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionDynamicInfoByIds(Long[] ids);
}
