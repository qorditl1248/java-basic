package dev.study.컬렉션.map;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "apple");
        map.put(1, "ㅇㅇ");
        map.put(2, "apple");
        map.put(3, "apple");
        map.put(4, "apple");

        // 키를 중복으로 쓰게 되면 덮어쓰기 됨

        System.out.println("Map: " + map);
        System.out.println("키 값: " + map.get(1)); // key값

    }
}
