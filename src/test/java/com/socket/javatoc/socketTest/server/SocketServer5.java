//package com.socket.javatoc.socketTest.server;
//
//import java.io.BufferedInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.nio.ByteBuffer;
//import java.nio.ByteOrder;
//
//public class SocketServer5 {
//
//    public static void main(String[] args) throws IOException {
//        SocketServer5 socketServer5 = new SocketServer5();
//        socketServer5.run();
//    }
//
//    public void run() throws IOException {
//
//        BufferedInputStream bis = null;
//        try {
//            int port = 6547;
//            ServerSocket server = new ServerSocket(port);
//
//            while (true) {
//                System.out.println("-------접속 대기중------");
//                Socket socket = server.accept();         // 계속 기다리고 있다가 클라이언트가 접속하면 통신할 수 있는 소켓 반환
//                System.out.println(socket.getInetAddress() + "로 부터 연결요청이 들어옴");
//                InputStream is = socket.getInputStream();
//
//                bis = new BufferedInputStream(socket.getInputStream());
//                byte[] buff = new byte[1024];
//
//                int read = 0;
//                while (true) {
//                    if (socket == null) {
//                        break;
//                    }
//
//                    read = bis.read(buff, 0, 1024);
//
//                    if (read < 0) {
//                        break;
//                    }
//
//
//                    byte[]  tempArr = new byte[5];
//                    System.arraycopy(buff, 0, tempArr, 0, 5);
//                    int aaa = byteArrayToInt(tempArr);
//                    System.out.println(aaa);
////                    System.out.println(new String(tempArr));
////                    recHeaderVO.setSid(new String(tempArr));
//
//                    tempArr = new byte[5];
//                    System.arraycopy(buff, 5, tempArr, 0, 5);
//                    int aaa1 = byteArrayToInt(tempArr);
//                    System.out.println(aaa);
//
//                    tempArr = new byte[5];
//                    System.arraycopy(buff, 10, tempArr, 0, 5);
//                    int aaa2 = byteArrayToInt(tempArr);
//                    System.out.println(aaa);
//
//                    tempArr = new byte[5];
//                    System.arraycopy(buff, 15, tempArr, 0, 5);
//                    int aaa3 = byteArrayToInt(tempArr);
//                    System.out.println(aaa);
//
//                    // status
//                    tempArr = new byte[9];
//                    System.arraycopy(buff, 20, tempArr, 0, 9);
//                    System.out.println(new String(tempArr));
////                    recHeaderVO.setStatus(new String(tempArr));
//
//                    tempArr = new byte[14];
//                    System.arraycopy(buff, 29, tempArr, 0, 14);
//                    long ddd = byteArrayToLong(tempArr);
//                    System.out.println(ddd);
//
//                    sendData(buff, socket);
//                }
//
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
////    public int byteArrayToInt(byte bytes[]) {
////            int byteInt = 0;
////            int lengthDiv = 4;
////            if (lengthDiv==2){
////                byteInt = ((bytes[1] & 0xFF) << 8) | (bytes[0] & 0xFF);
////            }else if (lengthDiv==4){
////                byteInt = bytes[0] & 0xFF |
////                        (bytes[1] & 0xFF) << 8 |
////                        (bytes[2] & 0xFF) << 16 |
////                        (bytes[3] & 0xFF) << 24;
////            }
////            return byteInt;
////    }
//
//    public int byteArrayToInt(byte bytes[]) {
//        return ((((int)bytes[0] & 0xff) << 24) |
//                (((int)bytes[1] & 0xff) << 16) |
//                (((int)bytes[2] & 0xff) << 8) |
//                (((int)bytes[3] & 0xff)));
//    }
//
////    public long byteArrayToLong(byte bytes[]) {
////        long result = 0;
////        for (int i = 7; i >= 0; i--) {
////            result <<= 8;
////            result |= (bytes[i] & 0xFF);
////        }
////        return result;
////    }
//
//    public long byteArrayToLong(byte bytes[]) {
//        return ((long) bytes[7] << 56)
//                | ((long) bytes[6] & 0xff) << 48
//                | ((long) bytes[5] & 0xff) << 40
//                | ((long) bytes[4] & 0xff) << 32
//                | ((long) bytes[3] & 0xff) << 24
//                | ((long) bytes[2] & 0xff) << 16
//                | ((long) bytes[1] & 0xff) << 8
//                | ((long) bytes[0] & 0xff);
//    }
//
//
//
//    public void sendData(byte[] bytes, Socket socket) {
//        try {
//            String fileName = "성공";
//
//            OutputStream os = socket.getOutputStream();
//            int sid = 11111;
//            String sabun = "22222";
//
//            ByteBuffer sendByteBuffer =  ByteBuffer.allocate(15);
//            sendByteBuffer.order(ByteOrder.BIG_ENDIAN);
//
//            byte[] aa = intToByteArray(sid);
//            sendByteBuffer.put(aa);
//            sendByteBuffer.put(new byte[5 - aa.length]);
//
//            sendByteBuffer.put(sabun.getBytes());
//            sendByteBuffer.put(new byte[10 - sabun.getBytes().length]);
//
//            os.write(sendByteBuffer.array());
//            os.flush();
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }
//    }
//
//    public  byte[] intToByteArray(int value) {
//        byte[] byteArray = new byte[4];
//        byteArray[0] = (byte)(value >> 24);
//        byteArray[1] = (byte)(value >> 16);
//        byteArray[2] = (byte)(value >> 8);
//        byteArray[3] = (byte)(value);
//        return byteArray;
//    }
//
//}