package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionComment;

/**
 * 举报投诉Mapper接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
public interface ReligionCommentMapper 
{
    /**
     * 查询举报投诉
     * 
     * @param id 举报投诉主键
     * @return 举报投诉
     */
    public ReligionComment selectReligionCommentById(Long id);

    /**
     * 查询举报投诉列表
     * 
     * @param religionComment 举报投诉
     * @return 举报投诉集合
     */
    public List<ReligionComment> selectReligionCommentList(ReligionComment religionComment);

    /**
     * 新增举报投诉
     * 
     * @param religionComment 举报投诉
     * @return 结果
     */
    public int insertReligionComment(ReligionComment religionComment);

    /**
     * 修改举报投诉
     * 
     * @param religionComment 举报投诉
     * @return 结果
     */
    public int updateReligionComment(ReligionComment religionComment);

    /**
     * 删除举报投诉
     * 
     * @param id 举报投诉主键
     * @return 结果
     */
    public int deleteReligionCommentById(Long id);

    /**
     * 批量删除举报投诉
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionCommentByIds(Long[] ids);
}
