package com.ruoyi.shop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.BuyerAddressMapper;
import com.ruoyi.shop.domain.BuyerAddress;
import com.ruoyi.shop.service.IBuyerAddressService;

/**
 * 地址Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@Service
public class BuyerAddressServiceImpl implements IBuyerAddressService 
{
    @Autowired
    private BuyerAddressMapper buyerAddressMapper;

    /**
     * 查询地址
     * 
     * @param addressId 地址主键
     * @return 地址
     */
    @Override
    public BuyerAddress selectBuyerAddressByAddressId(String addressId)
    {
        return buyerAddressMapper.selectBuyerAddressByAddressId(addressId);
    }

    /**
     * 查询地址列表
     * 
     * @param buyerAddress 地址
     * @return 地址
     */
    @Override
    public List<BuyerAddress> selectBuyerAddressList(BuyerAddress buyerAddress)
    {
        return buyerAddressMapper.selectBuyerAddressList(buyerAddress);
    }

    /**
     * 新增地址
     * 
     * @param buyerAddress 地址
     * @return 结果
     */
    @Override
    public int insertBuyerAddress(BuyerAddress buyerAddress)
    {
        return buyerAddressMapper.insertBuyerAddress(buyerAddress);
    }

    /**
     * 修改地址
     * 
     * @param buyerAddress 地址
     * @return 结果
     */
    @Override
    public int updateBuyerAddress(BuyerAddress buyerAddress)
    {
        return buyerAddressMapper.updateBuyerAddress(buyerAddress);
    }

    /**
     * 批量删除地址
     * 
     * @param addressIds 需要删除的地址主键
     * @return 结果
     */
    @Override
    public int deleteBuyerAddressByAddressIds(String[] addressIds)
    {
        return buyerAddressMapper.deleteBuyerAddressByAddressIds(addressIds);
    }

    /**
     * 删除地址信息
     * 
     * @param addressId 地址主键
     * @return 结果
     */
    @Override
    public int deleteBuyerAddressByAddressId(String addressId)
    {
        return buyerAddressMapper.deleteBuyerAddressByAddressId(addressId);
    }
}
