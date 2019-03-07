package com.fleam.serviceauth.service.impl;

import com.fleam.serviceauth.entity.Location;
import com.fleam.serviceauth.mapper.LocationMapper;
import com.fleam.serviceauth.service.ILocationService;
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
