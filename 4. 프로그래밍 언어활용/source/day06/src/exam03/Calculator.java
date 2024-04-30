package exam03;

public interface Calculator {
    // public abstract in add(...);
    int num= 10; // public static final
    public int add(int num1, int num2);
    //무조건적으로 추상메소드를 인식하기 때문에 알아서 public abstract 자동으로 추가 =>다른 접근제어자는 못 씀 !!!!!
    //인터페이스는 추상메소드 형태만 오류가 안 뜸.



}
