package exam04;

public interface Seller {
    void sell(); //앞에 public abstract 가 자동적으로 붙는다 추상메소드 정의
    default void order() {
        System.out.println("Seller 에서 주문");

    }
}
