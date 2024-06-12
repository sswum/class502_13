package global;

public class Mailer {
    //인자 캡쳐=단위 테스트를 실행하다보면 모의 객체를 호출할 때 사용한 인자를 검증해야 할 때를 이름
    public void send(String email) {
        System.out.println("메일 전송!");
    }

}
