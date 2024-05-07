package exam01;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        String[] fruits = {"Apple", "Orange", "Grape", "Melon", "Banana"};

        /** 1.중복제거
         * 2.문자열 길이 변경
         * 3.int[] 배열로 변경
         */

        Arrays.stream(fruits)
                .distinct()
                .mapToInt(String::length) //문자열을 정수로 바꿔준다.
                .toArray(); //문자를 배열로 바꿔준다.

        //줄개행해서 하면 명확하게 뭘 하는지 알 수 있음.

    }
}
