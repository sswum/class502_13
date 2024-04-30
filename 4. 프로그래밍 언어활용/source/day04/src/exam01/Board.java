package exam01;

public class Board {
//    private static Board instance = new Board(); //클래스 로드 시점부터 객체 생성

    private static Board instance;

    static {
        System.out.println("객체와 상관없이 생성");
    }
    private Board() {}   //통제를 시킴 ,외부 접근 안됨 ,내부 접근만 됨

    public static Board getInstance() {
        if (instance == null) { //필요한 시점 최소 1번만 생성
            instance = new Board();
        }
        return instance; // <=인스턴스 메소드라 객체와 상관없이 쓸 수 있는 static사용
    }

            //▲싱글톤패턴이다.
}
