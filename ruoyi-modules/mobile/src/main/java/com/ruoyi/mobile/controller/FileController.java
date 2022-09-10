package com.ruoyi.mobile.controller;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.core.utils.file.FileTypeUtils;
import com.ruoyi.common.core.utils.file.MimeTypeUtils;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.shop.domain.Product;
import com.ruoyi.system.api.RemoteFileService;
import com.ruoyi.system.api.domain.SysFile;
import com.ruoyi.system.api.model.LoginUser;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@RestController
@RequestMapping("/file")
public class FileController extends BaseController {
    @Autowired
    RemoteFileService remoteFileService;

    //    @RequiresPermissions("mobile:product:edit")
    @Log(title = "商品基础信息", businessType = BusinessType.UPDATE)
    @PostMapping("/upload")
    public AjaxResult upload(@RequestParam("file") MultipartFile file) {

//        LoginUser loginUser = SecurityUtils.getLoginUser();
        String extension = FileTypeUtils.getExtension(file);
        if (!StringUtils.equalsAnyIgnoreCase(extension, MimeTypeUtils.IMAGE_EXTENSION)) {
            return AjaxResult.error("文件格式不正确，请上传" + Arrays.toString(MimeTypeUtils.IMAGE_EXTENSION) + "格式");
        }
        R<SysFile> fileResult = remoteFileService.upload(file);

        if (StringUtils.isNull(fileResult) || StringUtils.isNull(fileResult.getData())) {
            return AjaxResult.error("文件服务异常，请联系管理员");
        } else {
            String url = fileResult.getData().getUrl();

            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileUrl", url);

            return ajax;
        }


//        return (remoteFileService.upload(product, SecurityConstants.INNER));
    }
}
