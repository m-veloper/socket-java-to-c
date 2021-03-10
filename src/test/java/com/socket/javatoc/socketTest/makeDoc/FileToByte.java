//package com.socket.javatoc.socketTest.makeDoc;
//
//import org.junit.jupiter.api.Test;
//
//import java.io.*;
//import java.net.Socket;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//public class FileToByte {
//
//    @Test
//    public void 클라이언트() throws IOException {
//        File file = new File("C:/Users/hsnym/Desktop/wc/send/SFLCN0101_20210214.dat");
//        try (
//                Socket socket = new Socket("192.168.0.4", 6547);
//                DataOutputStream dout =  new DataOutputStream( new BufferedOutputStream(socket.getOutputStream()));
//                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
//                BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
//        ) {
//            long fileSize = file.length();
//            dout.writeLong(fileSize);								// 전송할 데이터 크기를 미리 전달한다.
//            dout.writeUTF("SFLCN0101");
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
//    }
//
//    @Test
//    public void 전문만들기() throws IOException {
//        String saveStr =
//                "projectName=org.eclipse.ui.examples.javaeditor\n" +
//                        "name=Java Editor\n" +
//                        "description=The Java Editor example demonstrates the standard features available for custom text editors.  It also shows how  to register an editor for a file extension (in this case .jav) and how to define a custom Document provider for use by that editor. This example is only for demonstration purposes. Java editing support is provided by the  Eclipse Java Tooling.\n" +
//                        "helpHref=/org.eclipse.platform.doc.isv/samples/org.eclipse.ui.examples.javaeditor/doc-html/ui_javaeditor_ex.html\n" +
//                        "id=org.eclipse.sdk.samples.javaeditor\n" +
//                        "";
//
//        String filePath = "C:\\Users\\hsnym\\Desktop\\TEST1\\SFLCN0101_20210121.dat";
//        try {
//            FileWriter fileWriter = new FileWriter(filePath);
//            fileWriter.write(saveStr);
//
//            fileWriter.close();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void 전문읽기() throws IOException {
//
//        Path fileName = Path.of("C:\\Users\\hsnym\\Desktop\\TEST1\\SFLCN0101_20210125.dat");
//        String actual = Files.readString(fileName);
//        System.out.println(actual);
//    }
//
//    @Test
//    public void 날짜()  {
//        LocalDate localDate = LocalDate.now();
//        String now = localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
//        System.out.println(now);
//
//    }
//}
//
//
