//package com.ruoyi.pay.core.client.impl.wx;
//
//import cn.hutool.core.bean.BeanUtil;
//import cn.hutool.core.date.DateUtil;
//import cn.hutool.core.lang.Assert;
//import cn.hutool.core.map.MapUtil;
//import cn.hutool.core.util.StrUtil;
//import com.ruoyi.pay.core.client.PayCommonResult;
//import com.ruoyi.pay.core.client.impl.AbstractPayClient;
//import com.ruoyi.pay.core.enums.PayChannelEnum;
//import com.ruoyi.common.core.utils.bean.BeanUtils;
//import com.ruoyi.pay.core.client.dto.*;
//import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
//import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.impl.client.CloseableHttpClient;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.security.PrivateKey;
//import java.util.Objects;
//
//
///**
// * 微信小程序下支付
// *
// * @author zwy
// */
//public class WXLitePayClient extends AbstractPayClient<WXPayClientConfig> {
//
//    private WechatPayHttpClientBuilder build;
//
//    public WXLitePayClient(Long channelId, WXPayClientConfig config) {
//        super(channelId, PayChannelEnum.WX_LITE.getCode(), config, new WXCodeMapping());
//    }
//
//    @Override
//    protected void doInit() {
////        WxPayConfig payConfig = new WxPayConfig();
////        BeanUtils.copyProperties(config, payConfig, "keyContent");
////        payConfig.setTradeType(WxPayConstants.TradeType.JSAPI); // 设置使用 JS API 支付方式
//////        if (StrUtil.isNotEmpty(config.getKeyContent())) {
//////            payConfig.setKeyContent(config.getKeyContent().getBytes(StandardCharsets.UTF_8));
//////        }
////        if (StrUtil.isNotEmpty(config.getPrivateKeyContent())) {
////            // weixin-pay-java 存在 BUG，无法直接设置内容，所以创建临时文件来解决
////          //  payConfig.setPrivateKeyPath(FileUtils.createTempFile(config.getPrivateKeyContent()).getPath());
////        }
////        if (StrUtil.isNotEmpty(config.getPrivateCertContent())) {
////            // weixin-pay-java 存在 BUG，无法直接设置内容，所以创建临时文件来解决
////          //  payConfig.setPrivateCertPath(FileUtils.createTempFile(config.getPrivateCertContent()).getPath());
////        }
////        // 真实客户端
////        this.client = new WxPayServiceImpl();
////        client.setConfig(payConfig);
//    }
//
//    @Override
//    public PayCommonResult<WxPayMpOrderResult> doUnifiedOrder(PayOrderUnifiedReqDTO reqDTO) {
//
//        PrivateKey merchantPrivateKey = null;
//        try {
//            merchantPrivateKey = PemUtil.loadPrivateKey(
//                    new FileInputStream("存放路径"));
//
////
////            PrivateKey merchantPrivateKey = PemUtil.loadPrivateKey(
////                    new ByteArrayInputStream(privateKey.getBytes("utf-8")));
//
////...
//        WechatPayHttpClientBuilder builder = WechatPayHttpClientBuilder.create()
//                .withMerchant(config.getAppId(), merchantSerialNumber, merchantPrivateKey)
//                .withWechatPay(wechatPayCertificates);
//// ... 接下来，你仍然可以通过builder设置各种参数，来配置你的HttpClient
//
//// 通过WechatPayHttpClientBuilder构造的HttpClient，会自动的处理签名和验签
//        CloseableHttpClient httpClient = builder.build();
//
//// 后面跟使用Apache HttpClient一样
//        CloseableHttpResponse response = httpClient.execute();
//
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//
//        return  null;
////
////        WxPayMpOrderResult response = null;
////        try {
////            switch (config.getApiVersion()) {
////                case WXPayClientConfig.API_VERSION_V2:
////                    response = this.unifiedOrderV2(reqDTO);
////                    break;
////                case WXPayClientConfig.API_VERSION_V3:
////                    WxPayUnifiedOrderV3Result.JsapiResult responseV3 = this.unifiedOrderV3(reqDTO);
////                    // 将 V3 的结果，统一转换成 V2。返回的字段是一致的
////                    response = new WxPayMpOrderResult();
////                    BeanUtil.copyProperties(responseV3, response, true);
////                    break;
////                default:
////                    throw new IllegalArgumentException(String.format("未知的 API 版本(%s)", config.getApiVersion()));
////            }
////        } catch (WxPayException e) {
////          //  log.error("[unifiedOrder][request({}) 发起支付失败，原因({})]", toJsonString(reqDTO), e);
//////            return PayCommonResult.build(ObjectUtils.defaultIfNull(e.getErrCode(), e.getReturnCode(), "CustomErrorCode"),
//////                    ObjectUtils.defaultIfNull(e.getErrCodeDes(), e.getCustomErrorMsg()), null, codeMapping);
////        }
////        return PayCommonResult.build(WXCodeMapping.CODE_SUCCESS, WXCodeMapping.MESSAGE_SUCCESS, response, codeMapping);
//    }
//
//    private WxPayMpOrderResult unifiedOrderV2(PayOrderUnifiedReqDTO reqDTO) throws WxPayException {
//        // 构建 WxPayUnifiedOrderRequest 对象
//        WxPayUnifiedOrderRequest request = WxPayUnifiedOrderRequest.newBuilder()
//                .outTradeNo(reqDTO.getMerchantOrderId())
//                .body(reqDTO.getBody())
//                .totalFee(reqDTO.getAmount().intValue()) // 单位分
//                .timeExpire(DateUtil.format(reqDTO.getExpireTime(), "yyyyMMddHHmmss")) // v2的时间格式
//                .spbillCreateIp(reqDTO.getUserIp())
//                .openid(getOpenid(reqDTO))
//                .notifyUrl(reqDTO.getNotifyUrl())
//                .build();
//        // 执行请求
//        return client.createOrder(request);
//    }
//
//    private WxPayUnifiedOrderV3Result.JsapiResult unifiedOrderV3(PayOrderUnifiedReqDTO reqDTO) throws WxPayException {
//        // 构建 WxPayUnifiedOrderRequest 对象
//        WxPayUnifiedOrderV3Request request = new WxPayUnifiedOrderV3Request();
//        request.setOutTradeNo(reqDTO.getMerchantOrderId());
//
//        request.setDescription(reqDTO.getBody());
//        request.setAmount(new WxPayUnifiedOrderV3Request
//                .Amount()
//                .setTotal(reqDTO
//                        .getAmount()
//                        .intValue())); // 单位分
//        request.setTimeExpire(DateUtil.format(reqDTO.getExpireTime(), "yyyy-MM-dd'T'HH:mm:ssXXX")); // v3的时间格式
//        request.setPayer(new WxPayUnifiedOrderV3Request.Payer().setOpenid(getOpenid(reqDTO)));
//        request.setSceneInfo(new WxPayUnifiedOrderV3Request.SceneInfo().setPayerClientIp(reqDTO.getUserIp()));
//        request.setNotifyUrl(reqDTO.getNotifyUrl());
//        // 执行请求
//        return client.createOrderV3(TradeTypeEnum.JSAPI, request);
//    }
//
//    private static String getOpenid(PayOrderUnifiedReqDTO reqDTO) {
//        String openid = MapUtil.getStr(reqDTO.getChannelExtras(), "openid");
//        if (StrUtil.isEmpty(openid)) {
//            throw new IllegalArgumentException("支付请求的 openid 不能为空！");
//        }
//        return openid;
//    }
//
//    /**
//     *
//     * 微信支付回调 分 v2 和v3 的处理方式
//     *
//     * @param data 通知结果
//     * @return 支付回调对象
//     * @throws WxPayException 微信异常类
//     */
//    @Override
//    public PayOrderNotifyRespDTO parseOrderNotify(PayNotifyDataDTO data) throws WxPayException {
//      //  log.info("[parseOrderNotify][微信支付回调data数据:{}]", data.getBody());
//        // 微信支付 v2 回调结果处理
//        switch (config.getApiVersion()) {
//            case WXPayClientConfig.API_VERSION_V2:
//                return parseOrderNotifyV2(data);
//            case WXPayClientConfig.API_VERSION_V3:
//                return parseOrderNotifyV3(data);
//            default:
//                throw new IllegalArgumentException(String.format("未知的 API 版本(%s)", config.getApiVersion()));
//        }
//    }
//
//    private PayOrderNotifyRespDTO parseOrderNotifyV3(PayNotifyDataDTO data) throws WxPayException {
//        WxPayOrderNotifyV3Result wxPayOrderNotifyV3Result = client.parseOrderNotifyV3Result(data.getBody(), null);
//        WxPayOrderNotifyV3Result.DecryptNotifyResult result = wxPayOrderNotifyV3Result.getResult();
//        // 转换结果
//        Assert.isTrue(Objects.equals(wxPayOrderNotifyV3Result.getResult().getTradeState(), "SUCCESS"),
//                "支付结果非 SUCCESS");
//
//        return PayOrderNotifyRespDTO
//                .builder()
//                .setOrderExtensionNo(result.getOutTradeNo())
//                .setChannelOrderNo(result.getTradeState())
//                .setSuccessTime(DateUtil.parse(result.getSuccessTime(), "yyyy-MM-dd'T'HH:mm:ssXXX"))
//
//                .build();
//    }
//
//    private PayOrderNotifyRespDTO parseOrderNotifyV2(PayNotifyDataDTO data) throws WxPayException {
//        WxPayOrderNotifyResult notifyResult = client.parseOrderNotifyResult(data.getBody());
//        Assert.isTrue(Objects.equals(notifyResult.getResultCode(), "SUCCESS"), "支付结果非 SUCCESS");
//        // 转换结果
//        return PayOrderNotifyRespDTO
//                .builder()
//                .setOrderExtensionNo(notifyResult.getOutTradeNo())
//                .setChannelOrderNo(notifyResult.getTransactionId())
//                .setChannelUserId(notifyResult.getOpenid())
//                .setSuccessTime(DateUtil.parse(notifyResult.getTimeEnd(), "yyyyMMddHHmmss"))
//
//                .build();
//
//    }
//
//    @Override
//    public PayRefundNotifyDTO parseRefundNotify(PayNotifyDataDTO notifyData) {
//        //TODO 需要实现
//        throw new UnsupportedOperationException("需要实现");
//    }
//
//    @Override
//    public boolean verifyNotifyData(PayNotifyDataDTO notifyData) {
//        return false;
//    }
//
//
//    @Override
//    protected PayCommonResult<PayRefundUnifiedRespDTO> doUnifiedRefund(PayRefundUnifiedReqDTO reqDTO) throws Throwable {
//        //TODO 需要实现
//        throw new UnsupportedOperationException();
//    }
//
//}
