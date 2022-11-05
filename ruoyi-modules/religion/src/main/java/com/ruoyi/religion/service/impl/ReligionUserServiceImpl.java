package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionUserMapper;
import com.ruoyi.religion.domain.ReligionUser;
import com.ruoyi.religion.service.IReligionUserService;

/**
 * 宗教人员Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 02:57:31
 */
@Service
public class ReligionUserServiceImpl implements IReligionUserService 
{
    @Autowired
    private ReligionUserMapper religionUserMapper;

    /**
     * 查询宗教人员
     * 
     * @param id 宗教人员主键
     * @return 宗教人员
     */
    @Override
    public ReligionUser selectReligionUserById(Long id)
    {
        return religionUserMapper.selectReligionUserById(id);
    }

    /**
     * 查询宗教人员列表
     * 
     * @param religionUser 宗教人员
     * @return 宗教人员
     */
    @Override
    public List<ReligionUser> selectReligionUserList(ReligionUser religionUser)
    {
        return religionUserMapper.selectReligionUserList(religionUser);
    }

    /**
     * 新增宗教人员
     * 
     * @param religionUser 宗教人员
     * @return 结果
     */
    @Override
    public int insertReligionUser(ReligionUser religionUser)
    {
        religionUser.setCreateTime(DateUtils.getNowDate());
        return religionUserMapper.insertReligionUser(religionUser);
    }

    /**
     * 修改宗教人员
     * 
     * @param religionUser 宗教人员
     * @return 结果
     */
    @Override
    public int updateReligionUser(ReligionUser religionUser)
    {
        religionUser.setUpdateTime(DateUtils.getNowDate());
        return religionUserMapper.updateReligionUser(religionUser);
    }

    /**
     * 批量删除宗教人员
     * 
     * @param ids 需要删除的宗教人员主键
     * @return 结果
     */
    @Override
    public int deleteReligionUserByIds(Long[] ids)
    {
        return religionUserMapper.deleteReligionUserByIds(ids);
    }

    /**
     * 删除宗教人员信息
     * 
     * @param id 宗教人员主键
     * @return 结果
     */
    @Override
    public int deleteReligionUserById(Long id)
    {
        return religionUserMapper.deleteReligionUserById(id);
    }
}
