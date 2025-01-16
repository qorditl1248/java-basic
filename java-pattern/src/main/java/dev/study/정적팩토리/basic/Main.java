package dev.study.정적팩토리.basic;

public class Main {
    public static void main(String[] args) {
        // 정적 팩토리는 .을 통해서 들어갈 수 있음
        Product phone = Product.create("Phone", 100000);
        System.out.println(phone);
    }
}
