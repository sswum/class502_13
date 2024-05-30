package org.choongang;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 9999);
        Scanner sc = new Scanner(System.in);

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        try (DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
            while (true) {
                System.out.println("메세지: ");
                //입력받으면 바로 서버쪽으로 보낼거임!
                String message = sc.nextLine();

                SocketData data = new SocketData("user01", "all", message, LocalDateTime.now());

                dos.writeUTF(json);

            }  //try
        } //while

    }
}
