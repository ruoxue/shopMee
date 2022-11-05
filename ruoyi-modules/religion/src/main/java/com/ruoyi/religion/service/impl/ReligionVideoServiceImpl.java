package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionVideoMapper;
import com.ruoyi.religion.domain.ReligionVideo;
import com.ruoyi.religion.service.IReligionVideoService;

/**
 * 视频接入Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:33
 */
@Service
public class ReligionVideoServiceImpl implements IReligionVideoService 
{
    @Autowired
    private ReligionVideoMapper religionVideoMapper;

    /**
     * 查询视频接入
     * 
     * @param id 视频接入主键
     * @return 视频接入
     */
    @Override
    public ReligionVideo selectReligionVideoById(Long id)
    {
        return religionVideoMapper.selectReligionVideoById(id);
    }

    /**
     * 查询视频接入列表
     * 
     * @param religionVideo 视频接入
     * @return 视频接入
     */
    @Override
    public List<ReligionVideo> selectReligionVideoList(ReligionVideo religionVideo)
    {
        return religionVideoMapper.selectReligionVideoList(religionVideo);
    }

    /**
     * 新增视频接入
     * 
     * @param religionVideo 视频接入
     * @return 结果
     */
    @Override
    public int insertReligionVideo(ReligionVideo religionVideo)
    {
        religionVideo.setCreateTime(DateUtils.getNowDate());
        return religionVideoMapper.insertReligionVideo(religionVideo);
    }

    /**
     * 修改视频接入
     * 
     * @param religionVideo 视频接入
     * @return 结果
     */
    @Override
    public int updateReligionVideo(ReligionVideo religionVideo)
    {
        religionVideo.setUpdateTime(DateUtils.getNowDate());
        return religionVideoMapper.updateReligionVideo(religionVideo);
    }

    /**
     * 批量删除视频接入
     * 
     * @param ids 需要删除的视频接入主键
     * @return 结果
     */
    @Override
    public int deleteReligionVideoByIds(Long[] ids)
    {
        return religionVideoMapper.deleteReligionVideoByIds(ids);
    }

    /**
     * 删除视频接入信息
     * 
     * @param id 视频接入主键
     * @return 结果
     */
    @Override
    public int deleteReligionVideoById(Long id)
    {
        return religionVideoMapper.deleteReligionVideoById(id);
    }
}
