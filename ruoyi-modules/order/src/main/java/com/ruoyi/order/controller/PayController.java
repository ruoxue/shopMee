package com.ruoyi.order.controller;

import com.ruoyi.order.service.IBuyerPaymentService;
import com.ruoyi.pay.core.client.dto.PayNotifyDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/pay")
public class PayController {
    @Autowired
    private IBuyerPaymentService buyerPaymentService;

    @PostMapping("/notify/{channelId}/{paySeq}")
    public  String paynotify(@PathVariable("channelId") Long channelId,@PathVariable("paySeq") String paySeq, PayNotifyDataDTO payNotifyDataDTO){
        buyerPaymentService.payNotify(payNotifyDataDTO);

        return "";
    }

}
