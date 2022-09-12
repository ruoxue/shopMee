package com.ruoyi.shop.service;

import java.util.List;
import com.ruoyi.shop.domain.BuyerAddress;

/**
 * 地址Service接口
 * 
 * @author xiaoming
 * @date 2022-09-11
 */
public interface IBuyerAddressService 
{
    /**
     * 查询地址
     * 
     * @param addressId 地址主键
     * @return 地址
     */
    public BuyerAddress selectBuyerAddressByAddressId(Long addressId);

    /**
     * 查询地址列表
     * 
     * @param buyerAddress 地址
     * @return 地址集合
     */
    public List<BuyerAddress> selectBuyerAddressList(BuyerAddress buyerAddress);

    /**
     * 新增地址
     * 
     * @param buyerAddress 地址
     * @return 结果
     */
    public int insertBuyerAddress(BuyerAddress buyerAddress);

    /**
     * 修改地址
     * 
     * @param buyerAddress 地址
     * @return 结果
     */
    public int updateBuyerAddress(BuyerAddress buyerAddress);

    /**
     * 批量删除地址
     * 
     * @param addressIds 需要删除的地址主键集合
     * @return 结果
     */
    public int deleteBuyerAddressByAddressIds(Long[] addressIds);

    /**
     * 删除地址信息
     * 
     * @param addressId 地址主键
     * @return 结果
     */
    public int deleteBuyerAddressByAddressId(Long addressId);
}
