package com.fleam.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fleam.blog.entity.User;
import com.fleam.blog.entity.UserVO;
import com.fleam.blog.mapper.UserMapper;
import com.fleam.blog.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fleam.base.util.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wzd
 * @since 2018-12-12
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public ResponseData passwordEdit(UserVO userVO) {
        //两次密码是否一致
        if(!userVO.getNewPassword().equals(userVO.getRePassword())){
            ResponseData responseData = ResponseData.badRequest();
            responseData.putDataValue("msg","新密码和确认密码不一致");
            return responseData;
        }

        //原始密码是否正确
        User user = new User();
        user.setId(userVO.getId());
        user.setPassword(userVO.getOldPassword());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(user);
        User userInfo = this.getOne(queryWrapper);
        if(userInfo == null){
            ResponseData responseData = ResponseData.badRequest();
            responseData.putDataValue("msg","用户密码不正确");
            return responseData;
        }

        //更新密码
        User userUpdate = new User();
        userUpdate.setId(userVO.getId());
        userUpdate.setPassword(userVO.getNewPassword());
        this.updateById(userUpdate);
        ResponseData responseData = ResponseData.ok();
        responseData.putDataValue("msg","修改成功");
        return responseData;
    }
}
