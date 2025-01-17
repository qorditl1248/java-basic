package dev.study.exam2;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager {

    private final List<Book> books = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();

    // 도서 추가
    public void addBook(Book book) {
        books.add(book);
    }

    // 도서 검색 - 제목
    public Book searchBook(String title) {
        for(Book book : books) {
            if(book.getTitle().equalsIgnoreCase(title)) { // equalsIgnoreCase - 대소문자 상관없이 확인
                return book;
            }
        }
        System.out.println(title + "라는 책을 찾을 수 없습니다.");
        return null;
    }

    // 도서 검색 - 제목 + 저자
    public Book searchBook(String title, String author) {
        for (Book book : books) {
            if(book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)) {
                return book;
            }
        }
        System.out.println("제목인" + title + "과 저자가" + author + "인 책을 찾을 수 없습니다.");
        return null;
    }

    // 회원 추가
    public void addMember(Member member) {
        members.add(member);
    }

    // 회원 검색 - 회원 ID
    public Member searchMemberId(int searchId) {
        for (Member member : members) {
            if(member.memberId() == searchId) {
                return member;
            }
        }
        System.out.println("해당 아이디는 없는 아이디입니다.");
        return null;
    }

}
