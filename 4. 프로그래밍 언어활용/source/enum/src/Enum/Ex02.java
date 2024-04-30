package Enum;

import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args) {


        //문자열을 입력받아서 일치하는 열거 객체를 리턴
   //    Week w3 = Week.valueOf("SUNDAY"); //w3 변수는 Week.SUNDAY 열거 객체를 참조하게 됨.
    //    System.out.println(w3); // SUNDAY

        Week[] w4 = Week.values();
        System.out.println(Arrays.toString(w4));

        for (Week type : Week.values()) {
            System.out.println(type);
        }



    }
}