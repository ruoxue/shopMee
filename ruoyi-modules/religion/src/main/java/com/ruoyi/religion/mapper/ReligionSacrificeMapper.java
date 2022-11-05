package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionSacrifice;

/**
 * 民间烧香点Mapper接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
public interface ReligionSacrificeMapper 
{
    /**
     * 查询民间烧香点
     * 
     * @param id 民间烧香点主键
     * @return 民间烧香点
     */
    public ReligionSacrifice selectReligionSacrificeById(Long id);

    /**
     * 查询民间烧香点列表
     * 
     * @param religionSacrifice 民间烧香点
     * @return 民间烧香点集合
     */
    public List<ReligionSacrifice> selectReligionSacrificeList(ReligionSacrifice religionSacrifice);

    /**
     * 新增民间烧香点
     * 
     * @param religionSacrifice 民间烧香点
     * @return 结果
     */
    public int insertReligionSacrifice(ReligionSacrifice religionSacrifice);

    /**
     * 修改民间烧香点
     * 
     * @param religionSacrifice 民间烧香点
     * @return 结果
     */
    public int updateReligionSacrifice(ReligionSacrifice religionSacrifice);

    /**
     * 删除民间烧香点
     * 
     * @param id 民间烧香点主键
     * @return 结果
     */
    public int deleteReligionSacrificeById(Long id);

    /**
     * 批量删除民间烧香点
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionSacrificeByIds(Long[] ids);
}
