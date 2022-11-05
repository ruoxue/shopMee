package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionPartyManager;

/**
 * 集会登记Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
public interface IReligionPartyManagerService 
{
    /**
     * 查询集会登记
     * 
     * @param id 集会登记主键
     * @return 集会登记
     */
    public ReligionPartyManager selectReligionPartyManagerById(Long id);

    /**
     * 查询集会登记列表
     * 
     * @param religionPartyManager 集会登记
     * @return 集会登记集合
     */
    public List<ReligionPartyManager> selectReligionPartyManagerList(ReligionPartyManager religionPartyManager);

    /**
     * 新增集会登记
     * 
     * @param religionPartyManager 集会登记
     * @return 结果
     */
    public int insertReligionPartyManager(ReligionPartyManager religionPartyManager);

    /**
     * 修改集会登记
     * 
     * @param religionPartyManager 集会登记
     * @return 结果
     */
    public int updateReligionPartyManager(ReligionPartyManager religionPartyManager);

    /**
     * 批量删除集会登记
     * 
     * @param ids 需要删除的集会登记主键集合
     * @return 结果
     */
    public int deleteReligionPartyManagerByIds(Long[] ids);

    /**
     * 删除集会登记信息
     * 
     * @param id 集会登记主键
     * @return 结果
     */
    public int deleteReligionPartyManagerById(Long id);
}
