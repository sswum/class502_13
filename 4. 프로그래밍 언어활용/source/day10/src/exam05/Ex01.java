package exam05;

public class Ex01 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<Apple>();
        appleBox.setItem(new Apple());

        Apple apple = appleBox.getItem(); // 형변환 할 것도 없고 타입안정성 확보를 위해 도입됨
                                        // 위에 애플을 다 명시해서 써줌
        System.out.println(apple.get());
    }
}
