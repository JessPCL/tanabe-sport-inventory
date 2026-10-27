package com.tanabesport.inventory.observers;
import com.tanabesport.inventory.events.LowStockEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StockAlertObserver {
    @EventListener
    public void onLowStockEvent(LowStockEvent event) {
        System.out.println("🚨 [ALERTA INTELIGENTE] El producto '" + event.getProduct().getName() + 
                           "' tiene bajo stock (" + event.getProduct().getCurrentStock() + " unidades). ¡Se requiere reabastecimiento!");
    }
}