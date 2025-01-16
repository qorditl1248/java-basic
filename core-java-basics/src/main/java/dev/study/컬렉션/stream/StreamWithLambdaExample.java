package dev.study.컬렉션.stream;

import java.util.Arrays;
import java.util.List;

public class StreamWithLambdaExample {
    public static void main(String[] args) {

        List<String> fruits = Arrays.asList( "Apple", "Banana", "Orange", "Apple");

        // 중복 제거, 정렬, 출력
        fruits.stream()
//                .map(fruit -> Integer.parseInt(fruit)) - 다시 합친다는 map안에서 바꿀수도 있는거!
                .distinct()
                .sorted()
                .forEach(System.out::println); // 람다식



    }
}
