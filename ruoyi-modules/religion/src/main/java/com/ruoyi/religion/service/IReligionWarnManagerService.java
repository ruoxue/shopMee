package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionWarnManager;

/**
 * 场所消防设施分布Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:33
 */
public interface IReligionWarnManagerService 
{
    /**
     * 查询场所消防设施分布
     * 
     * @param id 场所消防设施分布主键
     * @return 场所消防设施分布
     */
    public ReligionWarnManager selectReligionWarnManagerById(Long id);

    /**
     * 查询场所消防设施分布列表
     * 
     * @param religionWarnManager 场所消防设施分布
     * @return 场所消防设施分布集合
     */
    public List<ReligionWarnManager> selectReligionWarnManagerList(ReligionWarnManager religionWarnManager);

    /**
     * 新增场所消防设施分布
     * 
     * @param religionWarnManager 场所消防设施分布
     * @return 结果
     */
    public int insertReligionWarnManager(ReligionWarnManager religionWarnManager);

    /**
     * 修改场所消防设施分布
     * 
     * @param religionWarnManager 场所消防设施分布
     * @return 结果
     */
    public int updateReligionWarnManager(ReligionWarnManager religionWarnManager);

    /**
     * 批量删除场所消防设施分布
     * 
     * @param ids 需要删除的场所消防设施分布主键集合
     * @return 结果
     */
    public int deleteReligionWarnManagerByIds(Long[] ids);

    /**
     * 删除场所消防设施分布信息
     * 
     * @param id 场所消防设施分布主键
     * @return 结果
     */
    public int deleteReligionWarnManagerById(Long id);
}
