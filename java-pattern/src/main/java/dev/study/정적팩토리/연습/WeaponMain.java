package dev.study.정적팩토리.연습;

/**
 * 	•	게임에서 무기를 생성하는 WeaponFactory 클래스를 구현하세요.
 * 	•	아래 정적 팩토리 메서드를 추가하세요:
 * 	1.	createSword() - Sword 객체 반환.
 * 	2.	createBow() - Bow 객체 반환.
 * 	•	Weapon은 인터페이스이고, Sword와 Bow는 이를 구현합니다
 */

interface Weapon {
    void use();
}

class Sword implements Weapon {
    @Override
    public void use() {
        System.out.println("Swrod 임");
    }
}

class Bow implements Weapon {
    @Override
    public void use() {
        System.out.println("Bow 임");
    }
}

class WeaponFactory {
    public static Weapon createSword() {
        return new Sword();
    }

    public static Weapon createBow() {
        return new Bow();
    }
}


public class WeaponMain {
    public static void main(String[] args) {
        Weapon sword = WeaponFactory.createSword();
        Weapon bow = WeaponFactory.createBow();

        sword.use();
        bow.use();

    }
}
