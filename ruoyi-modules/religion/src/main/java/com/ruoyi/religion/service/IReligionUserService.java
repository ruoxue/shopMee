package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionUser;

/**
 * 宗教人员Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 02:57:31
 */
public interface IReligionUserService 
{
    /**
     * 查询宗教人员
     * 
     * @param id 宗教人员主键
     * @return 宗教人员
     */
    public ReligionUser selectReligionUserById(Long id);

    /**
     * 查询宗教人员列表
     * 
     * @param religionUser 宗教人员
     * @return 宗教人员集合
     */
    public List<ReligionUser> selectReligionUserList(ReligionUser religionUser);

    /**
     * 新增宗教人员
     * 
     * @param religionUser 宗教人员
     * @return 结果
     */
    public int insertReligionUser(ReligionUser religionUser);

    /**
     * 修改宗教人员
     * 
     * @param religionUser 宗教人员
     * @return 结果
     */
    public int updateReligionUser(ReligionUser religionUser);

    /**
     * 批量删除宗教人员
     * 
     * @param ids 需要删除的宗教人员主键集合
     * @return 结果
     */
    public int deleteReligionUserByIds(Long[] ids);

    /**
     * 删除宗教人员信息
     * 
     * @param id 宗教人员主键
     * @return 结果
     */
    public int deleteReligionUserById(Long id);
}
