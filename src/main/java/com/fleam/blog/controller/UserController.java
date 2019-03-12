package com.fleam.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fleam.base.annotation.CheckToken;
import com.fleam.base.annotation.LoginToken;
import com.fleam.blog.entity.User;
import com.fleam.blog.entity.UserVO;
import com.fleam.blog.service.IUserService;
import com.fleam.base.util.JwtUtil;
import com.fleam.base.util.ResponseData;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wzd
 * @since 2018-12-12
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    //登录
    @LoginToken
    @ResponseBody
    @PostMapping("/login")
    public ResponseData login(@RequestBody User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(user);
        User userInfo = userService.getOne(queryWrapper);
        ResponseData responseData = ResponseData.ok();
        if(userInfo == null){
            responseData =  ResponseData.unauthorized();
            return responseData;
        }
        String token = JwtUtil.createToken(userInfo);
        Claims claims = Jwts.parser().setSigningKey("fleam").parseClaimsJws(token).getBody();
        Date exp =  claims.getExpiration();
        responseData.putDataValue("exp", exp);
        responseData.putDataValue("token", token);
        responseData.putDataValue("user", userInfo);
        return responseData;
    }

    //用户列表
    @CheckToken
    @ResponseBody
    @GetMapping("/userList")
    public ResponseData userList() {
        List<User> userList = userService.list();
        ResponseData responseData = ResponseData.ok();
        responseData.putDataValue("userList",userList);
        return responseData;
    }

    //修改密码
    @CheckToken
    @ResponseBody
    @PostMapping("/passwordEdit")
    public ResponseData passwordEdit(@RequestBody UserVO userVO) {
        return userService.passwordEdit(userVO);
    }


    //刷新token
    @CheckToken
    @ResponseBody
    @GetMapping("/refreshToken")
    public ResponseData refreshToken(HttpServletRequest httpServletRequest) {

        String token = httpServletRequest.getHeader("token");
        Claims claims = Jwts.parser().setSigningKey("fleam").parseClaimsJws(token).getBody();

        User userInfo = new User();
        userInfo.setId((Integer) claims.get("id"));
        userInfo.setUsername((String) claims.get("username"));
        String newToken = JwtUtil.createToken(userInfo);

        ResponseData responseData = ResponseData.ok();
        Claims newClaims = Jwts.parser().setSigningKey("fleam").parseClaimsJws(token).getBody();
        Date newExp =  newClaims.getExpiration();
        responseData.putDataValue("exp", newExp);
        responseData.putDataValue("token", newToken);
        responseData.putDataValue("user", userInfo);

        return responseData;
    }


}
