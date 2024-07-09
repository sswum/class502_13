package exam01;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class Ex01 {
    @Test
    void test1() {
        //얘는 범용적인 값으로 반환하기 때문에 Object를 쓴 것
        Object obj = Proxy.newProxyInstance(
                Calculator.class.getClassLoader(),
                new Class[]{Calculator.class},
                new CalculatorHandler(new RecCalculator())
        );

        Calculator cal = (Calculator) obj;
        long result = cal.factorial(10L);
        System.out.println(result);
    }
}
