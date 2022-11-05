package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionVideo;

/**
 * 视频接入Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:33
 */
public interface IReligionVideoService 
{
    /**
     * 查询视频接入
     * 
     * @param id 视频接入主键
     * @return 视频接入
     */
    public ReligionVideo selectReligionVideoById(Long id);

    /**
     * 查询视频接入列表
     * 
     * @param religionVideo 视频接入
     * @return 视频接入集合
     */
    public List<ReligionVideo> selectReligionVideoList(ReligionVideo religionVideo);

    /**
     * 新增视频接入
     * 
     * @param religionVideo 视频接入
     * @return 结果
     */
    public int insertReligionVideo(ReligionVideo religionVideo);

    /**
     * 修改视频接入
     * 
     * @param religionVideo 视频接入
     * @return 结果
     */
    public int updateReligionVideo(ReligionVideo religionVideo);

    /**
     * 批量删除视频接入
     * 
     * @param ids 需要删除的视频接入主键集合
     * @return 结果
     */
    public int deleteReligionVideoByIds(Long[] ids);

    /**
     * 删除视频接入信息
     * 
     * @param id 视频接入主键
     * @return 结果
     */
    public int deleteReligionVideoById(Long id);
}
