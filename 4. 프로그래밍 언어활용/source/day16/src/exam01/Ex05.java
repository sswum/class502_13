package exam01;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex05 {
    public static void main(String[] args) {
        String[] names= {"이름1","이름2","이름3","이름4","이름5"};
        List<String> namesList = Arrays.stream(names)
                //.collect(Collectors
        .toList(); //위에 내용 쓰지 않고 toList로 간단하게 써서 표현 가능
        //for문 추가 없이 리스트를 써서 바로 바꿔줄 수 있음
        System.out.println(namesList);
        //결과값은 리스트 형태로 나옴.
        Set<String> namesSet = Arrays.stream(names)
                .collect(Collectors.toSet()); //중복제거라고 하셨는데 뭘 중복제거한거지?
        System.out.println(namesSet);

    }
}
