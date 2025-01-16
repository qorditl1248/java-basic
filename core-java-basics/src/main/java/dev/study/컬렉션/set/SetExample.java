package dev.study.컬렉션.set;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("apple");
        set.add("banana");
        set.add("apple");
        set.add("apple");

        // 중복값 허용 x
        System.out.println("Set" + set);

    }
}
