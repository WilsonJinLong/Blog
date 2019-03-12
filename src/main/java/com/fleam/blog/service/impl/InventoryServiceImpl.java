package com.fleam.blog.service.impl;

import com.fleam.blog.entity.Inventory;
import com.fleam.blog.mapper.InventoryMapper;
import com.fleam.blog.service.IInventoryService;
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
