package com.socket.javatoc.socketTest.server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServer2 {
    // socket으로 부터 수신을 받으면 byte[] 형식으로 내보낸다.
// 통신 규약으로는 데이터의 사이즈를 먼저 보내고, 그 다음에 데이터를 보내는 것으로 한다.
// 데이터의 사이즈를 보낼 때는 리틀 엔디언 타입으로 받는다.
    private static byte[] getRecieve(InputStream stream) throws IOException {
        byte[] buffer = new byte[4];
// 사데이터 사이즈를 받는다.
        stream.read(buffer, 0, 4);
        ByteBuffer data = ByteBuffer.wrap(buffer);
// 리틀 앤디언 타입으로 설정
        data.order(ByteOrder.BIG_ENDIAN);
// int형으로 변환
        int size = data.getInt();
        buffer = new byte[size];
// 데이터를 받는다.
        stream.read(buffer, 0, size);
        return buffer;
    }

    public static void main(String... args) {
// 서버용 싱글 쓰레드 풀을 생성
        ExecutorService service = Executors.newSingleThreadExecutor();
// 수신용 쓰레드 풀을 생성
        ExecutorService clientService = Executors.newFixedThreadPool(10);
        service.submit(() -> {
            try (ServerSocket server = new ServerSocket()) {
// 9999포트로 대기한다.
                InetSocketAddress ipep = new InetSocketAddress(18501);
                server.bind(ipep);
                System.out.println("서버 대기");
                while (true) {
// 클라이언트가 접속 되었다.
                    Socket client = server.accept();
                    System.out.println("클라이언트 접속");
                    clientService.submit(() -> {
// stream을 받는다.
                        try (OutputStream sender = client.getOutputStream();
                             InputStream reciever = client.getInputStream();
                        ) {
// 위 getRiceve 함수로 먼저 파일 이름을 받는다.
                            String filename = new String(getRecieve(reciever), Charset.forName("UTF-8"));
                            System.out.println("저장할 파일 이름 - " + filename);
// 데이터를 받는다.
                            byte[] filedata = getRecieve(reciever);
// 데이터를 저장한다.
                            try (FileOutputStream stream = new FileOutputStream("d:\\work\\" + filename)) {
                                stream.write(filedata, 0, filedata.length);
                            }
                            System.out.println("파일 저장 완료");
// 완료시에는 byte{1}을 송신한다.
                            sender.write(new byte[]{1}, 0, 1);
                            System.out.println("완료 코드 보내기");
                        } catch (Throwable e) {
                            e.printStackTrace();
                        } finally {
// 수신용 socket을 닫는다.
                            try {
                                client.close();
                            } catch (Throwable e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        });
    }
}