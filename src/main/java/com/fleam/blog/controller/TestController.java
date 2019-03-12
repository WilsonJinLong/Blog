package com.fleam.blog.controller;

import com.fleam.base.annotation.LoginToken;
import com.fleam.base.util.FileToBase64;
import com.fleam.base.util.ResponseData;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wzd
 * @since 2018-12-12
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    //图片
    @LoginToken
    @ResponseBody
    @PostMapping("/stream")
    public ResponseData stream() throws Exception {
        ResponseData responseData = ResponseData.ok();
        String base64 = FileToBase64.encryptToBase64("d:\\logo.png");
        responseData.putDataValue("json",base64);
        return responseData;
    }




}
