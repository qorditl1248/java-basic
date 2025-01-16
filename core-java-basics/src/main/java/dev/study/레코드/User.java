package dev.study.레코드;

public record User(
        // 소괄호 안에 적는거, 알아서 final 적혀지고 쉼표 붙임
        // 불변객체를 쉽게 만들 수 있음
        String name,
        int age
) {
    // 메서드 만들 수 있는 곳
    public void getUser() {
        System.out.println("name" + name);
    }

}
