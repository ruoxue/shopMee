package com.ruoyi.order.controller;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.ruoyi.order.domain.BuyerPayment;
import com.ruoyi.order.domain.PayChannel;
import com.ruoyi.order.service.IBuyerPaymentService;
import com.ruoyi.order.service.IPayChannelService;
import com.ruoyi.pay.core.client.dto.PayNotifyDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RequestMapping("/pay")
@Controller
public class PayController {
    @Autowired
    private IPayChannelService payChannelService;
    @Autowired
    private IBuyerPaymentService buyerPaymentService;

    @GetMapping("/notify/{channelId}/{paySeq}")
    public void payReturn(@PathVariable("channelId") Long channelId,
                          @PathVariable("paySeq") String paySeq,
                          PayNotifyDataDTO payNotifyDataDTO,
                          HttpServletRequest request,
                          HttpServletResponse resp) {

        PayChannel payChannel = payChannelService.selectPayChannelById(channelId);

        BuyerPayment buyerPayment = buyerPaymentService.selectBuyerPaymentById(Long.parseLong(paySeq));
//hfyvov4097@sandbox.com

        String redirectUri = payChannel.getShowUrl()
                + "?channelId=" + channelId
                + "&paySeq=" + paySeq + "&result=" +
                (buyerPayment.getStatus() == 10 ? "支付成功" : "支付失败")
                + "&status=" + buyerPayment.getStatus();

        try {
            resp.sendRedirect(redirectUri);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


//    http://wrxd4x.natappfree.cc/order/pay/notify/2/24?charset=UTF-8&out_trade_no=24&method=alipay.trade.wap.pay.return&total_amount=10.00&sign=jHNhsWvKb%2BpIpe%2FTwlmd7BGdPGzVLCFHjXVw08rx%2Bgc5dB4TIfv5cezQzYYKRtiBTITIRJeLFlaQtoAYNk4mLocJ9JwSwNXScUXbXYlmPiYXEB5vjdY9mSLhXpr7hr1Nwl1INBYdUnwMmnoBt0H3iB9d%2BVWzUY86q95kd0zS77CtbPM2IFWdMrnWrAJsNwifBeUo%2Fz5HIRM8Kc2DQCrcdiJt1fEcKMQsMupnAEi5omCB7juajXlrbpX9OF73TdPG%2FzVo5GGsxjLUrm%2FCD%2FcZvcc3eUkf3sRhU9IFxIx7WpFoQHGE%2FYmbaf5EcBhYaNe%2BfLEk%2B4DO5Twhgi0ilpKnhA%3D%3D&trade_no=2022091422001451200503154636&auth_app_id=2016102100730676&version=1.0&app_id=2016102100730676&sign_type=RSA2&seller_id=2088102180490533&timestamp=2022-09-14+23%3A54%3A44


    @PostMapping("/notify/{channelId}/{paySeq}")
    public void payNotify(@PathVariable("channelId") Long channelId,
                          @PathVariable("paySeq") String paySeq,
                          HttpServletRequest req,
                          HttpServletResponse resp) {
        String redirectUri = "http://www.baidu.com";

//        {"gmt_create":["2022-09-15 23:24:57"],"charset":["UTF-8"],"subject":["测试等"],"sign":["PtkR0FORxxR/si88Fr2COReJKG7SSXADgdlGVIW9mQXVckLS1rEdfjbHbJSqtKPypr1NDF3tRl9zbJHrrZPI5I8/vUpZp+GW1yLpUAQnZzTvGV7ZdZbdxS0tVuT1fOfj3Xllu/y4ggUWxXd2FEaU4oEkrNPTWiMDQhUaOYqbTSo7Tiq3hmPgT0dqVef38EyAgCipzbaXHC/Wahrm1ZqJzVjNkLv7jTLFsGFvDCsOTDX1axdjxyad9YtPdqT+Ef/ATcgX6kezjACoQHn+K1Em1W7LPOG6ZCoxX4IbjyPILFC48j32jFPZ2p3EogTdfvjoBIYehdrFI6kkeUk5siYmiA=="],"buyer_id":["2088102180251202"],"body":["null"],"invoice_amount":["10.00"],"notify_id":["2022091500222232517051200543407154"],"fund_bill_list":["[{\"amount\":\"10.00\",\"fundChannel\":\"ALIPAYACCOUNT\"}]"],"notify_type":["trade_status_sync"],"trade_status":["TRADE_SUCCESS"],"receipt_amount":["10.00"],"app_id":["2016102100730676"],"buyer_pay_amount":["10.00"],"sign_type":["RSA2"],"seller_id":["2088102180490533"],"gmt_payment":["2022-09-15 23:25:16"],"notify_time":["2022-09-15 23:25:18"],"passback_params":["34"],"version":["1.0"],"out_trade_no":["34"],"total_amount":["10.00"],"trade_no":["2022091522001451200503155105"],"auth_app_id":["2016102100730676"],"point_amount":["0.00"]}
        System.out.println("\"-----\" = " + "-----");

        PayChannel payChannel = payChannelService.selectPayChannelById(channelId);

        Enumeration<String> parameterNames = req.getParameterNames();
        Map<String, String> parameterMap = new HashMap<>();

        while (parameterNames.hasMoreElements()) {
            String s = parameterNames.nextElement();
            parameterMap.put(s, req.getParameter(s));

        }


        PayNotifyDataDTO payNotifyDataDTO = new PayNotifyDataDTO();
        payNotifyDataDTO.setParams(parameterMap);

        int i = buyerPaymentService.payNotify(payNotifyDataDTO, payChannel);
        if (i == 0) {
            System.out.println("\"ok\" = " + "ok");
        }

        try {
            resp.sendRedirect(redirectUri);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Value("${wechat.token}")
    private String token;

    @GetMapping("/wechat/token")
    @ResponseBody
    public String wechatToken(@RequestParam("signature") String signature,
                              @RequestParam("timestamp") String timestamp,
                              @RequestParam("nonce") String nonce,
                              @RequestParam("echostr") String echostr,

                              HttpServletRequest req,
                              HttpServletResponse resp) {

        List<String> mList = new ArrayList<>();
        mList.add(token);
        mList.add(timestamp);
        mList.add(nonce);

        List<String> sort = ListUtil.sortByPinyin(mList);
        String ret = sort.stream().collect(Collectors.joining());

        String s = SecureUtil.sha1(ret);
        if (s.equals(signature)) {
            return echostr;
        }
        return null;


    }


}
