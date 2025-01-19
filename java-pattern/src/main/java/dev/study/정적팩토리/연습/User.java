package dev.study.정적팩토리.연습;

/**
 *  두 가지 정적 팩토리 메서드
 * 	1.	fromName(String name) - 이름만 제공받아 User 객체를 생성.
 * 	2.	fromNameAndAge(String name, int age) - 이름과 나이를 제공받아 User 객체를 생성.
 */

public class User {
    private final String name;
    private final int age;

    private User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static User fromName(String name) {
        return new User(name, 0);
    }

    public static User fromNameAndAge(String name, int age) {
        return new User(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
