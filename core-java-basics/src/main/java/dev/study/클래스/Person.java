package dev.study.클래스;

public class Person {

    // 필드는 명사
    String name;
    int age;
    String address;
    String phoneNumber;

    // 단축키 command + n -> generate

    // 기본생성자는 클래스 이름과 같고,
    public Person() {
    }

    // 매개변수가 있는 생성자
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 접근제어자 반환형 메서드명 (파라미터) { 본문 } 소개하다 동사
    // 파라미터 ->
    public void introduce() {
        System.out.println("Hi My name is" + name + "and I'm" + age + "years old");
    }

    // 메소드 오버로딩
    // 같은 이름 메서드이지만, 파라미터의 타입이나 갯수가 다르면 반환타입이 달라도 가능

    // 메소드 오버라이딩
    // 부모클래스에서의 받아온 메서드를 자식클래스에서 재정의하는 것



}
