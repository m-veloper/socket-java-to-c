//package com.socket.javatoc.socketTest.server;
//
//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class SocketServer3 {
//
//    public static void main(String... args) {
//        // from 우리카드
//        String fileName = "New.txt";
//        String reName = "";
//        String path = "c:/Users/hsnym/Desktop/wc/receive/";
//        String fullPath = path + fileName;
//        ExecutorService service = Executors.newSingleThreadExecutor();
//        ExecutorService clientService = Executors.newFixedThreadPool(10);
//        service.submit(() -> {
//
//            try (ServerSocket ss = new ServerSocket(6547)) {
//                while (true) {
//                    clientService.submit(() -> {
//                        try (
//                                Socket socket = ss.accept();
//                                DataInputStream bin = new DataInputStream(socket.getInputStream());
//                                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
//                                BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(new File(fullPath)));
//                        ) {
//                            System.out.printf("클라이언트 접속 : %s%n", socket.getInetAddress());
//                            long size = bin.readLong();                 // 전송받을 데이터의 총 크기
//                            String title = bin.readUTF();               // 전송받은 파일이름
//                            String[] nema = title.split("_");    // 파일이름 분기
//                            //                        reName = nema[0];
//                            System.out.println(size);
//                            int readed = 0;
//                            byte[] b = new byte[10000];
//                            while (true) {
//                                readed = bin.read(b);
//                                bout.write(b, 0, readed);
//                                size -= readed;
//                                if (size == 0) {
//                                    break;
//                                }
//                            }
//                            System.out.println("파일 전송 완료!!");
//                            bw.write("파일 다 받았어요\n");
//                            bw.flush();
//
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    });
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//    }
//}