package exam02;

import java.util.ArrayList;

public class FruitBox<T> {
    private ArrayList<T> items = new ArrayList<>();

    public void add(T fruit) {
        items.add(fruit);

    }
    public ArrayList<T> getItems() {
        return items; //arraylist여러개의 과일을 담아둘수있는바구니라 이해하기
    }


}
