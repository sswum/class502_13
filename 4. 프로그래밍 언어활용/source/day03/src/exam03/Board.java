package exam03;

public class Board {
   private static Board instance = new Board();

    private Board() {}

    public static Board getInstance() {
        return instance;

        //객체랑 상관없이 static 써줘야함.
        //static method는 this가 없음







    }

}
