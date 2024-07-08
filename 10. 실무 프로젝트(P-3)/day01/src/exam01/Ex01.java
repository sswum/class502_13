package exam01;

import java.lang.reflect.Constructor;

public class Ex01 {
    public static void main(String[] args) {
        Class clazz = JoinService.class;

        Constructor[] constructors = clazz.getDeclaredConstructors();
        Constructor c1 = constructors[0];
        Constructor c2 = constructors[1];

//        JoinService s1 = (JoinService) c1.newInstance();
//        JoinService s2 = (JoinService) c2.newInstance("값1",100);

    }
}
