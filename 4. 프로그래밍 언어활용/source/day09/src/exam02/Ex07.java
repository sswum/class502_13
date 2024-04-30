package exam02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex07 {
    public static void main(String[] args) {
        String str = "java one\njava two\njava three";

        System.out.println(str);

        Pattern p1 = Pattern.compile("^\\w+\\s", Pattern.MULTILINE);
        //여러줄 걸쳐 패턴 체크
     //   Pattern p1 = Pattern.compile("^\\w+\\s");
        Matcher m1 = p1.matcher(str);
        if (m1.find()) {
            System.out.println(m1.group());
        }
        if (m1.find()) {
            System.out.println(m1.group());
        }
        if (m1.find()) {
            System.out.println(m1.group());
        }
    }
}
