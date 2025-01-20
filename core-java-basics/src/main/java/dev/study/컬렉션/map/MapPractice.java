package dev.study.컬렉션.map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapPractice {
    public static void main(String[] args) {
        /*
            Map<String, Integer>로 학생 이름과 점수를 저장하세요.
	        1.	모든 학생의 이름과 점수를 출력합니다.
	        2.	점수가 80 이상인 학생만 출력합니다.
	        3.	모든 학생의 점수를 10점씩 증가시키고 출력합니다.
         */

        Map<String, Integer> students = new HashMap<>();
        students.put("김일번", 80);
        students.put("김이번", 74);
        students.put("김삼번", 90);
        students.put("김사번", 65);
        students.put("김오번", 81);

        // entrySet() - 전체 key와 value 꺼내는 거!
        Map<String, Integer> newStudents = students.entrySet()
                .stream().filter(student -> student.getValue() >= 80)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        student -> student.getValue() + 10
                ));

        newStudents.forEach((name, score)
                -> System.out.println("이름: " + name + ", 점수: " + score));

    }
}
