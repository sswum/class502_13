package exam02;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex01 {
    public static void main(String[] args) {

        String str = "I Like java and javascript";
        Pattern p1 = Pattern.compile("java");
        Matcher m1 = p1.matcher(str);
        System.out.println(m1.find()); //java
        System.out.println(m1.group());// 패턴에 일치하는 문자열 값이 나옴
        System.out.println(m1.find());
        System.out.println(m1.group());  //find는 찾는 것. group은 패턴에 일치하는 문자열 값이 나옴.
        System.out.println(m1.find());




    }
}
