package exam01;

import config.AppCtx;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex02 {
    @Test
    void test1() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Calculator cal = ctx.getBean(Calculator.class);
        long result = cal.factorial(10L);
        System.out.println(result);

        long result2 = cal.factorial(10L);
        System.out.println(result);

        long result3 = cal.factorial(10L);
        System.out.println(result);

        long result4 = cal.factorial(10L);
        System.out.println(result);




        ctx.close();
    }

    @Test
    void test2() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        Hello hello = ctx.getBean(Hello.class);
        System.out.println(hello.message("이이름"));
        ctx.close();
    }
}
