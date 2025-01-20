package dev.study.컬렉션.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListPractice {
    public static void main(String[] args) {
        /*
         * 주어진 정수 리스트에서 다음 작업을 수행
         * 	1.	짝수만 필터링합니다.
         * 	2.	필터링된 짝수를 내림차순으로 정렬합니다.
         * 	3.	최종 결과를 출력합니다.
         */

        List<Integer> numbers = Arrays.asList(5, 10, 3, 8, 15, 12);
//      List<Integer> numbers = new ArrayList<>();
//      numbers.add(5);
//      numbers.add(10); ...

       numbers = numbers.stream()
               .filter(number -> number % 2 == 0)
               .sorted()
               .toList();
       // java8 버전에서는 toList() 사용 못함! -> collect(Collectors.toList()) 이렇게 만들어줘야함

       System.out.println(numbers); // [8, 10, 12]





    }
}
