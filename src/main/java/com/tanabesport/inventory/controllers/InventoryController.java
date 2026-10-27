package com.tanabesport.inventory.controllers;

import com.tanabesport.inventory.models.Product;
import com.tanabesport.inventory.services.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    // Constructor manual
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(inventoryService.createProduct(product));
    }

    @PostMapping("/products/{sku}/reduce")
    public ResponseEntity<Product> reduceStock(@PathVariable String sku, @RequestParam int quantity) {
        return ResponseEntity.ok(inventoryService.reduceStock(sku, quantity));
    }
}