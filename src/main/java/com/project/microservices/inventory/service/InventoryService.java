package com.project.microservices.inventory.service;

import com.project.microservices.inventory.dto.InventoryRequest;
import com.project.microservices.inventory.model.Inventory;
import com.project.microservices.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public boolean isInStock(
            @RequestParam String skuCode ,@RequestParam Integer quantity) {
        // Check if the inventory has enough quantity for the given SKU code
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);

    }
    public void addInventory(InventoryRequest request) {
        Inventory inventory = new Inventory();
        inventory.setSkuCode(request.skuCode());
        inventory.setQuantity(request.quantity());
        inventoryRepository.save(inventory);
    }


}
