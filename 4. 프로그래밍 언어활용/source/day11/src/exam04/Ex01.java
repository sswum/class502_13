package exam04;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex01 {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();

        names.add("이름1");
        names.add("이름2");
        names.add("이름3");
        names.add("이름4");
        names.add("이름5");
//        System.out.println(names); // names.toString(); ->담긴값을 확인할 수 있도록 재정의
//추가한 순서대로 값이 바껴서 나온다 순서유지가 된다.
        for (int i = names.size() -1; i >= 0; i--) {
            names.remove(i);
        }



        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            System.out.println(name);
        }


    }
}
