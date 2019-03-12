package com.fleam.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fleam.blog.entity.User;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wzd
 * @since 2018-12-12
 */
@Component(value = "UserMapper")
public interface UserMapper extends BaseMapper<User> {

}
