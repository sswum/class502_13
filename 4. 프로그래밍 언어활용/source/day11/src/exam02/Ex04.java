package exam02;

public class Ex04 {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>();
        appleBox.add(new Apple());
        Jucier.make2(appleBox); // apple, fruit , object

        FruitBox<Fruit> grapeBox = new FruitBox<>();
        //grapeBox.add(new Grape());
     //   Jucier.make2(grapeBox);

    }
}
