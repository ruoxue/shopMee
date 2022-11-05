package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionCommentMapper;
import com.ruoyi.religion.domain.ReligionComment;
import com.ruoyi.religion.service.IReligionCommentService;

/**
 * 举报投诉Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@Service
public class ReligionCommentServiceImpl implements IReligionCommentService 
{
    @Autowired
    private ReligionCommentMapper religionCommentMapper;

    /**
     * 查询举报投诉
     * 
     * @param id 举报投诉主键
     * @return 举报投诉
     */
    @Override
    public ReligionComment selectReligionCommentById(Long id)
    {
        return religionCommentMapper.selectReligionCommentById(id);
    }

    /**
     * 查询举报投诉列表
     * 
     * @param religionComment 举报投诉
     * @return 举报投诉
     */
    @Override
    public List<ReligionComment> selectReligionCommentList(ReligionComment religionComment)
    {
        return religionCommentMapper.selectReligionCommentList(religionComment);
    }

    /**
     * 新增举报投诉
     * 
     * @param religionComment 举报投诉
     * @return 结果
     */
    @Override
    public int insertReligionComment(ReligionComment religionComment)
    {
        religionComment.setCreateTime(DateUtils.getNowDate());
        return religionCommentMapper.insertReligionComment(religionComment);
    }

    /**
     * 修改举报投诉
     * 
     * @param religionComment 举报投诉
     * @return 结果
     */
    @Override
    public int updateReligionComment(ReligionComment religionComment)
    {
        religionComment.setUpdateTime(DateUtils.getNowDate());
        return religionCommentMapper.updateReligionComment(religionComment);
    }

    /**
     * 批量删除举报投诉
     * 
     * @param ids 需要删除的举报投诉主键
     * @return 结果
     */
    @Override
    public int deleteReligionCommentByIds(Long[] ids)
    {
        return religionCommentMapper.deleteReligionCommentByIds(ids);
    }

    /**
     * 删除举报投诉信息
     * 
     * @param id 举报投诉主键
     * @return 结果
     */
    @Override
    public int deleteReligionCommentById(Long id)
    {
        return religionCommentMapper.deleteReligionCommentById(id);
    }
}
