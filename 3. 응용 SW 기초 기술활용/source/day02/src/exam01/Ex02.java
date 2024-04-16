package exam01;

public class Ex02 {
    public static void main(String[] args) {
        int num = 10;
        boolean result = num++ > 10 && (num = num + 10) > 15;
        //num++에서 이미 10값이기 때문에 false나옴  &&라 하나만 조건 거짓이라 바로 다음거를 체크안함
        System.out.println(result);
        System.out.println(num);

        boolean result2 = !result; ///true ->false
        System.out.println(result2);

    }
}
