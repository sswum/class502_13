package exam02;

import java.util.Arrays;
import java.util.List;

public class Ex04 {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "orange", "mango", "melon");
        fruits.stream().map(s -> "*" + s + "*")
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}

//데이터가 뭐든간에 스트림 객체만 된다면 동일한 형태로 나올 수 있다.
