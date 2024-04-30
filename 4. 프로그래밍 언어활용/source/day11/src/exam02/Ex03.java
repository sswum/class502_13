package exam02;

public class Ex03 {
    public static void main(String[] args) {
        FruitBox<Toy> toyBox = new FruitBox<>();
        toyBox.add(new Toy());
        //Jucier.make(toyBox); //사과,포도,과일만 형변환이 가능 프룻이 아니라 토이박스 에러 ,=>상한제한
    }
}
