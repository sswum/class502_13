package org.choongang;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.logging.SocketHandler;

public class Server {
    //쓰레드풀을 얘기하믄서 있던 내용 지우고 다시 뭘 만들기!
    private ServerSocket serverSocket;
    private ExecutorService threadPool;
    private ObjectMapper om;  // 잭슨을 ->자바로 자바를 -> 잭슨으로 해주는
    private Map<String, Socket> clients; //접속한 사용자(소켓)


    public Server() {
        try {
            serverSocket = new ServerSocket(9999);

        } catch (IOException e) {
            e.printStackTrace();
        }

        threadPool = new ThreadPoolExecutor(2, 100, 120L, TimeUnit.SECONDS, new SynchronousQueue<>() {
        });

        om = new ObjectMapper();
        om.registerModule(new JavaTimeModule()); //자바타임 모듈 넣음
        //자바 표준 권고안 =>? 310번...

        clients = new HashMap<>();


    }

    public void start() {

        while (true) {
            try {
                Socket socket = serverSocket.accept();

                SocketHandler handler = new SocketHandler(socket);

                //수신 처리
                handler.input(data -> {
                    SocketData sData = toObject(data);
                    String from = sData.getFrom(); //보낸사람
                    if (!clients.containsKey(from)) {
                        clients.put(from, socket);
                        //최초 사용자일경우 소켓을 등록한다!

                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private SocketData toObject(String json) {
        SocketData data = null;
        try {
            data = om.readValue(json, SocketData.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return data;

    }

    private String toJSon(SocketData sData) {
        //자바타입을 제이슨 형태로 바꿔주는 메소드 작성!
        String data = null;

        try {
            data = om.writeValueAsString(sData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return data;
    }

    class SocketHandler {
        private Socket socket;

        public SocketHandler(Socket socket) {
            this.socket = socket;

        }
        // ▼ 밑에 수신과 전송을 같이 만들어서 동시다발적으로 데이터연결 받겠다

        //수신처리

        public void input(Consumer<String> handler) {
            threadPool.execute(() -> {
                try (DataInputStream dis = new DataInputStream(socket.getInputStream())) {
                    while (true) {

                        if (socket == null || handler == null) {
                            Thread.currentThread().yield(); //없을 때 다른 작업쓰레드에게 넘겨서 양보해서 작업
                            break;  //소켓이랑 핸들러가 공백이면 멈춰라!
                        }
                        String data = dis.readUTF();
                        //넘어오는 데이터를 넘겨준다
                        handler.accept(data);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                //쓰레드풀 익스큐트는 병렬적으로 작업이 전송수신이 되도록함.
            });
        }

        //전송처리
        public void output(Socket toSocket, SocketData data) {
            if (toSocket == null || toSocket.isClosed() || data == null) {
                return;
            }

            threadPool.execute(() -> {
                try (DataOutputStream dos = new DataOutputStream(toSocket.getOutputStream())) {

                    String json = toJSon(data);
                    dos.writeUTF(json);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        public void send(String to, SocketData data) {
            if (to.equals("all")) {
                //전체 전송
                clients.values().forEach(s -> output(s, data));

            } else {
                //특정 사용자 전송
                Socket s = clients.get(to);
                if (s != null) {
                    output(s, data);

                }
            }
        }
    }
}