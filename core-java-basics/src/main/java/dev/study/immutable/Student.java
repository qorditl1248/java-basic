package dev.study.immutable;

/*
    학생의 정보를 나타내는 클래스 구현
    클래스는 불변객체로 설계
    필드: String name, int studentId

    학번은 변경할 수 없으나, 이름 변경이 필요한 경우 새로운 객체를 반환
 */

public final class Student {
    private final String name;
    private final int studentId;

    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public Student newStudent(String newName) {
        return new Student(newName, studentId);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentId=" + studentId +
                '}';
    }
}
