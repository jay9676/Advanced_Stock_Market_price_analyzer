package org.stockmarket.logging;

public class ThreadLogger {
    private static final ThreadLocal<StringBuilder> threadLog = ThreadLocal.withInitial(StringBuilder::new);


    public static void log(String message) {
        threadLog.get().append(message).append("\n");

    }

    public static String getLog() {
        return threadLog.get().toString();
    }

    public static void clearlog() {
        threadLog.remove();
    }
}




