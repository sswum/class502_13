package exam01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// invocationhandler 구현을 위해서 코딩
public class CalculatorHandler implements InvocationHandler {

    private Object obj; //생성자 obj

    public CalculatorHandler(Object obj) {
        this.obj = obj;

    }

    @Override //여기 밑에 invoke 메소드로 유입되고 호출하고
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long stim = System.nanoTime(); //추가 기능 - 공통 기능, 공통 관심사
        try {
            Object result = method.invoke(obj, args); //Calculator factorial 호출 /핵심 기능을 대신 수행


            return result;

        } finally {
            long etime = System.nanoTime();  //추가 기능 - 공통 기능, 공통 관심사
            System.out.printf("걸린시간: %d%n", etime, stim);
        }
    }
}
