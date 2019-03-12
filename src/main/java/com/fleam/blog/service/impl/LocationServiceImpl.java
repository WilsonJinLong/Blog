package com.fleam.blog.service.impl;

import com.fleam.blog.entity.Location;
import com.fleam.blog.mapper.LocationMapper;
import com.fleam.blog.service.ILocationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wzd
 * @since 2019-01-14
 */
@Service
public class LocationServiceImpl extends ServiceImpl<LocationMapper, Location> implements ILocationService {

}
