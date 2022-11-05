package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionVideo;

/**
 * 视频接入Mapper接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:33
 */
public interface ReligionVideoMapper 
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
     * 删除视频接入
     * 
     * @param id 视频接入主键
     * @return 结果
     */
    public int deleteReligionVideoById(Long id);

    /**
     * 批量删除视频接入
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionVideoByIds(Long[] ids);
}
