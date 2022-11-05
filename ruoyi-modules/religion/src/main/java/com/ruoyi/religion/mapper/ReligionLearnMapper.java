package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionLearn;

/**
 * 文化学习Mapper接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
public interface ReligionLearnMapper 
{
    /**
     * 查询文化学习
     * 
     * @param id 文化学习主键
     * @return 文化学习
     */
    public ReligionLearn selectReligionLearnById(Long id);

    /**
     * 查询文化学习列表
     * 
     * @param religionLearn 文化学习
     * @return 文化学习集合
     */
    public List<ReligionLearn> selectReligionLearnList(ReligionLearn religionLearn);

    /**
     * 新增文化学习
     * 
     * @param religionLearn 文化学习
     * @return 结果
     */
    public int insertReligionLearn(ReligionLearn religionLearn);

    /**
     * 修改文化学习
     * 
     * @param religionLearn 文化学习
     * @return 结果
     */
    public int updateReligionLearn(ReligionLearn religionLearn);

    /**
     * 删除文化学习
     * 
     * @param id 文化学习主键
     * @return 结果
     */
    public int deleteReligionLearnById(Long id);

    /**
     * 批量删除文化学习
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionLearnByIds(Long[] ids);
}
