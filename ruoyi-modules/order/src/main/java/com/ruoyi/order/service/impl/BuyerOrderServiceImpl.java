package com.ruoyi.shop.service.impl;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.redis.compent.OrderIdUtil;
import com.ruoyi.shop.domain.OrderPO;
import com.ruoyi.shop.domain.*;
import com.ruoyi.shop.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.BuyerOrderMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单Service业务层处理
 *
 * @author xiaoming
 * @date 2022-08-07
 */
@Service
public class BuyerOrderServiceImpl implements IBuyerOrderService {
    @Autowired
    private BuyerOrderMapper buyerOrderMapper;
    @Autowired
    private IPayCommitService iPayCommitService;

    @Autowired
    private IProductSkuService productSkuService;
    @Autowired
    private IProductService productService;
    @Autowired
    private OrderIdUtil orderIdUtil;

    @Autowired
    private IBuyerItemService buyerItemService;

    /**
     * 查询订单
     *
     * @param orderId 订单主键
     * @return 订单
     */
    @Override
    public OrderPO selectBuyerOrderByOrderId(String orderId) {
        return buyerOrderMapper.selectBuyerOrderByOrderId(orderId);
    }


    @Override
    public List<OrderPO> selectOrderList(BuyerOrder buyerOrder) {
        return buyerOrderMapper.selectOrderList(buyerOrder);
    }

    @Override
    public List<OrderPO> selectSaleOrderList(BuyerOrder buyerOrder) {
        System.out.println("buyerOrder.getOrderStatus() = " + buyerOrder.getOrderStatus());
        return buyerOrderMapper.selectSaleOrderList(buyerOrder);
    }

    /**
     * 查询订单列表
     *
     * @param buyerOrder 订单
     * @return 订单
     */
    @Override
    public List<OrderPO> selectBuyerOrderList(BuyerOrder buyerOrder) {
        List<BuyerOrder> buyerOrders = buyerOrderMapper.selectBuyerOrderList(buyerOrder);
        List<OrderPO> orderList = new ArrayList<>();

        buyerOrders.forEach(v -> {
            BuyerItem buyerItem = new BuyerItem();
            buyerItem.setOrderId(v.getOrderId());
            List<BuyerItem> buyerItems = buyerItemService.selectBuyerItemList(buyerItem);
            OrderPO orderPO = new OrderPO();
            BeanUtils.copyProperties(v, orderPO);
            orderPO.setBuyerItems(buyerItems);
            orderList.add(orderPO);
        });


        return orderList;

    }

    /**
     * 新增订单
     *
     * @param buyerOrder 订单
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String insertBuyerOrder(OrderPO buyerOrder) {

        buyerOrder.setOrderId(orderIdUtil.genOrderId());
        buyerOrder.setCreatedBy(buyerOrder.getUserId());

        buyerOrder.setCreatedTime(new Date());
        List<BuyerItem> buyerItems = buyerOrder.getBuyerItems();
        int type = -10;
        int auto = -1;
        Long formateId=null;
        String subject="";


        for (BuyerItem v : buyerItems) {
            ProductSku productSku = productSkuService.selectProductSkuById(v.getSkuId());
            Product info = productService.selectProductById((productSku.getGoodsId()));
            auto = info.getAuto();
            if (info.getEndTime().getTime() < new Date().getTime()) {
                return "商品已下架";
            }

            if (productSku.getStock()<=0){
                return "商品库存没有了";
            }
            productService.updateSaleCount(info.getId());
            productSkuService.updateSaleCount(productSku.getId());

            subject=productSku.getTitle()+"等";
            formateId=info.getFormateId();

            if (type > 0) {
                if (type != info.getType()) {
                    return "虚拟商品不能同时购买";
                }
            }
            type = info.getType();

        }


        int i = buyerOrderMapper.insertBuyerOrder(buyerOrder);

        BigDecimal total = new BigDecimal(0);

        for (BuyerItem v : buyerItems) {
            ProductSku productSku = productSkuService.selectProductSkuById(v.getSkuId());
            total = total.add(productSku.getPrice());
            Product info = productService.selectProductById((productSku.getGoodsId()));
            BuyerItem buyerItem = new BuyerItem();
            buyerItem.setOrderId(buyerOrder.getOrderId());
            buyerItem.setItemId(orderIdUtil.generateId("item", new Date()));
            buyerItem.setCartId(buyerOrder.getCartId());
            buyerItem.setSkuId(productSku.getId());
            buyerItem.setCartId(buyerOrder.getCartId());
            buyerItem.setCreatedBy(buyerOrder.getCreatedBy());
            buyerItem.setCostPrice(productSku.getCostPrice());
            buyerItem.setPrice(productSku.getPrice());
            buyerItem.setOriginalPrice(productSku.getOriginalPrice());
            buyerItem.setCreatedTime(new Date());
            buyerItem.setSkuIntro(productSku.getRemark());
            buyerItem.setUpdatedTime(new Date());
            buyerItem.setSkuTitle(productSku.getTitle());
            type = info.getType();
            buyerOrder.setType(info.getType());
            buyerItemService.insertBuyerItem(buyerItem);
        }
        buyerOrder.setType(type);
        buyerOrder.setTotalPrice(total);
        buyerOrder.setPayablePrice(total);
        buyerOrder.setAuto(auto);
        buyerOrder.setFormateId(formateId);
        buyerOrder.setSubject(subject);
        buyerOrderMapper.updateBuyerOrder(buyerOrder);
        return buyerOrder.getOrderId();
    }

    /**
     * 修改订单
     *
     * @param buyerOrder 订单
     * @return 结果
     */
    @Override
    public int updateBuyerOrder(BuyerOrder buyerOrder) {
        return buyerOrderMapper.updateBuyerOrder(buyerOrder);
    }

