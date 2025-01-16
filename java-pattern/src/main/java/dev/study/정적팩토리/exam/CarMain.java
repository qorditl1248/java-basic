package dev.study.정적팩토리.exam;

public class CarMain {
    public static void main(String[] args) {

       Car car = Car.createCar("Hyundai", "Sonata", 2500);
       System.out.println(car);
    }
}
