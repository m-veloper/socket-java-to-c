package com.socket.javatoc.socketTest.makeDoc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@Slf4j
public class SimpleTest2 {

    @Test
    public void 클라이언트() throws IOException {

        Socket socket = new Socket();
        SocketAddress address = new InetSocketAddress("192.168.0.4", 6547);
        socket.connect(address);
        OutputStream os = socket.getOutputStream();

        String sid = "0123";
        String sabun = "123456";

        //ByteBuffer
        ByteBuffer sendByteBuffer = null;

        sendByteBuffer = ByteBuffer.allocate(14);
        sendByteBuffer.order(ByteOrder.LITTLE_ENDIAN);

        sendByteBuffer.put(sid.getBytes());
        sendByteBuffer.put(new byte[5 - sid.getBytes().length]);

        sendByteBuffer.put(sabun.getBytes());
        sendByteBuffer.put(new byte[9 - sabun.getBytes().length]);

        os.write(sendByteBuffer.array());
        os.flush();
    }

}


