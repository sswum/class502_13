package exam01;

import java.util.ArrayList;

public class Ex03 {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1000, "책1", "저자1"));
        books.add(new Book(1000, "책2", "저자2"));
        books.add(new Book(1000, "책3", "저자3"));
        books.add(new Book(1000, "책4", "저자4"));
        books.add(new Book(1000, "책5", "저자5"));

        for (Book book : books) {
            System.out.println(book);
        } //향상된 FOR문  =>이게 더 간결하고 쓰기 좋다.
        System.out.println("-------------");
        books.forEach(System.out::println);
    } //foreach 문

}
