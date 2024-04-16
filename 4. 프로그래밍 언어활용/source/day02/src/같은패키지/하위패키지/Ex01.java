package 같은패키지.하위패키지;

import 같은패키지.A;
import 다른패키지.B;

public class Ex01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        b.print();
    }
}