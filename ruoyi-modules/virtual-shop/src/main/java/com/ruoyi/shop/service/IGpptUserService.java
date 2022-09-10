package com.ruoyi.shop.service;

import java.util.List;
import com.ruoyi.shop.domain.GpptUser;

/**
 * 用户Service接口
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public interface IGpptUserService 
{
    /**
     * 查询用户
     * 
     * @param userId 用户主键
     * @return 用户
     */
    public GpptUser selectGpptUserByUserId(String userId);

    /**
     * 查询用户列表
     * 
     * @param gpptUser 用户
     * @return 用户集合
     */
    public List<GpptUser> selectGpptUserList(GpptUser gpptUser);

    /**
     * 新增用户
     * 
     * @param gpptUser 用户
     * @return 结果
     */
    public int insertGpptUser(GpptUser gpptUser);

    /**
     * 修改用户
     * 
     * @param gpptUser 用户
     * @return 结果
     */
    public int updateGpptUser(GpptUser gpptUser);

    /**
     * 批量删除用户
     * 
     * @param userIds 需要删除的用户主键集合
     * @return 结果
     */
    public int deleteGpptUserByUserIds(String[] userIds);

    /**
     * 删除用户信息
     * 
     * @param userId 用户主键
     * @return 结果
     */
    public int deleteGpptUserByUserId(String userId);
}
