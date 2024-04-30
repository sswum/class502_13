package exam03;

public class Ex01 {
    public static void main(String[] args) {
        Resources res = new Resources();
         Resources2 res2 = new Resources2();
        try (res; res2) {  //다형성으로 인해서 try를 나눠서 이렇게 쓴것임.

            //res가 AutoCloseable 인터페이스 구현 객체인지 체크 -> close() 메서드 자동 호출

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
