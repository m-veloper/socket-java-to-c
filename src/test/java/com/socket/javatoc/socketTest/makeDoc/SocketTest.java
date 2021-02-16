//package com.socket.javatoc.socketTest.makeDoc;
//
//import com.scmsolution.common.BinarySerializer;
//import com.scmsolution.model.WooricardHeader;
//import com.scmsolution.scm.model.wc.virtualAccount.WcVirtualAccountRequestDto;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//
//import java.io.*;
//import java.net.InetSocketAddress;
//import java.net.Socket;
//import java.net.SocketAddress;
//import java.nio.ByteBuffer;
//import java.nio.ByteOrder;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
////@RunWith(SpringJUnit4ClassRunner.class)
////@ContextConfiguration(classes = {RootConfig.class})
//@Slf4j
//public class SocketTest {
//
//    private byte asdasd;
//    private byte b;
//
//
//    @Test
//    public void 클라이언트() throws IllegalAccessException, IOException, ClassNotFoundException {
//
//        WooricardHeader wooricardHeader = getHeader();
//        WcVirtualAccountRequestDto wcVirtualAccountRequestDto = getBody();
//
//        byte[] headerBytes = BinarySerializer.toByte(wooricardHeader);
//
//        Socket socket = new Socket();
//        SocketAddress address = new InetSocketAddress("192.168.0.4", 6547);
//        socket.connect(address);
//        OutputStream os = socket.getOutputStream();
//        os.write(headerBytes);
//        os.flush();
//    }
//
//
//    public WooricardHeader getHeader() {
//
//        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
//        long Time = Long.parseLong(now);
//
//        WooricardHeader wooricardHeader = WooricardHeader.builder()
//                .GRAM_KIND_CD(1000)
////                .PROC_RST_CD(0)
////                .GRAM_SEQ(1400000002)
//                .build();
//
////        WooricardHeader wooricardHeader = WooricardHeader.builder()
////                .SVC_DIV("1111")
////                .GRAM_KIND_CD(1000)
////                .PROC_RST_CD(0)
////                .ERR_MSG("3333")
////                .GRAM_SEQ(1400000002)
////                .GRAM_SEND_DTM((int) Time)
////                .FILLER_64("")
////                .build();
//
//        return wooricardHeader;
//    }
//
//    public WcVirtualAccountRequestDto getBody() {
//
//        WcVirtualAccountRequestDto wcVirtualAccountRequestDto = WcVirtualAccountRequestDto.builder()
//                .MRKT_CUST_NO("999999")
//                .FTRG_PRDT_CLAS_CD("1")
//                .CUST_TP_CD("3")
//                .BIZ_NO("8458101186")
//                .CORP_REG_NO("1234567891234")
//                .CORP_NM("에스씨엠솔루션")
//                .REPR_RESI_NO("1234567891234")
//                .REPR_NM("박정호")
//                .REPR_ENGNM("PARKPARK")
//                .REPR_NAT_CLAS_CD("KR")
//                .REPR_HP_NO1("010")
//                .REPR_HP_NO2("1234")
//                .REPR_HP_NO3("5678")
//                .EMAIL_ADDR("scmsolution.co@gmail.com")
//                .TOUT_BANK_CD("020")
//                .TOUT_ACNT_NO("1234567890")
//                .TOUT_ACNT_DEPO_OWNNM("에스씨엠솔루션")
//                .FILLER_142("")
//                .build();
//
//        return wcVirtualAccountRequestDto;
//    }
//
//    private static int byteArrayToInt(byte[] bytes) {
//        final int size = 300;
//        ByteBuffer buff = ByteBuffer.allocate(size);
//        final byte[] newBytes = new byte[size];
//        for (int i = 0; i < size; i++) {
//            if (i + bytes.length < size) {
//                newBytes[i] = (byte) 0x00;
//            } else {
//                newBytes[i] = bytes[i + bytes.length - size];
//            }
//        }
//        buff = ByteBuffer.wrap(newBytes);
//        buff.order(ByteOrder.BIG_ENDIAN); // Endian에 맞게 세팅
//        return buff.getInt();
//    }
//
//    public static Object toObject(byte[] bytes) {
//
//        Object obj = null;
//
//        try {
//
//            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
//
//            ObjectInputStream ois = new ObjectInputStream(bis);
//
//            obj = ois.readObject();
//
//
//        } catch (IOException ex) {
//
//            //TODO: Handle the exception
//
//            ex.printStackTrace();
//
//        } catch (ClassNotFoundException ex) {
//
//            //TODO: Handle the exception
//
//            ex.printStackTrace();
//
//        }
//
//        return obj;
//
//    }
//
//    public static byte[] toByteArray(Object obj) {
//
//        byte[] bytes = null;
//
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//
//        ObjectOutputStream oos = null;
//
//        try {
//
//            oos = new ObjectOutputStream(bos);
//
//            oos.writeObject(obj);
//
//            oos.flush();
//
//            bytes = bos.toByteArray();
//            for (byte b : bytes) {
//                System.out.print(b < 0 ? b + 256 : b);
//                System.out.print("\t");
//            }
//
//        } catch (IOException ex) {
//
//            //TODO: Handle the exception
//
//            ex.printStackTrace();
//
//        } finally {
//
//            try {
//
//                if (oos != null)
//
//                    oos.close();
//
//                if (oos != null)
//
//                    bos.close();
//
//            } catch (Exception e) {
//
//// TODO: handle exception
//
//                e.printStackTrace();
//
//            }
//
//        }
//
//        return bytes;
//
//    }
//
//}
