package com.fleam.serviceauth.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Inventory {
    private String warehouseCode;
    private String itemId;
    private String inventoryType;
    private String quantity;
    private String lockQuantity;
    private Date expireDate;
    private Date createTime;
}
