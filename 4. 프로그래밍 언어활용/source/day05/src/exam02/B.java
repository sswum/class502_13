package exam02;

public class B extends A{ // ◀ B가 A를 상속받는 관계로 정의가 된것임

    int numB =20;


    public B() {
        super(); //B클래스에 정의된 A
        System.out.println("B 생성자!");
    }
}
