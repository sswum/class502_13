package exam01;

import javax.swing.*;

public class Ex06 {
    public static void main(String[] args) throws InterruptedException {
        Thread th=new Thread(() -> {
        String message = JOptionPane.showInputDialog("메세지 입력");
            System.out.println(message);
        });
th.start(); //쓰게 되면 둘이 따로 쓰게된다.
            //하나는 블락킹 되고 하나는 따로 분리 돼서 사용하고


        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            Thread.sleep(1000);

        }
    }
}
