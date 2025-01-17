package dev.study.immutable;

public class Main {
    public static void main(String[] args) {

        ImmutableExample bank = new ImmutableExample("1352-1111", 15000);
        ImmutableExample newBank = bank.withUpdatedBalance(16000);

        System.out.println(bank);
        System.out.println(newBank);

        Student student1 = new Student("짱구", 1);
        Student student2 = new Student("맹구", 2);

        Student updateStudentName = student1.newStudent("철수");

        System.out.println(student1); // 짱구, 1
        System.out.println(student2); // 맹구, 2
        System.out.println(updateStudentName); // 철수, 1


    }
}
