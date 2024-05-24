package exam03;

public class Ex01 {
    public static void main(String[] args) {

        Ex01_1 th1 = new Ex01_1();
        Thread th2 = new Thread(new Ex01_2());

        th1.start();
        th2.start();

        System.out.println("메인쓰레드에서 실행!");
    }
}

class Ex01_1 extends Thread { //본인이 상속받은 쓰레드로 바로 쓰기때문에 얘는 밑에꺼랑 관계없음.
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName());

        }
    }
}


class Ex01_2 implements Runnable {
    @Override
    public void run() {                       //run이 실행될 때 쓰레드
        Thread th = Thread.currentThread(); //runnable은 쓰레드를 상속 받은 게 아니기 때문에 커렌트쓰레드를 써야함.
        for (int i = 0; i < 5; i++) {
            System.out.println(th.getName());
        }
    }
}



