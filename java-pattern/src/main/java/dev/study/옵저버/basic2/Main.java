package dev.study.옵저버.basic2;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

/**
   날짜 정보 알림
 - 날씨 데이터를 관리하는 WeatherStation (주체)
 - 구독자(옵저버)에게 날씨정보를 알려주는 것
 - WeatherObserver -> update(float temperature, float humidity)

 WeatherObserver, WeatherStation, addObserver, removeObserver, deleteObserve
 notifyObserver, setWeatherData, MobileDevice

 */

// 옵저버
interface WeatherObserver {
    void update(float temperature, float humidity);
}

// 주체
class WeatherStation {
    private final List<WeatherObserver> observers = new ArrayList<>();
    private float temperature;
    private float humidity;

    // 옵저버 추가
    public void addObserver(WeatherObserver weatherObserver) {
        observers.add(weatherObserver);
    }

    // 옵저버 삭제
    public void removeObserver(WeatherObserver weatherObserver) {
        observers.remove(weatherObserver);
    }

    // 알림 보내는 옵저버
    public void notifyObserver() {
        for(WeatherObserver observer : observers) {
            observer.update(temperature, humidity);
        }
    }

    // 상태 변경 메서드
    public void setWeatherData(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObserver(); // 셋팅 된 이후에 상태 바뀐것으로 알림 보내기
    }
}

class MobileDevice implements WeatherObserver {
    private final String name;

    MobileDevice(String name) {
        this.name = name;
    }

    @Override
    public void update(float temperature, float humidity) {
        System.out.println(name + "received weather: Temperature =" + temperature + " Humidity =" + humidity);
    }
}


public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        MobileDevice mobileDevice1 = new MobileDevice("부산");
        MobileDevice mobileDevice2 = new MobileDevice("서울");

        weatherStation.addObserver(mobileDevice1);
        weatherStation.addObserver(mobileDevice2);

        // 상태변경 됐다는 걸 저장하고 -> 저장된 값을 가지고 notifyObserver에게 감
        weatherStation.setWeatherData(25.6f, 78.9f);
        weatherStation.setWeatherData(22.6f, 58.9f);




    }
}
