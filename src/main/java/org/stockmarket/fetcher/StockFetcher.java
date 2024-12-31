package org.stockmarket.fetcher;

import org.stockmarket.model.Stock;

import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

public class StockFetcher implements Callable<Stock> {
    private static final Semaphore API_RATE_LIMIT = new Semaphore(5);
    private final String stockSymbol;
    public StockFetcher(String stockSymbol) {
        this.stockSymbol=stockSymbol;
    }
    @Override
    public Stock call() throws Exception{
        try{
            API_RATE_LIMIT.acquire();
            double price = Math.random()*1000;
            long timestamp = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName()+ "fetched data for"+stockSymbol);
            return new Stock(stockSymbol,price,timestamp);

        }
        finally{
            API_RATE_LIMIT.release();
        }
    }




}
