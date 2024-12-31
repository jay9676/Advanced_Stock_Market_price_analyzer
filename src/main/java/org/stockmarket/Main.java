package org.stockmarket;

import org.stockmarket.analyzer.StockAnalyzer;
import org.stockmarket.fetcher.StockFetcher;
import org.stockmarket.model.Stock;
import org.stockmarket.notifier.StockNotifier;
import org.stockmarket.utils.CustomThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService fetcherPool = Executors.newFixedThreadPool(5, new CustomThreadFactory("Fetcher"));
        ScheduledExecutorService notifierScheduler = Executors.newScheduledThreadPool(1);


        String[] stocks ={"appl","google","msft","tsla","amzn"};
        List<StockFetcher> tasks= new ArrayList<>();
        for(String stock: stocks){
            tasks.add(new StockFetcher(stock));
        }
        List<Future<Stock>> results = fetcherPool.invokeAll(tasks);

        StockAnalyzer analyzer = new StockAnalyzer();
        StockNotifier notifier = new StockNotifier();
        for(Future<Stock> result : results){
            Stock stock =result.get();
            if(analyzer.analyze(stock)) {
                notifier.notifyUser(stock);
            }
        }
        notifierScheduler.scheduleAtFixedRate(() ->
                System.out.println("scheduled notification tast running"),0,1,TimeUnit.MINUTES);
        fetcherPool.shutdown();
        notifierScheduler.shutdown();
        }
    }
