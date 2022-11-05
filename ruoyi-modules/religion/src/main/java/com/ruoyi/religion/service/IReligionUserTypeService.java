package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionUserType;

/**
 * 用户类型Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 02:57:31
 */
public interface IReligionUserTypeService 
{
    /**
     * 查询用户类型
     * 
     * @param id 用户类型主键
     * @return 用户类型
     */
    public ReligionUserType selectReligionUserTypeById(Long id);

    /**
     * 查询用户类型列表
     * 
     * @param religionUserType 用户类型
     * @return 用户类型集合
     */
    public List<ReligionUserType> selectReligionUserTypeList(ReligionUserType religionUserType);

    /**
     * 新增用户类型
     * 
     * @param religionUserType 用户类型
     * @return 结果
     */
    public int insertReligionUserType(ReligionUserType religionUserType);

    /**
     * 修改用户类型
     * 
     * @param religionUserType 用户类型
     * @return 结果
     */
    public int updateReligionUserType(ReligionUserType religionUserType);

    /**
     * 批量删除用户类型
     * 
     * @param ids 需要删除的用户类型主键集合
     * @return 结果
     */
    public int deleteReligionUserTypeByIds(Long[] ids);

    /**
     * 删除用户类型信息
     * 
     * @param id 用户类型主键
     * @return 结果
     */
    public int deleteReligionUserTypeById(Long id);
}
