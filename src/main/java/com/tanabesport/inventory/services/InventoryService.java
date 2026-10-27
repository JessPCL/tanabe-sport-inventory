package com.tanabesport.inventory.services;

import com.tanabesport.inventory.events.LowStockEvent;
import com.tanabesport.inventory.models.Product;
import com.tanabesport.inventory.repositories.ProductRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    private final ProductRepository productRepository;
    private final ApplicationEventPublisher eventPublisher;

    // Constructor manual
    public InventoryService(ProductRepository productRepository, ApplicationEventPublisher eventPublisher) {
        this.productRepository = productRepository;
        this.eventPublisher = eventPublisher;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product reduceStock(String sku, int quantityToReduce) {
        Product product = productRepository.findBySku(sku)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        
        product.setCurrentStock(product.getCurrentStock() - quantityToReduce);
        Product updatedProduct = productRepository.save(product);

        if (updatedProduct.getCurrentStock() <= updatedProduct.getMinStockThreshold()) {
            eventPublisher.publishEvent(new LowStockEvent(this, updatedProduct));
        }
        return updatedProduct;
    }
}