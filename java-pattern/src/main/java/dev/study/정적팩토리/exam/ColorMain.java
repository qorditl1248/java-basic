package dev.study.정적팩토리.exam;

public class ColorMain {
    public static void main(String[] args) {
       Color color1 = Color.getInstance("red");
       Color color2 = Color.getInstance("red");
       Color color3 = Color.getInstance("blue");

        System.out.println(color1);
        System.out.println(color2);
        System.out.println(color3);

        System.out.println(color1 == color2); // true
        System.out.println(color1 == color3); // false
    }
}
