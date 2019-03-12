package com.fleam.serviceauth.service.impl;

import com.fleam.serviceauth.entity.Inventory;
import com.fleam.serviceauth.mapper.InventoryMapper;
import com.fleam.serviceauth.service.IInventoryService;
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
public class InventoryServiceImpl extends ServiceImpl<InventoryMapper, Inventory> implements IInventoryService {

}
