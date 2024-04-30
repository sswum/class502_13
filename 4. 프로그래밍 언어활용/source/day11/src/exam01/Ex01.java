package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.setItem(new Apple());

       // appleBox.setItem(new Grape); //애플로 이미 한정해버려서 다른 자료형을 허용 안함 ,그래서 타입안정성 확보
        Apple apple = appleBox.getItem(); //형변환없이 바로 가져오면 됨.

        System.out.println(appleBox); //appleBox.toString();


    }
}
