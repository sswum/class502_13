package exam02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex02 {
    public static void main(String[] args) {

        String str = "java";
        Pattern p1 = Pattern.compile(".*java.*");
        Matcher m1 = p1.matcher(str);
        boolean match = m1.matches();
        System.out.println(match);  // 정확하게 패턴 일치해야 돼서 I love java에서 java만 남겨두니까 true나옴
    }
}
