package org.stockmarket.notifier;

import org.stockmarket.model.Stock;

public class StockNotifier {
    public void notifyUser(Stock stock){
        System.out.println("ALERT" + stock.getSymbol()+"price"+stock.getPrice());
    }

}
