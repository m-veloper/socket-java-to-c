//package com.socket.javatoc.socketTest.makeDoc;
//
//import com.scmsolution.common.Attribute;
//import com.scmsolution.common.BinarySerializer;
//import com.scmsolution.model.WooricardHeader;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//
//import java.io.UnsupportedEncodingException;
//import java.lang.reflect.Field;
//import java.nio.ByteBuffer;
//import java.nio.ByteOrder;
//
//@Slf4j
//public class SimpleTest {
//
//    @Test
//    public void interSize(){
//        int size = Integer.SIZE/8;
//        System.out.println("int size : " + size);
//    }
//
//    @Test
//    public void 변환테스트(){
//        byte[] bytes = intToByteArray(1400000003);
//        int num0 = byteArrayToInt0(bytes);
//        System.out.println("num0 : "+num0);
//
//    }
//
//    @Test
//    public void 변환테스트2() throws UnsupportedEncodingException, IllegalAccessException {
//        WooricardHeader wooricardHeader = WooricardHeader.builder()
//////                .GRAM_KIND_CD(1000)
//////                .PROC_RST_CD(0)
////                .GRAM_SEQ(1400000002)
//                .build();
//
//        WooricardHeader wooricardHeader1 = WooricardHeader.builder()
//                .build();
//        byte[] headerBytes = BinarySerializer.toByte(wooricardHeader);
//        toObject(headerBytes, wooricardHeader1);
//    }
//
//    private static byte[] intToByteArray(int integer) {
//        ByteBuffer buff = ByteBuffer.allocate(10);
//        buff.putInt(integer);
//        buff.order(ByteOrder.BIG_ENDIAN);
//        System.out.println(buff.get());
//        return buff.array();
//    }
//
//    private static int byteArrayToInt0(byte[] bytes) {
//        final int size = 10;
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
//        buff.order(ByteOrder.BIG_ENDIAN);
//        return buff.getInt();
//    }
//
//
//    public static WooricardHeader toObject(byte[] bytes, WooricardHeader wooricardHeader) throws IllegalAccessException, UnsupportedEncodingException {
//
//        Class<?> aClass = wooricardHeader.getClass();
//        int classLength = aClass.getAnnotation(Attribute.class).length();
//        ByteBuffer byteBuffer = ByteBuffer.allocate(classLength);
//        ByteBuffer buffer = null;
//        ByteBuffer buff = null;
//        for (Field field : aClass.getDeclaredFields()) {
//            Attribute attribute = field.getAnnotation(Attribute.class);
//            if( null == attribute) {
//                throw new IllegalStateException("속성 어트리뷰트가 없다");
//            }
//
//            int length = attribute.length();
//            Class<?> type = field.getType();
//            if( type.getName().equals("int")) {
//                buff = ByteBuffer.allocate(length);
//                final byte[] newBytes = new byte[length];
//                for (int i = 0; i < length; i++) {
//                    if (i + bytes.length < length) {
//                        newBytes[i] = (byte) 0x00;
//                    } else {
//                        newBytes[i] = bytes[i + bytes.length - length];
//                    }
//                }
//                buff = ByteBuffer.wrap(newBytes);
//                buff.order(ByteOrder.BIG_ENDIAN);
////                wooricardHeader.setGRAM_SEQ(buff.getInt());
//            }
//        }
//        return wooricardHeader;
//    }
//
//}
//
//
