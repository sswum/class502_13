package exam03;

import static java.lang.annotation.ElementType.*; // <=요렇게 명시하면 ElementType.FIELD => FIELD로 바꿔서 써도 된다.


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({TYPE, METHOD ,FIELD})
@Retention(RetentionPolicy.RUNTIME) //리텐션을 실행과정에 넣었다
public @interface MyAnno {
    int min() default 10; // min() 설정 항목이고 추상메소드 상태로 정의를 내림
    int max() default 100; // max 설정 항목

    String[] names() default {"이름1"};

    String value();


}
