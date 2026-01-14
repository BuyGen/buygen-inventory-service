package com.project.microservices.inventory.dto;

public record InventoryRequest(String skuCode, Integer quantity) {}
