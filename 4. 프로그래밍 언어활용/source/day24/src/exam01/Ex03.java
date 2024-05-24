package exam01;

public class Ex03 {
    public static void main(String[] args) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {

            }
        };
        Thread th = new Thread(runnable);

    }
}
