package dev.study.컬렉션.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {

        // 생성과 동시에 초기화
        List<String> fruits = Arrays.asList( "Apple", "Banana", "Orange", "Apple");

        List<String> uniqueList = fruits.stream()
                .distinct() // 중복제거
                .toList();

        System.out.println("UniqueList" + uniqueList);


        List<String> filterdFruits = fruits.stream()
                .filter(fruit -> fruit.startsWith("B")) // 첫 글자가 b로 시작하는 거
                .toList();

        System.out.println("filter 된 거: " + filterdFruits);

        // for문으로 바꿔보는 걸로
    }
}
