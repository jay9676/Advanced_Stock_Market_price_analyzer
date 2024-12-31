package org.stockmarket.utils;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {
    private int counter=0;
    private final String prefix;

    public CustomThreadFactory(String prefix){
        this.prefix=prefix;
    }
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r,prefix+"-THread-"+ counter++);
        t.setDaemon(false);
        return t;
    }

}
