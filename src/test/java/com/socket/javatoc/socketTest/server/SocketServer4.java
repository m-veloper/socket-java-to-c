package com.socket.javatoc.socketTest.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer4 {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(6547)) {
            msg();
            while (true) {
                try(
                    Socket socket = ss.accept();
                    DataInputStream bin = new DataInputStream(socket.getInputStream());
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(new File("c:/Users/hsnym/Desktop/TEST1/" + System.currentTimeMillis() + ".txt")));
                    ) {
                    System.out.printf("클라이언트 접속 : %s%n", socket.getInetAddress());
                    long size = bin.readLong();        // 전송받을 데이터의 총 크기
                    String title = bin.readUTF();        // 전송받을 데이터의 총 크기
                    System.out.println(size);
                    int readed = 0;
                    byte[] b = new byte[10000];
                    while (true) {
                        readed = bin.read(b);
                        bout.write(b, 0, readed);
                        size -= readed;
                        if (size == 0) {
                            break;
                        }
                    }
                    System.out.println("파일 전송 완료!!");
                    bw.write("파일 다 받았어요\n");
                    bw.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                msg();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void msg() {
        System.out.println("접속대기중");
    }
}