package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.GdptSmsTpl;

/**
 * 短信模板Mapper接口
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public interface GdptSmsTplMapper 
{
    /**
     * 查询短信模板
     * 
     * @param id 短信模板主键
     * @return 短信模板
     */
    public GdptSmsTpl selectGdptSmsTplById(String id);

    /**
     * 查询短信模板列表
     * 
     * @param gdptSmsTpl 短信模板
     * @return 短信模板集合
     */
    public List<GdptSmsTpl> selectGdptSmsTplList(GdptSmsTpl gdptSmsTpl);

    /**
     * 新增短信模板
     * 
     * @param gdptSmsTpl 短信模板
     * @return 结果
     */
    public int insertGdptSmsTpl(GdptSmsTpl gdptSmsTpl);

    /**
     * 修改短信模板
     * 
     * @param gdptSmsTpl 短信模板
     * @return 结果
     */
    public int updateGdptSmsTpl(GdptSmsTpl gdptSmsTpl);

    /**
     * 删除短信模板
     * 
     * @param id 短信模板主键
     * @return 结果
     */
    public int deleteGdptSmsTplById(String id);

    /**
     * 批量删除短信模板
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGdptSmsTplByIds(String[] ids);
}
