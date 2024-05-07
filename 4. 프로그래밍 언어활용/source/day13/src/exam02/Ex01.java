package exam02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Ex01 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("이름1", "이름2", "이름3", "이름3", "이름4", "이름5");
        /*
        names.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {

            }
        }); */
        //위에 식과 아래식은 같은 것인데 람다식으로 바꿔서 간결하게 쓴 것.

        names.forEach(s-> System.out.println(names));

    }
}
