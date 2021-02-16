package com.socket.javatoc.common;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

@Slf4j
public class BinarySerializer {
    public static byte[] toByte(Object cls) throws IllegalAccessException {

        Class<?> aClass = cls.getClass();
        int classLength = aClass.getAnnotation(Attribute.class).length();

        ByteBuffer byteBuffer = ByteBuffer.allocate(classLength);
        for (Field field : aClass.getDeclaredFields()) {
            Attribute attribute = field.getAnnotation(Attribute.class);
            if( null == attribute) {
                throw new IllegalStateException("속성 어트리뷰트가 없다");
            }

            int length = attribute.length();
            Class<?> type = field.getType();
            if( type.getName().equals("int")) {
                int asInt = field.getInt(cls);
                ByteBuffer buffer = ByteBuffer.allocate(length).putInt(asInt);
                byteBuffer.put(buffer);

            } else if (type.getName().equals("java.lang.String")) {

                String o = (String) field.get(cls);
                log.info(o);
                if( o != null ) {
                    ByteBuffer buffer = ByteBuffer.allocate(length).put(o.getBytes(StandardCharsets.UTF_8));
                    byteBuffer.put(buffer);
                }
            }

        }

        return byteBuffer.array();
    }
}
