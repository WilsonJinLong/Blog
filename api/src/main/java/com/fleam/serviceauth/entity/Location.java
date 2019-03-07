package com.fleam.serviceauth.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Location {
    private String inventoryType;
    private String itemId;
    private String ownerCode;
    private String warehouseCode;
    private Date createTime;
}
