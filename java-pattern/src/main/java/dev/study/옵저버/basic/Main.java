package dev.study.옵저버.basic;

import java.util.ArrayList;
import java.util.List;

/**
 *  기본 옵저버 패턴 구현
 * - 뉴스 에이전시(주체)가 구독자(옵저버) 들에게 새 뉴스가 나왔을 때 알리는 시스템
 *
 *  이미 구독되어 있고, 유튜브로 하면 스트리머가 있으면 구독자들에게 업데이트가 가는데 그것도 옵저버패턴 중 하나
 *
 */

// 구독을 당하는 Observer
interface Observer {
    void update(String message);
}

// 뉴스를 발급하는 주체
// 주체가 Observer를 구독시키는거

class NewsAgency {
    private final List<Observer> observers = new ArrayList<>();

    // 옵저버 등록
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // 옵저버 제거
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    // 옵저버 상태 변경 알림
    public void notifyObservers(String message) {
        for(Observer observer : observers) {
            observer.update(message);
        }
    }
}

class NewsSubscriber implements Observer {
    private final String name;

    NewsSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "received news: " + message);
    }
}



public class Main {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();
        NewsSubscriber aa =  new NewsSubscriber("aa");
        NewsSubscriber bb =  new NewsSubscriber("bb");

        newsAgency.addObserver(aa);
        newsAgency.addObserver(bb);
        newsAgency.notifyObservers("새로운 뉴스 입니다.");
        newsAgency.deleteObserver(aa);
        newsAgency.notifyObservers("방금 들어온 뉴스입니다.");

    }
}
