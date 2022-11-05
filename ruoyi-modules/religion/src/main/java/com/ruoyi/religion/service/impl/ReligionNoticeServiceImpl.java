package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionNoticeMapper;
import com.ruoyi.religion.domain.ReligionNotice;
import com.ruoyi.religion.service.IReligionNoticeService;

/**
 * 通知公告Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 23:25:25
 */
@Service
public class ReligionNoticeServiceImpl implements IReligionNoticeService 
{
    @Autowired
    private ReligionNoticeMapper religionNoticeMapper;

    /**
     * 查询通知公告
     * 
     * @param id 通知公告主键
     * @return 通知公告
     */
    @Override
    public ReligionNotice selectReligionNoticeById(Long id)
    {
        return religionNoticeMapper.selectReligionNoticeById(id);
    }

    /**
     * 查询通知公告列表
     * 
     * @param religionNotice 通知公告
     * @return 通知公告
     */
    @Override
    public List<ReligionNotice> selectReligionNoticeList(ReligionNotice religionNotice)
    {
        return religionNoticeMapper.selectReligionNoticeList(religionNotice);
    }

    /**
     * 新增通知公告
     * 
     * @param religionNotice 通知公告
     * @return 结果
     */
    @Override
    public int insertReligionNotice(ReligionNotice religionNotice)
    {
        religionNotice.setCreateTime(DateUtils.getNowDate());
        return religionNoticeMapper.insertReligionNotice(religionNotice);
    }

    /**
     * 修改通知公告
     * 
     * @param religionNotice 通知公告
     * @return 结果
     */
    @Override
    public int updateReligionNotice(ReligionNotice religionNotice)
    {
        religionNotice.setUpdateTime(DateUtils.getNowDate());
        return religionNoticeMapper.updateReligionNotice(religionNotice);
    }

    /**
     * 批量删除通知公告
     * 
     * @param ids 需要删除的通知公告主键
     * @return 结果
     */
    @Override
    public int deleteReligionNoticeByIds(Long[] ids)
    {
        return religionNoticeMapper.deleteReligionNoticeByIds(ids);
    }

    /**
     * 删除通知公告信息
     * 
     * @param id 通知公告主键
     * @return 结果
     */
    @Override
    public int deleteReligionNoticeById(Long id)
    {
        return religionNoticeMapper.deleteReligionNoticeById(id);
    }
}
