package exam01;

public class Q2 {   public static void main(String[] args) {

    for (int i = 1; i <= 40; i++) {
        int roomN=i % 10; //나누는 수가 작은게 반복되는
        System.out.printf("학생%d, 방번호 %d번%n", i, roomN);

    }

}
}

