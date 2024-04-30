package exam02;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("문장을 입력하세요:");
        String str = sc.nextLine();


       // Pattern p1 = Pattern.compile("[a-zA-Z]"); //대소문자 구분없이 모두 가능
        // a부터 z까지 하나하나 그 문자하나라도 포함돼있으면 뺀다.

        //Pattern p1=Pattern.compile("[a-z]"), Pattern.CASE_INSENSITIVE);
       // Matcher m1 = p1.matcher(str);
       // if (!m1.find()) {
            System.out.println("알바벳이 포함되지 않았습니다.");
        }
    }
//}
