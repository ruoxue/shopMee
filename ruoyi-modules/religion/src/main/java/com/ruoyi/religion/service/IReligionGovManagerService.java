package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionGovManager;

/**
 * 行政许可备案Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
public interface IReligionGovManagerService 
{
    /**
     * 查询行政许可备案
     * 
     * @param id 行政许可备案主键
     * @return 行政许可备案
     */
    public ReligionGovManager selectReligionGovManagerById(Long id);

    /**
     * 查询行政许可备案列表
     * 
     * @param religionGovManager 行政许可备案
     * @return 行政许可备案集合
     */
    public List<ReligionGovManager> selectReligionGovManagerList(ReligionGovManager religionGovManager);

    /**
     * 新增行政许可备案
     * 
     * @param religionGovManager 行政许可备案
     * @return 结果
     */
    public int insertReligionGovManager(ReligionGovManager religionGovManager);

    /**
     * 修改行政许可备案
     * 
     * @param religionGovManager 行政许可备案
     * @return 结果
     */
    public int updateReligionGovManager(ReligionGovManager religionGovManager);

    /**
     * 批量删除行政许可备案
     * 
     * @param ids 需要删除的行政许可备案主键集合
     * @return 结果
     */
    public int deleteReligionGovManagerByIds(Long[] ids);

    /**
     * 删除行政许可备案信息
     * 
     * @param id 行政许可备案主键
     * @return 结果
     */
    public int deleteReligionGovManagerById(Long id);
}
