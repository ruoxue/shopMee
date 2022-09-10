package com.ruoyi.mobile.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mobile.mapper.MerUserMapper;
import com.ruoyi.mobile.domain.MerUser;
import com.ruoyi.mobile.service.IMerUserService;

/**
 * 商户Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-08
 */
@Service
public class MerUserServiceImpl implements IMerUserService 
{
    @Autowired
    private MerUserMapper merUserMapper;

    /**
     * 查询商户
     * 
     * @param merId 商户主键
     * @return 商户
     */
    @Override
    public MerUser selectMerUserByMerId(Long merId)
    {
        return merUserMapper.selectMerUserByMerId(merId);
    }

    /**
     * 查询商户列表
     * 
     * @param merUser 商户
     * @return 商户
     */
    @Override
    public List<MerUser> selectMerUserList(MerUser merUser)
    {
        return merUserMapper.selectMerUserList(merUser);
    }

    /**
     * 新增商户
     * 
     * @param merUser 商户
     * @return 结果
     */
    @Override
    public int insertMerUser(MerUser merUser)
    {
        return merUserMapper.insertMerUser(merUser);
    }

    /**
     * 修改商户
     * 
     * @param merUser 商户
     * @return 结果
     */
    @Override
    public int updateMerUser(MerUser merUser)
    {
        return merUserMapper.updateMerUser(merUser);
    }

    /**
     * 批量删除商户
     * 
     * @param merIds 需要删除的商户主键
     * @return 结果
     */
    @Override
    public int deleteMerUserByMerIds(Long[] merIds)
    {
        return merUserMapper.deleteMerUserByMerIds(merIds);
    }

    /**
     * 删除商户信息
     * 
     * @param merId 商户主键
     * @return 结果
     */
    @Override
    public int deleteMerUserByMerId(Long merId)
    {
        return merUserMapper.deleteMerUserByMerId(merId);
    }
}
