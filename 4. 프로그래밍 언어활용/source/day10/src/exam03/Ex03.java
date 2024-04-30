package exam03;

import java.lang.annotation.Annotation;
import java.util.Arrays;

//@MyAnno(min=10, max=100)  //min ,max를 입력해서 소괄호가 생김 더 정확하게 써줘~의 뜻
public class Ex03 {
    public static void main(String[] args) {


        Class cls = Ex02.class;

        MyAnno anno = (MyAnno) cls.getAnnotation(MyAnno.class);

        int min = anno.min();
        int max = anno.max();
        System.out.printf("min=%d, max%d%n", min, max);

        String[] names = anno.names();
        System.out.println(Arrays.toString(names));

        String value = anno.value();
        System.out.println(value);

    }
}