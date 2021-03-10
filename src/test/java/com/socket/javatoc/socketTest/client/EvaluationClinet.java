//package com.socket.javatoc.socketTest.client;
//
//import java.io.*;
//import java.net.Socket;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//public class EvaluationClinet {
//    public static void main(String[] args) {
//
//
//        LocalDate localDate = LocalDate.now();
//        String now = localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
//
//        String directoryDt = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        String[] date = directoryDt.split("-");
//
//        StringBuffer fileName = new StringBuffer();
//        fileName.append("SFLCN0101_");
//        fileName.append(now);
//        fileName.append(".dat");
//
//        StringBuffer path = new StringBuffer();
//        path.append("C:/home/wooricard/download/sflcn0101/");
//        path.append(date[0]);
//        path.append("/");
//        path.append(date[1]);
//        path.append("/");
//        path.append(date[2]);
//        path.append("/");
//        path.append(fileName);
//
//
//        File file = new File(String.valueOf(path));
//        try (
//                Socket socket = new Socket("127.0.0.1", 6547);
//                DataOutputStream dout =  new DataOutputStream( new BufferedOutputStream(socket.getOutputStream()));
//                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
//                BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
//        ) {
//            long fileSize = file.length();
//
//            // 전송할 데이터 크기를 미리 전달한다.
//            dout.writeLong(fileSize);
//
//            // 전솔항 파일명 (SFLCN0101_20210125.dat (SFLCN0101_ + "YYYYMMDD" + ".dat"))
//            dout.writeUTF("SFLCN0103_"+now+".dat");
//
//            byte[] b = new byte[10000];
//            int readed = -1;
//            while ((readed = bin.read(b)) > 0) {
//                dout.write(b, 0, readed);
//            }
//            dout.flush();
//            System.out.println("응답 메시지: "+br.readLine());	// 클라이언트 메시지 출력
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//}