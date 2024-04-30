package exam02;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 포함하여 입력:");
        String str = sc.nextLine();
        System.out.println("숫자만 입력:");

      //  Pattern p1 = Pattern.compile("[0123456789]"); //숫자 포함

      //  Pattern p1 = Pattern.compile("\\d"); // 역슬래시를 두개이상 입력해야 숫자로 인식안함 \\d -> \d 하나로 인식
      //  Pattern p1= Pattern.compile("[^0-9]"); // 숫자가 아닌 문자 => ^(꺽새)는 부정
        Pattern p1 = Pattern.compile("\\D"); // 숫자를 제외한 모든 문자 한개
        Matcher m1 = p1.matcher(str);
        if (m1.find()) {
            System.out.println("숫자만 입력하세요.");
        }

       /* if (!m1.find()) {
            System.out.println("숫자를 포함하여 입력하세요.");

        }*/
    }
}
