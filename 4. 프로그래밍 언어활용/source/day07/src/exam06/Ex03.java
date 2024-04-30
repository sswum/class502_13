package exam06;

public class Ex03 {
    public static void main(String[] args) {
        Book b1= new book(1000, "책1", "저자1");
        Book b2 = new book(1000, "책1","저자1");
        System.out.println("b1==b22: %s%n", b1 == b2);
        System.out.println();
    }
}
