package exam01;

public class Ex09 {
    public static void main(String[] args) {
        long num1 = 1000000000L; //8
        double num2 = num1; //정수 -> 실수 : 자동 형변환(묵시적 형변환) -8

        float num3 = num1;  // 모든 실수는 정수보다 표현범위가 넓기때문에 식을 저렇게 넣기가능

            double num4=0.0;

        for (int i = 0; i < 1000; i++) {
            num4+=0.1;
        }

        System.out.println(num4);
    }


}
