package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionArea;

/**
 * 宗教场所Mapper接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:30
 */
public interface ReligionAreaMapper 
{
    /**
     * 查询宗教场所
     * 
     * @param id 宗教场所主键
     * @return 宗教场所
     */
    public ReligionArea selectReligionAreaById(Long id);

    /**
     * 查询宗教场所列表
     * 
     * @param religionArea 宗教场所
     * @return 宗教场所集合
     */
    public List<ReligionArea> selectReligionAreaList(ReligionArea religionArea);

    /**
     * 新增宗教场所
     * 
     * @param religionArea 宗教场所
     * @return 结果
     */
    public int insertReligionArea(ReligionArea religionArea);

    /**
     * 修改宗教场所
     * 
     * @param religionArea 宗教场所
     * @return 结果
     */
    public int updateReligionArea(ReligionArea religionArea);

    /**
     * 删除宗教场所
     * 
     * @param id 宗教场所主键
     * @return 结果
     */
    public int deleteReligionAreaById(Long id);

    /**
     * 批量删除宗教场所
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionAreaByIds(Long[] ids);
}
