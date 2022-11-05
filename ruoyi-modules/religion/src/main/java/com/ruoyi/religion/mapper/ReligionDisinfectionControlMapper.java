package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionDisinfectionControl;

/**
 * 场所消杀管理Mapper接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
public interface ReligionDisinfectionControlMapper 
{
    /**
     * 查询场所消杀管理
     * 
     * @param id 场所消杀管理主键
     * @return 场所消杀管理
     */
    public ReligionDisinfectionControl selectReligionDisinfectionControlById(Long id);

    /**
     * 查询场所消杀管理列表
     * 
     * @param religionDisinfectionControl 场所消杀管理
     * @return 场所消杀管理集合
     */
    public List<ReligionDisinfectionControl> selectReligionDisinfectionControlList(ReligionDisinfectionControl religionDisinfectionControl);

    /**
     * 新增场所消杀管理
     * 
     * @param religionDisinfectionControl 场所消杀管理
     * @return 结果
     */
    public int insertReligionDisinfectionControl(ReligionDisinfectionControl religionDisinfectionControl);

    /**
     * 修改场所消杀管理
     * 
     * @param religionDisinfectionControl 场所消杀管理
     * @return 结果
     */
    public int updateReligionDisinfectionControl(ReligionDisinfectionControl religionDisinfectionControl);

    /**
     * 删除场所消杀管理
     * 
     * @param id 场所消杀管理主键
     * @return 结果
     */
    public int deleteReligionDisinfectionControlById(Long id);

    /**
     * 批量删除场所消杀管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionDisinfectionControlByIds(Long[] ids);
}
