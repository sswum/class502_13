package exam03;

public class Ex02 {
    public static void main(String[] args) {
        Animal[] animals = {new Human(), new Bird(), new Tiger()};


        for (Animal animal : animals) {  //나오는 값이 휴먼 버드 타이거주소로 맵핑이 돼있다.
            animal.move();
        }
    }
}
