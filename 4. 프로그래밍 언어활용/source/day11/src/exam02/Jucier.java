package exam02;

import java.util.ArrayList;

public class Jucier {
    public static void make(FruitBox<? extends Fruit> box) {
        ArrayList<?> fruits =  box.getItems();
        System.out.println(fruits);
    }
    // 지네릭 메서드, extends만 사용 가능
    //명시한 부분을 미리 쓰면 짧게 쓰기 가능
    public static <T extends Fruit> void make3(FruitBox<T> box) {


    }

        // ? - Apple, Fruit, Object
    public static void make2(FruitBox<? super Apple> box) {
        ArrayList<?> fruits = box.getItems();
        System.out.println(fruits);

    }


}