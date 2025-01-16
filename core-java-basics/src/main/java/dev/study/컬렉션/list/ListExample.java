package dev.study.컬렉션.list;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {

        // 제네릭 타입을 넣을 수 있는 <>
        // 리스트의 형태 어떻게 할거야 하는 곳 <>
        // 와일드 카드로 ? 쓰면 타입을 알 수가 없음

        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("apple");
        list.add("apple");
        list.add("apple");
        list.add("Banana");
        list.add("apple");
        list.add("apple");


        System.out.println("List" + list);
        System.out.println("첫 번째 값: " + list.getFirst());
    }
}
