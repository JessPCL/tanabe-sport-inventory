package com.tanabesport.inventory.events;

import com.tanabesport.inventory.models.Product;
import org.springframework.context.ApplicationEvent;

public class LowStockEvent extends ApplicationEvent {
    private final Product product;

    public LowStockEvent(Object source, Product product) {
        super(source);
        this.product = product;
    }

    // El Getter manual que reemplaza a Lombok
    public Product getProduct() {
        return product;
    }
}