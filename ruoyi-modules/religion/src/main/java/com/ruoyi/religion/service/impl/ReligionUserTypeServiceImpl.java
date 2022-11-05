package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.core.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.religion.domain.ReligionUser;
import com.ruoyi.religion.mapper.ReligionUserTypeMapper;
import com.ruoyi.religion.domain.ReligionUserType;
import com.ruoyi.religion.service.IReligionUserTypeService;

/**
 * 用户类型Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 02:57:31
 */
@Service
public class ReligionUserTypeServiceImpl implements IReligionUserTypeService 
{
    @Autowired
    private ReligionUserTypeMapper religionUserTypeMapper;

    /**
     * 查询用户类型
     * 
     * @param id 用户类型主键
     * @return 用户类型
     */
    @Override
    public ReligionUserType selectReligionUserTypeById(Long id)
    {
        return religionUserTypeMapper.selectReligionUserTypeById(id);
    }

    /**
     * 查询用户类型列表
     * 
     * @param religionUserType 用户类型
     * @return 用户类型
     */
    @Override
    public List<ReligionUserType> selectReligionUserTypeList(ReligionUserType religionUserType)
    {
        return religionUserTypeMapper.selectReligionUserTypeList(religionUserType);
    }

    /**
     * 新增用户类型
     * 
     * @param religionUserType 用户类型
     * @return 结果
     */
    @Transactional
    @Override
    public int insertReligionUserType(ReligionUserType religionUserType)
    {
        religionUserType.setCreateTime(DateUtils.getNowDate());
        int rows = religionUserTypeMapper.insertReligionUserType(religionUserType);
        insertReligionUser(religionUserType);
        return rows;
    }

    /**
     * 修改用户类型
     * 
     * @param religionUserType 用户类型
     * @return 结果
     */
    @Transactional
    @Override
    public int updateReligionUserType(ReligionUserType religionUserType)
    {
        religionUserType.setUpdateTime(DateUtils.getNowDate());
        religionUserTypeMapper.deleteReligionUserByType(religionUserType.getId());
        insertReligionUser(religionUserType);
        return religionUserTypeMapper.updateReligionUserType(religionUserType);
    }

    /**
     * 批量删除用户类型
     * 
     * @param ids 需要删除的用户类型主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteReligionUserTypeByIds(Long[] ids)
    {
        religionUserTypeMapper.deleteReligionUserByTypes(ids);
        return religionUserTypeMapper.deleteReligionUserTypeByIds(ids);
    }

    /**
     * 删除用户类型信息
     * 
     * @param id 用户类型主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteReligionUserTypeById(Long id)
    {
        religionUserTypeMapper.deleteReligionUserByType(id);
        return religionUserTypeMapper.deleteReligionUserTypeById(id);
    }

    /**
     * 新增宗教人员信息
     * 
     * @param religionUserType 用户类型对象
     */
    public void insertReligionUser(ReligionUserType religionUserType)
    {
        List<ReligionUser> religionUserList = religionUserType.getReligionUserList();
        Long id = religionUserType.getId();
        if (StringUtils.isNotNull(religionUserList))
        {
            List<ReligionUser> list = new ArrayList<ReligionUser>();
            for (ReligionUser religionUser : religionUserList)
            {
                religionUser.setType(id);
                list.add(religionUser);
            }
            if (list.size() > 0)
            {
                religionUserTypeMapper.batchReligionUser(list);
            }
        }
    }
}
