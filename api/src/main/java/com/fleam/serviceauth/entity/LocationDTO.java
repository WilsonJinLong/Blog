package com.fleam.serviceauth.entity;

import lombok.Data;

@Data
public class LocationDTO {
    private String inventoryType;
    private String itemCode;
    private String itemId;
    private String ownerCode;
    private String warehouseCode;
}
