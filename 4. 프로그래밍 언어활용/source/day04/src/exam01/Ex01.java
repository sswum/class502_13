package exam01;

public class Ex01 {
    public static void main(String[] args) {
       Board b1 = Board.getInstance();
        Board b2 = Board.getInstance();  //통제 됐더니 에러코드 뜸 그래서 주석처리


        System.out.println(b1 == b2);
        System.out.println("b1주소:"+System.identityHashCode(b1));
        System.out.println("b2주소:"+System.identityHashCode(b2));
    }
}