    /**
     * 批量删除订单
     *
     * @param orderIds 需要删除的订单主键
     * @return 结果
     */
    @Override
    public int deleteBuyerOrderByOrderIds(String[] orderIds) {
        return buyerOrderMapper.deleteBuyerOrderByOrderIds(orderIds);
    }

    /**
     * 删除订单信息
     *
     * @param orderId 订单主键
     * @return 结果
     */
    @Override
    public int deleteBuyerOrderByOrderId(String orderId) {
        return buyerOrderMapper.deleteBuyerOrderByOrderId(orderId);
    }

    @Override
    public String commit() {

        BuyerOrder queryOrder = new BuyerOrder();
        queryOrder.setType(4);
        queryOrder.setOrderStatus(10);
        queryOrder.setAuto(1);
        List<BuyerOrder> buyerOrders = buyerOrderMapper.selectBuyerOrderList(queryOrder);
        for (BuyerOrder buyerOrder : buyerOrders) {


            if (buyerOrder.getCommitId() == null) {
                PayCommit queryCommit = new PayCommit();
                queryCommit.setStatus(1L);
                List<PayCommit> payCommits = iPayCommitService.selectPayCommitList(queryCommit);
                if (payCommits.isEmpty()) {
                    continue;
                }
                buyerOrder.setCommitId(payCommits.stream().findFirst().get().getId());
            }

            PayCommit payCommit = iPayCommitService.selectPayCommitById(buyerOrder.getCommitId());
            String api = payCommit.getLocal();

            try {
                Class clazz = Class.forName(api);
                Object o = clazz.getDeclaredConstructor().newInstance();
                Method method = clazz.getMethod("submit", clazz);
                method.invoke(o, buyerOrder, payCommit.getUrl(), payCommit.getParam());
            } catch (Exception e) {
                e.printStackTrace();
            }


        }


        return null;
    }

    @Override
    public List<OrderBasicVO>  basicInfo(String uid) {
        List<OrderBasicVO> orderBasicVOS = buyerOrderMapper.basicSaleInfo(Long.parseLong(uid));

        List<OrderBasicVO> orderBasicVOS2 = buyerOrderMapper.basicBuyInfo(Long.parseLong(uid));
        List<OrderBasicVO> orderBasicVOS3 = buyerOrderMapper.basicCurrentInfo(Long.parseLong(uid));

        List<OrderBasicVO> orderBasicVOS4 = buyerOrderMapper.basicCurrentAmountInfo(Long.parseLong(uid));

        orderBasicVOS.addAll(orderBasicVOS2);
        orderBasicVOS.addAll(orderBasicVOS3);
        orderBasicVOS.addAll(orderBasicVOS4);



        return orderBasicVOS;
    }
}
