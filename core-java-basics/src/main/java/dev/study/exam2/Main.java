package dev.study.exam2;

import java.util.List;

/**
 *  요구사항
 *
 *  도서(Book)
 *  도서 클래스는 불변 객체로 설계
 *  도서의 필드 값은 제목(title), 저자(author), 가격(price)
 *
 *  도서관 회원(Member)
 *  레코드를 사용하여 회원 객체를 설계
 *  회원은 회원Id(memberId), 이름(name), 대출목록(borrowedBooks)
 *
 *  도서 관리 시스템(LibraryManager)
 *  여러 회원과 도서를 관리
 *  1. 도서 추가: 새로운 도서를 추가하는 메서드 (addBook)
 *  2. 도서 검색: 메서드 오버로딩 활용해
 *      도서이름으로 검색:  searchBook(String title),
 *      도서이름과 저자로 검색: searchBook(String title, String author)
 *  3. 회원 추가: 새로운 회원을 추가하는 메서드 (addMember)
 *  4. 회원 검색: 회원 id를 기준으로 회원 정보를 검색하는 메서드 (searchMemberId)
 *
 */


public class Main {
    public static void main(String[] args) {

        Book java = new Book("Java", "John", 4500.0);
        Book python = new Book("Python", "Jane", 3500.0);
        Book react = new Book("React", "Alice", 2500.0);

        LibraryManager libraryManager = new LibraryManager();

        libraryManager.addBook(java);
        libraryManager.addBook(python);
        libraryManager.addBook(react);

        Book searched = libraryManager.searchBook("python");
        System.out.println(searched);
        if(searched != null) {
            System.out.println(
                    "제목: " + searched.getTitle()
                    + ", 저자: " + searched.getAuthor()
                    + ", 가격: " + searched.getPrice()
            );
        }

        Book searched2 = libraryManager.searchBook("java", "john");
        if(searched2 != null) {
            System.out.println(
                    "제목: " + searched2.getTitle()
                    + ", 저자: " + searched2.getAuthor()
                    + ", 가격: " + searched2.getPrice()
            );
        }

        Member member1 = new Member(1, "김일번", List.of(java, python));
        Member member2 = new Member(2, "김이번", List.of(java));
        Member member3 = new Member(3, "김삼번", List.of(react));

        libraryManager.addMember(member1);
        libraryManager.addMember(member2);
        libraryManager.addMember(member3);

        Member searchedId = libraryManager.searchMemberId(1);
        if(searchedId != null) {
            System.out.println(
                    "회원번호 : " + searchedId.memberId()
                    + ", 이름: " + searchedId.name()
                    + ", 대출 목록: " + searchedId.borrowedBooks()
            );
        }

    }
}
