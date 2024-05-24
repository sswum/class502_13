package exam02;

public class Board {
    private static Board instance;

    private Board() {}

    public static Board getInstance() {
        synchronized (Board.class) {
            if (instance == null) {
                if (instance instanceof Board) {
                   instance = new Board();

                }
            return instance;
        }
    }

}

