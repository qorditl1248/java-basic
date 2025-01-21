package dev.study.옵저버.exam;


import java.util.ArrayList;
import java.util.List;

/**
 * 주식 가격 알림 시스템
 *
 * 주체(Subject): StockMarket
 *
 * 필드: String stockName, double stockPrice
 *
 * 상태 변경 메서드: setStockData(String name, double price)
 *
 * 옵저버(Observer): Investor
 *
 * 관심 있는 주식이름과 가격 변동 알림을 수신
 *
 * addObserver, removeObserver, notifyObserver

 출력
 * Alice notified: AAPL is now $145.5
 * Bob notified: AAPL is now $145.5
 * Alice notified: GOOG is now $2725.6
 * Bob notified: GOOG is now $2725.6
 */

// 옵저버
interface StockObserver {
    void update(String stockName, double stockPrice);
}

// 주체 -> 옵저버 추가하고, 삭제하고, 알림보내는 거야
class StockMarket {
    private final List<StockObserver> stockObservers = new ArrayList<>();
    private String name;
    private double price;

    // 옵저버 추가
    public void addObserver(StockObserver stockObserver) {
        stockObservers.add(stockObserver);
    }

    // 옵저버 삭제
    public void removeObserver(StockObserver stockObserver) {
        stockObservers.remove(stockObserver);
    }

    // 알림 보내기
    public void notifyObserver() {
        for (StockObserver stockObserver : stockObservers) {
            stockObserver.update(name, price);
        }
    }

    // 상태 변경
    public void  setStockData(String name, double price) {
        this.name = name;
        this.price = price;
        notifyObserver();
    }
}

class Investor implements StockObserver {
    private final String name;

    Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println(name + " notified: " + stockName + " is now $"+ stockPrice);
    }
}

public class Main {
    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();

        // 우리가 쓸려고 하는건 StockObserver
        StockObserver investor1 =  new Investor("Alice");
        StockObserver investor2 =  new Investor("Bob");

        stockMarket.addObserver(investor1);
        stockMarket.addObserver(investor2);

        stockMarket.setStockData("APPL", 145.5);
        stockMarket.setStockData("GOOG", 2725.6);

    }
}
