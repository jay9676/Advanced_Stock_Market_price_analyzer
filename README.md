# Stock Market Price Analyzer and Notifier

## Description
The **Stock Market Price Analyzer and Notifier** is a multithreaded Java application that fetches real-time stock prices, analyzes them for significant changes, and sends alerts based on predefined thresholds. This project demonstrates the use of advanced Java features like multithreading, concurrency controls, custom thread factories, and thread-safe data structures.

---

## Key Features
- **Multithreaded Stock Price Fetching**: Uses a thread pool to fetch stock prices concurrently for multiple stock symbols.
- **Stock Analysis**: Analyzes stock prices to detect significant changes based on a threshold.
- **Notifier**: Alerts users when stock prices cross predefined limits.
- **Scheduled Notifications**: Periodic notifications using a scheduled thread pool.
- **Concurrency Controls**: Implements semaphores and thread-safe data structures for robust multithreaded processing.
- **Custom Thread Factory**: Creates custom-named threads for easier debugging.
- **Thread-Local Logging**: Maintains logs specific to each thread for better traceability.

---

## Technologies Used
- **Java 8+**
- **Maven** (for project build and dependency management)
- **Multithreading** (ExecutorService, ScheduledExecutorService, ThreadFactory)
- **Concurrency Utilities** (Semaphore, ConcurrentHashMap)

---
How to Run

Prerequisites

Java 8+

Maven


Steps to Run

1. Clone the repository:

git clone https://github.com/your-repo/StockMarketAnalyzer.git


2. Navigate to the project directory:

cd StockMarketAnalyzer


3. Build the project:

mvn clean install


4. Run the application:

mvn exec:java -Dexec.mainClass="com.project.stockmarket.MainApplication"



Sample Output

Fetcher-Thread-0: Fetched data for AAPL
Fetcher-Thread-1: Fetched data for GOOGL
Fetcher-Thread-2: Fetched data for MSFT
Fetcher-Thread-3: Fetched data for TSLA
Fetcher-Thread-4: Fetched data for AMZN
ALERT: AAPL price is 652.34
ALERT: TSLA price is 720.56
Scheduled Notification Task Running
