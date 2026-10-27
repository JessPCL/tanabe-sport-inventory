package com.tanabesport.inventory.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private String sku;
    private int currentStock;
    private int minStockThreshold;

    // Getters y Setters manuales (lo que Lombok hacía en secreto)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }
    
    public int getCurrentStock() { return currentStock; }
    public void setCurrentStock(int currentStock) { this.currentStock = currentStock; }
    
    public int getMinStockThreshold() { return minStockThreshold; }
    public void setMinStockThreshold(int minStockThreshold) { this.minStockThreshold = minStockThreshold; }
}