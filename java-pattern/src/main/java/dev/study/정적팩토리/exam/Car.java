package dev.study.정적팩토리.exam;

/**
 * 문제: Car 클래스를 설계하라
 * 필드는 String brand, String model, int price
 * Car 객체를 생성하는 '정적 팩토리 메서드'를 작성하라
 * 메서드이름 of 예 -> Car.of("Hyundai", "Sonata", 2500);
 */

public class Car {
    private final String brand;
    private final String modal;
    private final int price;

    public Car(String brand, String modal, int price) {
        this.brand = brand;
        this.modal = modal;
        this.price = price;
    }

    public static Car createCar(String brand, String modal, int price) {
        return new Car(brand, modal, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", modal='" + modal + '\'' +
                ", price=" + price +
                '}';
    }
}
