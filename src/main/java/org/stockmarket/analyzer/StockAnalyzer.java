package org.stockmarket.analyzer;

import org.stockmarket.model.Stock;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class StockAnalyzer {
    private final ConcurrentHashMap<String , Double>
    previousPrices = new ConcurrentHashMap<>();
    public boolean analyze(Stock stock){
        double thresold = 500;
        boolean significantChange= stock.getPrice()>thresold;
        previousPrices.put(stock.getSymbol(), stock.getPrice());
        return significantChange;
    }




}
