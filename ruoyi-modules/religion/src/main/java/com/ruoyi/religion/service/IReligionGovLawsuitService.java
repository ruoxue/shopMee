package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionGovLawsuit;

/**
 * 行政诉讼登记Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
public interface IReligionGovLawsuitService 
{
    /**
     * 查询行政诉讼登记
     * 
     * @param id 行政诉讼登记主键
     * @return 行政诉讼登记
     */
    public ReligionGovLawsuit selectReligionGovLawsuitById(Long id);

    /**
     * 查询行政诉讼登记列表
     * 
     * @param religionGovLawsuit 行政诉讼登记
     * @return 行政诉讼登记集合
     */
    public List<ReligionGovLawsuit> selectReligionGovLawsuitList(ReligionGovLawsuit religionGovLawsuit);

    /**
     * 新增行政诉讼登记
     * 
     * @param religionGovLawsuit 行政诉讼登记
     * @return 结果
     */
    public int insertReligionGovLawsuit(ReligionGovLawsuit religionGovLawsuit);

    /**
     * 修改行政诉讼登记
     * 
     * @param religionGovLawsuit 行政诉讼登记
     * @return 结果
     */
    public int updateReligionGovLawsuit(ReligionGovLawsuit religionGovLawsuit);

    /**
     * 批量删除行政诉讼登记
     * 
     * @param ids 需要删除的行政诉讼登记主键集合
     * @return 结果
     */
    public int deleteReligionGovLawsuitByIds(Long[] ids);

    /**
     * 删除行政诉讼登记信息
     * 
     * @param id 行政诉讼登记主键
     * @return 结果
     */
    public int deleteReligionGovLawsuitById(Long id);
}
