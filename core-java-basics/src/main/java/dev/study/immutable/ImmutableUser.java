package dev.study.immutable;

public final class ImmutableUser {
    private final String name;
    private final int age;

    public ImmutableUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getter 밖에 없음 왜? final의 값을 바꿀 수 없기 때문
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ImmutableUser getImmutable() {
        return new ImmutableUser("ddd", 11);
    }

}
