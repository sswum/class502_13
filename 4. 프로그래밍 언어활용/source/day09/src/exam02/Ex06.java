package exam02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex06 {
    public static void main(String[] args) {
        String str = "java I like java and javascript ";
    //    Pattern p1 = Pattern.compile("\\bjava\\b");
        //자바 두개만 인식하고 javascript는 java사이에 공백이 없어서 인식 못함
        Pattern p1 = Pattern.compile("\\bjava\\B"); // javascript의 java찾는문구

        Matcher m1 = p1.matcher(str);
        if (m1.find()) {
            System.out.println(m1.group());//첫번째 자바
        }
        if (m1.find()) {
            System.out.println(m1.group()); // 두번째 자바 (i like java의 java)

        }
        m1.find();
        System.out.println(m1.group());
    }
}