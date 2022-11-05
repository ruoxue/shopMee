package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionInfoManager;

/**
 * 信息登记Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 23:25:25
 */
public interface IReligionInfoManagerService 
{
    /**
     * 查询信息登记
     * 
     * @param id 信息登记主键
     * @return 信息登记
     */
    public ReligionInfoManager selectReligionInfoManagerById(Long id);

    /**
     * 查询信息登记列表
     * 
     * @param religionInfoManager 信息登记
     * @return 信息登记集合
     */
    public List<ReligionInfoManager> selectReligionInfoManagerList(ReligionInfoManager religionInfoManager);

    /**
     * 新增信息登记
     * 
     * @param religionInfoManager 信息登记
     * @return 结果
     */
    public int insertReligionInfoManager(ReligionInfoManager religionInfoManager);

    /**
     * 修改信息登记
     * 
     * @param religionInfoManager 信息登记
     * @return 结果
     */
    public int updateReligionInfoManager(ReligionInfoManager religionInfoManager);

    /**
     * 批量删除信息登记
     * 
     * @param ids 需要删除的信息登记主键集合
     * @return 结果
     */
    public int deleteReligionInfoManagerByIds(Long[] ids);

    /**
     * 删除信息登记信息
     * 
     * @param id 信息登记主键
     * @return 结果
     */
    public int deleteReligionInfoManagerById(Long id);
}
