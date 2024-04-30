package exam02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex08 {
    public static void main(String[] args) {
        String str = "AAA\n1234\nBBBB\n456\nCCCC\nDDDDDDDD";
        // 4글자로 구성된 단어
      //  Pattern p1 = Pattern.compile("\\b....\\b");
        Pattern p1 = Pattern.compile("\\b.{1,4}\\b");
        Matcher m1 = p1.matcher(str);

        while(m1.find()) {
            System.out.println(m1.group());

        }

     /*   if (m1.find()) {
            System.out.println(m1.group()); //1234

        }
        if (m1.find()) {
            System.out.println(m1.group());// BBBB =>처음에 제대로 안 나와서 \n줄개행을 중간중간 넣음
        }*/
    }
}
