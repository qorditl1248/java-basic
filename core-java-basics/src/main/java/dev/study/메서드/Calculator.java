package dev.study.메서드;

public class Calculator {
    // final 사용하기 위해서는 생성자를 생성해줘야 함
    private final String name;

    public Calculator(String name) {
        this.name = name;
    }

    public int add(int a, int b){
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    // 오버라이딩은 다형성이라는 걸 활용 -> 동적 메서드 활용
    public static void main(String[] args) {
        Animal animal = new Cat(); // 우리는 animal로 만들었는데 실체는 Cat 클래스
        animal.sound();

    }

}
class Animal {
    public void sound() {
        System.out.println("Animal 클래스");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("오버라이딩 한거임");
        // super.sound();  super -> animal
    }
}

