package com.socket.javatoc.socketTest.server;

import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

@Configuration
public class SocketServer {

    public static void main(String[] args) throws IOException {
        SocketServer socketServer = new SocketServer();
        socketServer.run();
    }

    public void run() throws IOException {
        try {
            int port = 18501;
            ServerSocket server = new ServerSocket(port);

            while (true) {
                System.out.println("-------접속 대기중------");
                Socket socket = server.accept();         // 계속 기다리고 있다가 클라이언트가 접속하면 통신할 수 있는 소켓 반환
                System.out.println(socket.getInetAddress() + "로 부터 연결요청이 들어옴");
                InputStream is = socket.getInputStream();
                byte[] byteArr = new byte[1024];
                int readByteCount = is.read(byteArr);
                if (readByteCount > 0) {
                    System.out.println("클라이언트로 부터 데이터 수신");
                    String data = new String(byteArr, 0, readByteCount, "UTF-8");
                    System.out.println("[데이터 받기 성공]: " + data);
                    sendData(byteArr, socket);
                }
                System.out.println("****** 재전송 완료 ****");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendData(byte[] bytes, Socket socket) {
        try {
            String fileName = "성공";
            byte[] fileNames = fileName.getBytes("UTF-8");
            OutputStream os = socket.getOutputStream();
//            os.write(bytes);
            os.write(fileNames);
            os.flush();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

}