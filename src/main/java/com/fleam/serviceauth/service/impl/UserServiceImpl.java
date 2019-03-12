package com.fleam.serviceauth.service.impl;

import com.fleam.serviceauth.entity.User;
import com.fleam.serviceauth.mapper.UserMapper;
import com.fleam.serviceauth.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wzd
 * @since 2018-12-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
