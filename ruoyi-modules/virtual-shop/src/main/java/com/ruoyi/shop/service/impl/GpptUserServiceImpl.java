package com.ruoyi.shop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.GpptUserMapper;
import com.ruoyi.shop.domain.GpptUser;
import com.ruoyi.shop.service.IGpptUserService;

/**
 * 用户Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@Service
public class GpptUserServiceImpl implements IGpptUserService 
{
    @Autowired
    private GpptUserMapper gpptUserMapper;

    /**
     * 查询用户
     * 
     * @param userId 用户主键
     * @return 用户
     */
    @Override
    public GpptUser selectGpptUserByUserId(String userId)
    {
        return gpptUserMapper.selectGpptUserByUserId(userId);
    }

    /**
     * 查询用户列表
     * 
     * @param gpptUser 用户
     * @return 用户
     */
    @Override
    public List<GpptUser> selectGpptUserList(GpptUser gpptUser)
    {
        return gpptUserMapper.selectGpptUserList(gpptUser);
    }

    /**
     * 新增用户
     * 
     * @param gpptUser 用户
     * @return 结果
     */
    @Override
    public int insertGpptUser(GpptUser gpptUser)
    {
        return gpptUserMapper.insertGpptUser(gpptUser);
    }

    /**
     * 修改用户
     * 
     * @param gpptUser 用户
     * @return 结果
     */
    @Override
    public int updateGpptUser(GpptUser gpptUser)
    {
        return gpptUserMapper.updateGpptUser(gpptUser);
    }

    /**
     * 批量删除用户
     * 
     * @param userIds 需要删除的用户主键
     * @return 结果
     */
    @Override
    public int deleteGpptUserByUserIds(String[] userIds)
    {
        return gpptUserMapper.deleteGpptUserByUserIds(userIds);
    }

    /**
     * 删除用户信息
     * 
     * @param userId 用户主键
     * @return 结果
     */
    @Override
    public int deleteGpptUserByUserId(String userId)
    {
        return gpptUserMapper.deleteGpptUserByUserId(userId);
    }
}
