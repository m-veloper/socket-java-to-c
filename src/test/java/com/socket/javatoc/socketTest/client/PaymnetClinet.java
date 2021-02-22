package com.socket.javatoc.socketTest.client;

import java.io.*;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PaymnetClinet {
    public static void main(String[] args) {

        String path = "C:/Users/hsnym/Desktop/wc/test/SFLCN0205/SFLCN0205.dat";
        LocalDate localDate = LocalDate.now();
        String now = localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        File file = new File(path);
        try (
                Socket socket = new Socket("127.0.0.1", 6547);
                DataOutputStream dout =  new DataOutputStream( new BufferedOutputStream(socket.getOutputStream()));
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
        ) {
            long fileSize = file.length();

            // 전송할 데이터 크기를 미리 전달한다.
            dout.writeLong(fileSize);

            // 전솔항 파일명 (SFLCN0101_20210125.dat (SFLCN0101_ + "YYYYMMDD" + ".dat"))
            dout.writeUTF("SFLCN0205_"+now+".dat");

            byte[] b = new byte[10000];
            int readed = -1;
            while ((readed = bin.read(b)) > 0) {
                dout.write(b, 0, readed);
            }
            dout.flush();
            System.out.println("응답 메시지: "+br.readLine());	// 클라이언트 메시지 출력
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}