package exam01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// invocationhandler 구현을 위해서 코딩
public class CalculatorHandler implements InvocationHandler {

    @Override //여기 밑에 invoke 메소드로 유입되고 호출하고
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("유입이당~");

        return null;

    }
}
