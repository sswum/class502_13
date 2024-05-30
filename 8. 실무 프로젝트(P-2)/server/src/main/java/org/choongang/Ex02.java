package org.choongang;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Ex02 { //동시 다발적으로 메세지를 보낼 수 있는지 체크해보겠다
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 9999);
        Scanner sc = new Scanner(System.in);


        try (DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
            while (true) {
                System.out.println("메세지: ");
                //입력받으면 바로 서버쪽으로 보낼거임!
                String message = sc.nextLine();
                dos.writeUTF(message);

            }  //try
        } //while

    }
}


