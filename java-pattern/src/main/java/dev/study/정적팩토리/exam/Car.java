package dev.study.정적팩토리.exam;

/**
 * 문제: Car 클래스를 설계하라
 * 필드는 String brand, String model, int price
 * Car 객체를 생성하는 '정적 팩토리 메서드'를 작성하라 -> car 객체를 생성할 때, private으로 생성자를 막으라는 의미
 * 메서드이름 of 예 -> Car.of("Hyundai", "Sonata", 2500);
 *
 * - 싱글톤 객체로 만들어라 라는 것임!
 */

public class Car {
    private final String brand;
    private final String modal;
    private final int price;

    private Car(String brand, String modal, int price) {
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
