package exam04;

public class Book {
    private int isbn; //도서 번호

    public Book(int isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    private String title; // 도서명
    private String author; // 저자
}
