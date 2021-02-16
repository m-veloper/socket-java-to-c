package com.socket.javatoc.socket.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketServer {

    public static void main(String[] args) throws IOException{
        SocketServer socketServer = new SocketServer();
        socketServer.run();
    }

    public void run() throws IOException{
        try {
            int port = 18501;
            ServerSocket server = new ServerSocket(port);

            while(true){
                System.out.println("-------접속 대기중------");
                Socket socket = server.accept();         // 계속 기다리고 있다가 클라이언트가 접속하면 통신할 수 있는 소켓 반환
                System.out.println(socket.getInetAddress() + "로 부터 연결요청이 들어옴");
                InputStream is = socket.getInputStream();
                byte[] bytes = new byte[1024];

                int readByteCount = is.read(bytes);

                if (readByteCount > 0) {
                    System.out.println("클라이언트로 부터 데이터 수신");
                    sendData(bytes, socket);
                }
                System.out.println("****** 재전송 완료 ****");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendData(byte[] bytes, Socket socket){
        try {
            Object obj = null;
            ByteArrayInputStream bis = new ByteArrayInputStream (bytes);
            ObjectInputStream ois = new ObjectInputStream (bis);
            obj = ois.readObject();

            System.out.println(obj.toString());


            OutputStream os = socket.getOutputStream();
            os.write(bytes);
            os.flush();
        } catch(Exception e1){
            e1.printStackTrace();
        }
    }
}