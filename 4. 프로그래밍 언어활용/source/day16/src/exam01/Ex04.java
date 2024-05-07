package exam01;

import java.util.Arrays;

public class Ex04 {
    public static void main(String[] args) {
        int[] scores = {67, 80, 100, 98, 76, 56};

        int max = Arrays.stream(scores).reduce((a,b)-> {
                    System.out.printf("a=%d, b=%d%n", a, b);

                    int m = a > b ? a : b;
                    return m;
                })
                .getAsInt();
        System.out.println(max);
    }
}//sout의 max값은 최대값이 100이 나옴
//위에 a와 b의 비교값은 둘이 비교해서 큰게 다음 비교값으로 넘어가고 넘어가고 해서 비교 하는것인듯?
//반환값이 첫번째 매개변수로 다시 돌아감.

