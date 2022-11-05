package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionUserType;
import com.ruoyi.religion.domain.ReligionUser;

/**
 * 用户类型Mapper接口
 * 
 * @author xiaoming
 * @date 2022-10-22 02:57:31
 */
public interface ReligionUserTypeMapper 
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
     * 删除用户类型
     * 
     * @param id 用户类型主键
     * @return 结果
     */
    public int deleteReligionUserTypeById(Long id);

    /**
     * 批量删除用户类型
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionUserTypeByIds(Long[] ids);

    /**
     * 批量删除宗教人员
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionUserByTypes(Long[] ids);
    
    /**
     * 批量新增宗教人员
     * 
     * @param religionUserList 宗教人员列表
     * @return 结果
     */
    public int batchReligionUser(List<ReligionUser> religionUserList);
    

    /**
     * 通过用户类型主键删除宗教人员信息
     * 
     * @param id 用户类型ID
     * @return 结果
     */
    public int deleteReligionUserByType(Long id);
}
