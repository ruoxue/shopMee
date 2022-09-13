package com.ruoyi.pay.core.client.impl.alipay;

import cn.hutool.json.JSONObject;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.ruoyi.pay.core.client.PayCommonResult;
import com.ruoyi.pay.core.client.dto.PayOrderUnifiedReqDTO;
import com.ruoyi.pay.core.enums.PayChannelEnum;
import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeWapPayResponse;

import java.text.SimpleDateFormat;
import java.util.Objects;

/**
 * 支付宝【手机网站】的 PayClient 实现类
 * 文档：https://opendocs.alipay.com/apis/api_1/alipay.trade.wap.pay
 *
 * @author 芋道源码
 */
public class AlipayWapPayClient extends AbstractAlipayClient {


    public AlipayWapPayClient(Long channelId, AlipayPayClientConfig config) {
        super(channelId, PayChannelEnum.ALIPAY_WAP.getCode(), config, new AlipayPayCodeMapping());
    }

    @Override
    public PayCommonResult<AlipayTradeWapPayResponse> doUnifiedOrder(PayOrderUnifiedReqDTO reqDTO) {


        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();//创建API对应的request
        alipayRequest.setReturnUrl(reqDTO.getReturnUrl());
        alipayRequest.setNotifyUrl(reqDTO.getNotifyUrl());//在公共参数中设置回跳和通知地址
        alipayRequest.setBizContent("{" +
                " \"out_trade_no\":\"" + reqDTO.getMerchantOrderId() + "\"," +
                " \"total_amount\":\"" + calculateAmount(reqDTO.getAmount()).toString() + "\"," +
                " \"subject\":\"" + reqDTO.getSubject() + "\"," +
                " \"product_code\":\"QUICK_WAP_WAY\"" +
                " }");//填充业务参数


        AlipayTradeWapPayResponse response = null;
        try {
            response = client.pageExecute(alipayRequest);

        } catch (AlipayApiException e) {
            return PayCommonResult.build(e.getErrCode(), e.getErrMsg(), null, codeMapping);
        }

        // TODO 芋艿：sub Code
        if (response.isSuccess() && Objects.isNull(response.getCode()) && Objects.nonNull(response.getBody())) {
            //成功alipay wap 成功 code 为 null , body 为form 表单
            return PayCommonResult.build("-9999", "Success", response, codeMapping);
        } else {
            return PayCommonResult.build(response.getCode(), response.getMsg(), response, codeMapping);
        }
    }


    public PayCommonResult<AlipayTradeQueryResponse> doQueryOrder(PayOrderUnifiedReqDTO reqDTO) {


        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", reqDTO.getMerchantOrderId());
//bizContent.put("trade_no", "2014112611001004680073956707");
        request.setBizContent(bizContent.toString());
        AlipayTradeQueryResponse response = null;
        try {
            response = client.execute(request);
            if (response.isSuccess()) {
                System.out.println("调用成功");
                return PayCommonResult.build("-9999", "Success", response, codeMapping);

            } else {
                System.out.println("调用失败");
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return PayCommonResult.build(e.getErrCode(), e.getErrMsg(), response, codeMapping);

        }

        return PayCommonResult.build(response.getCode(), response.getMsg(), response, codeMapping);

    }
}
