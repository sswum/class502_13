package exam02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Ex01 {
    public static void main(String[] args) throws Exception{
        Class clazz = Member.class; // member의 클래스 클래스를 쓴

        //생성자 하나 만듦
        Constructor constructor = clazz.getDeclaredConstructor()[0];
        Object obj = constructor.newInstance();
        //Class 클래스만 있으면 메소드가 뭐가 정의됐는지 확인이 가능

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName();
        }
    }
}
