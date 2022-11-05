package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionSacrifice;

/**
 * 民间烧香点Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
public interface IReligionSacrificeService 
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
     * 批量删除民间烧香点
     * 
     * @param ids 需要删除的民间烧香点主键集合
     * @return 结果
     */
    public int deleteReligionSacrificeByIds(Long[] ids);

    /**
     * 删除民间烧香点信息
     * 
     * @param id 民间烧香点主键
     * @return 结果
     */
    public int deleteReligionSacrificeById(Long id);
}
