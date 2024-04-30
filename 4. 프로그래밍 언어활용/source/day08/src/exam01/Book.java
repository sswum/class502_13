package exam01;

public class Book extends Object{
    private int isbn;
    private String title;

    public Book(int isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    private String author;
}
