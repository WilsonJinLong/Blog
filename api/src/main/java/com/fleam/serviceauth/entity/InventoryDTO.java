package com.fleam.serviceauth.entity;

import lombok.Data;

@Data
public class InventoryDTO {
    private String warehouseCode;
    private String itemCode;
    private String itemId;
    private String inventoryType;
    private String quantity;
    private String lockQuantity;
    private String batchCode;
    private String productDate;
    private String expireDate;
    private String produceCode;
    private String extendProps;
    private String createTime;
}
