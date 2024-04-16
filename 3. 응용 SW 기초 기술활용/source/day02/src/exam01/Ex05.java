package exam01;

public class Ex05 {
    public static void main(String[] args) {
//    int total= 0 ;
//    int num= 0;
int total= 0 , num = 0;  //초기값
//한꺼번에 선언이 가능하지만 같은 자료형이어야한다.

        while(num<=100) { // 조건식 - 반복을 멈추는 조건
            total += num; //total = total +num;
            num++;  //num = num+1 // 증감식
        }
        System.out.println("합계:"+ total);
    }
}
