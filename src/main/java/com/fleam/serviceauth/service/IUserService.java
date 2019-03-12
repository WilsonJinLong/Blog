package com.fleam.serviceauth.service;

import com.fleam.serviceauth.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fleam.serviceauth.entity.UserVO;
import com.fleam.serviceauth.util.ResponseData;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wzd
 * @since 2018-12-12
 */
public interface IUserService extends IService<User> {
    ResponseData passwordEdit(UserVO userVO);
}
