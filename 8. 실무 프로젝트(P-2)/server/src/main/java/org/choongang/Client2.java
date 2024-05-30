package org.choongang;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 9999);
        OutputStream out = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);
        //클라이언트에서 서버쪽으로 데이터 전송!(동적 포트를 통해서)
        //아웃풋스트림에 통해서 쓰는 방법 보여주심

        dos.writeUTF("안녕하세요!");
        //서버가 동적포트를 이용해서 이 문자열을 보냅니당!

    }
}
