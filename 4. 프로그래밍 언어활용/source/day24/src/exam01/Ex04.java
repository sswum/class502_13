package exam01;

public class Ex04 {
    public static void main(String[] args) {
        Runnable r1 = () -> {
            for (int i = 0; i < 300; i++) {
                System.out.print("-");

                for (long j = 0; j < 100000000L; j++);
            }
        };

        Runnable r2 = () -> {
            for (int i = 0; i < 300; i++) {
                System.out.print("=");

                for (long j = 0; j < 100000000L; j++);
            }
        };

        Thread th1 = new Thread(r1);
        Thread th2 = new Thread(r2);

        th1.setPriority(Thread.MAX_PRIORITY); // 10
        th2.setPriority(Thread.MIN_PRIORITY); // 1

        System.out.printf("th1:%d, th2:%d%n", th1.getPriority(), th2.getPriority());

        th1.start(); // th1 쓰레드
        th2.start(); //th2 쓰레드

        try {
            th1.join(); // 현재 진행중인 쓰레드가 다 끝날 때까지
            th2.join(); // 메인쓰레드가 대기했다가 다 끝나면 메인쓰레드도 종료
        } catch (InterruptedException e) {

        };

        System.out.println("작업종료!"); //main 쓰레드
    }
}