package dev.study.클래스;

import dev.study.레코드.User;

public class Main {
    public static void main(String[] args) {

        // 객체가 생성이 되었다. new
        Person person = new Person("Zephyre", 10);
        person.introduce(); // 메서드 호출

        User test = new User("test", 11);
//        test.age(); - 이렇게 값을 불러 올 수 있음

    }
}
