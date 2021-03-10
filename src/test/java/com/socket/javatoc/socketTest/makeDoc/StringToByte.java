//package com.socket.javatoc.socketTest.makeDoc;
//
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.Socket;
//
//@Slf4j
//public class StringToByte {
//
//    @Test
//    public void 클라이언트() throws IOException {
//        File file = new File("C:/Users/hsnym/Desktop/TEST1/SFLCN0101_20210125.dat");
//        String data = "asdasdasdasdasd";
//        String fileName = "SFLCN0101";
//        try (
//                Socket socket = new Socket("192.168.0.4", 18501);
//                OutputStream os = socket.getOutputStream();
//        ) {
//
////            byte[] byteArr = data.getBytes("UTF-8");
//            byte[] fileNames = fileName.getBytes("UTF-8");
//            os.write(fileNames);
//            os.flush();
//
//            InputStream is = socket.getInputStream();
//            byte[] bytes = new byte[1024];
//            int readByteCount = is.read(bytes);
//            String message = new String(bytes, 0, readByteCount, "UTF-8");
//            System.out.println("[데이터 받기 성공]: " + message);
//
////            System.out.println("응답 메시지: "+br.readLine());	// 클라이언트 메시지 출력
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//
