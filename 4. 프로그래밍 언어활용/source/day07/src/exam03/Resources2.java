package exam03;

public class Resources2 implements  AutoCloseable{
    @Override
    public void close() throws Exception { // 오른쪽 마우스 =>Generate => imple 메쏘드 하면 왼쪽에 public~Exception 자동생성
        System.out.println("자원해제2!!");

    }
}
