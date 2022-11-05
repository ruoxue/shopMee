package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionNotice;

/**
 * 通知公告Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 23:25:25
 */
public interface IReligionNoticeService 
{
    /**
     * 查询通知公告
     * 
     * @param id 通知公告主键
     * @return 通知公告
     */
    public ReligionNotice selectReligionNoticeById(Long id);

    /**
     * 查询通知公告列表
     * 
     * @param religionNotice 通知公告
     * @return 通知公告集合
     */
    public List<ReligionNotice> selectReligionNoticeList(ReligionNotice religionNotice);

    /**
     * 新增通知公告
     * 
     * @param religionNotice 通知公告
     * @return 结果
     */
    public int insertReligionNotice(ReligionNotice religionNotice);

    /**
     * 修改通知公告
     * 
     * @param religionNotice 通知公告
     * @return 结果
     */
    public int updateReligionNotice(ReligionNotice religionNotice);

    /**
     * 批量删除通知公告
     * 
     * @param ids 需要删除的通知公告主键集合
     * @return 结果
     */
    public int deleteReligionNoticeByIds(Long[] ids);

    /**
     * 删除通知公告信息
     * 
     * @param id 通知公告主键
     * @return 结果
     */
    public int deleteReligionNoticeById(Long id);
}
