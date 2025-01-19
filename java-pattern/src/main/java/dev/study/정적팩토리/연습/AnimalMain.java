package dev.study.정적팩토리.연습;

/**
 * 	동물 객체를 생성하는 AnimalFactory 클래스를 구현하세요.
 * 	•	아래의 정적 팩토리 메서드를 추가하세요:
 * 	1.	createMeerkat() - MeerKat 객체 반환.
 * 	2.	createMajorica()- Majorica 객체 반환.
 * 	•	Animal은 인터페이스이고, Meerkat, Majorica은 이를 구현합니다.
 */


interface Animal {
    void say();
}

class MeerKat implements Animal {
    @Override
    public void say() {
        System.out.println("Meerkat 객체");
    }
}

class Majorica implements Animal {
    @Override
    public void say() {
        System.out.println("Majorica 객체");
    }
}

class AnimalFactory {
    public static Animal createMeerkat() {
        return new MeerKat();
    }

    public static Animal createMajorica() {
        return new Majorica();
    }
}


public class AnimalMain {
    public static void main(String[] args) {

        Animal meerkat = AnimalFactory.createMeerkat();
        Animal majorica = AnimalFactory.createMajorica();

        meerkat.say();
        majorica.say();

    }
}
