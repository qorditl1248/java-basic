package dev.study.정적팩토리.연습;

public class Main {
    public static void main(String[] args) {

        DatabaseConnection databaseConnection = DatabaseConnection.getInstance("user1");
        DatabaseConnection databaseConnection2 = DatabaseConnection.getInstance("user1");

        System.out.println(databaseConnection);
        System.out.println(databaseConnection2);
        System.out.println(databaseConnection == databaseConnection2);

        ColorFactory colorFactory1 = ColorFactory.getInstance("red");
        ColorFactory colorFactory2 = ColorFactory.getInstance("red");
        ColorFactory colorFactory3 = ColorFactory.getInstance("blue");

        System.out.println(colorFactory1);
        System.out.println(colorFactory2);
        System.out.println(colorFactory3);
        System.out.println(colorFactory3 == colorFactory1);

    }
}
