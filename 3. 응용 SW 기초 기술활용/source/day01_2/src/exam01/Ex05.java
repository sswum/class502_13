package exam01;

public class Ex05 {
    public static void main(String[] args) {
        int num1 = 10;
        num1 = 20;
        final int num2 = 30;
//        num2 = 40;   두번째 대입은 안됨

        final int num3;
        num3= 30;
//        num3 = 40;

        System.out.println(num3);

    }
}

