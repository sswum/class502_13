package exam01;

import java.util.Random;

public class Ex03 {
    public static void main(String[] args) {
        Random rand = new Random();
        rand.ints().limit(6).forEach(System.out::println);
        //갯수를 여러개로 제한하겠다
    }
}
