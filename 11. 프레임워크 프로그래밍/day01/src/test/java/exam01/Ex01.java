package exam01;

import exam01.config.AppCtx;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    @Test
    void test1() {
        //어떤 객체를 가져올 지 해당(AppCtx).class 해서 조회
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class); //스프링 컨테이너 객체

        //어떤 객체를 가져올 지 알려줘야 한다. ,get bean을 이용해 가져온다. ("클래스명","클래스명.class");
        Greeter g1 = ctx.getBean("greeter", Greeter.class);
        g1.hello("이이름"); //직접 내가 생성한 게 아니라 가져와서 만들어줌.

        Greeter g2 = ctx.getBean("greeter", Greeter.class);
        g2.hello("김이름");

        System.out.println(g1 == g2);

        ctx.close();
    }
@Test
    void test2() {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

    //같은 객체를 생성하는 일은 흔치 않다.
    //싱글톤이라서 쓸 수 있다.
    //동일한 객체일 경우 정확히 바꿔서 지정해주는 게 좋다.
    //싱글톤으로 기본 관리하므로 객체가 한 개만 있는 경우가 많다.
    //Class 클래스만 있어도 찾는다!
    Greeter g1 = ctx.getBean(Greeter.class);
    g1.hello("이이름");

    ctx.close();

}

}
