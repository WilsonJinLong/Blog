package com.fleam.blog.service;

import com.fleam.blog.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fleam.blog.entity.UserVO;
import com.fleam.base.util.ResponseData;

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
