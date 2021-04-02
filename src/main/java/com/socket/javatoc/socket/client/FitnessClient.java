package com.socket.javatoc.socket.client;

import com.socket.javatoc.socket.server.FitnessResultDto;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class FitnessClient {
    public static void main(String[] args) {

        try {

            log.info("====== 가상계좌 응답 소켓 실행 ======");

            // 소켓 세팅
            Socket socket = new Socket();

            int authNo = (int) (Math.random() * (9999999 - 1000000 + 1)) + 1000000;
            String saleMembCustNo = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMdd")) + authNo;

            FitnessResultDto fitnessResultDto = FitnessResultDto.builder()
                    .length(700)
                    .svcDiv("SCM")
                    .gramKindCd(2100)
                    .procRstCd(0)
                    .errMsg("")
                    .gramSeq(2104020069)
                    .gramSendDtm(20140301130000L)
                    .filler64("")

                    .normProcYn("Y")
                    .procRsltCntn("정상처리")
                    .bizNo("8458101186")
                    .fitLnmRstCd("1")
                    .fitLnmMngNo("11234567890")
                    .filler177("")
                    .build();

            // 전체 길이 설정
            ByteBuffer sendByteBuffer = ByteBuffer.allocate(704);

            // C언어 계설 서버에서 받을 데이터 타입 설정
            sendByteBuffer.order(ByteOrder.BIG_ENDIAN);

            //Header 전문 만들기
            StringBuffer typeFormat1 = new StringBuffer();
            typeFormat1.append("%0");    // 채워질 형태 : 0
            typeFormat1.append(4);  // 총자리수
            typeFormat1.append("d");     // d: 정수타입
            sendByteBuffer.put(String.format(String.valueOf(typeFormat1), fitnessResultDto.getLength()).getBytes("EUC-KR"));

            sendByteBuffer.put(fitnessResultDto.getSvcDiv().getBytes("EUC-KR"));
            sendByteBuffer.put(new byte[4 - fitnessResultDto.getSvcDiv().getBytes("EUC-KR").length]);

            StringBuffer typeFormat2 = new StringBuffer();
            typeFormat2.append("%0");    // 채워질 형태 : 0
            typeFormat2.append(4);  // 총자리수
            typeFormat2.append("d");     // d: 정수타입
            sendByteBuffer.put(String.format(String.valueOf(typeFormat2), fitnessResultDto.getGramKindCd()).getBytes("EUC-KR"));


            StringBuffer typeFormat3 = new StringBuffer();
            typeFormat3.append("%0");    // 채워질 형태 : 0
            typeFormat3.append(4);  // 총자리수
            typeFormat3.append("d");     // d: 정수타입
            sendByteBuffer.put(String.format(String.valueOf(typeFormat3), fitnessResultDto.getProcRstCd()).getBytes("EUC-KR"));


            sendByteBuffer.put(fitnessResultDto.getErrMsg().getBytes("EUC-KR"));
            sendByteBuffer.put(new byte[200 - fitnessResultDto.getErrMsg().getBytes("EUC-KR").length]);

            StringBuffer typeFormat4 = new StringBuffer();
            typeFormat4.append("%0");    // 채워질 형태 : 0
            typeFormat4.append(10);  // 총자리수
            typeFormat4.append("d");     // d: 정수타입
            sendByteBuffer.put(String.format(String.valueOf(typeFormat4), fitnessResultDto.getGramSeq()).getBytes("EUC-KR"));



            StringBuffer typeFormat5 = new StringBuffer();
            typeFormat5.append("%0");    // 채워질 형태 : 0
            typeFormat5.append(14);  // 총자리수
            typeFormat5.append("d");     // d: 정수타입
            sendByteBuffer.put(String.format(String.valueOf(typeFormat5), fitnessResultDto.getGramSendDtm()).getBytes("EUC-KR"));


            sendByteBuffer.put(fitnessResultDto.getFiller64().getBytes("EUC-KR"));
            sendByteBuffer.put(new byte[64 - fitnessResultDto.getFiller64().getBytes("EUC-KR").length]);

            //Body 전문 만들기
            sendByteBuffer.put(fitnessResultDto.getNormProcYn().getBytes("EUC-KR"));
            sendByteBuffer.put(new byte[1 - fitnessResultDto.getNormProcYn().getBytes("EUC-KR").length]);

            sendByteBuffer.put(fitnessResultDto.getProcRsltCntn().getBytes("EUC-KR"));
            sendByteBuffer.put(new byte[200 - fitnessResultDto.getProcRsltCntn().getBytes("EUC-KR").length]);

            sendByteBuffer.put(fitnessResultDto.getBizNo().getBytes("EUC-KR"));
            sendByteBuffer.put(new byte[10 - fitnessResultDto.getBizNo().getBytes("EUC-KR").length]);

            sendByteBuffer.put(fitnessResultDto.getFitLnmRstCd().getBytes("EUC-KR"));
            sendByteBuffer.put(new byte[1 - fitnessResultDto.getFitLnmRstCd().getBytes("EUC-KR").length]);

            sendByteBuffer.put(fitnessResultDto.getFitLnmMngNo().getBytes("EUC-KR"));
            sendByteBuffer.put(new byte[11 - fitnessResultDto.getFitLnmMngNo().getBytes("EUC-KR").length]);

            sendByteBuffer.put(fitnessResultDto.getFiller177().getBytes("EUC-KR"));
            sendByteBuffer.put(new byte[177 - fitnessResultDto.getFiller177().getBytes("EUC-KR").length]);

            SocketAddress address = new InetSocketAddress("127.0.0.1", 8090); // 로컬
//            SocketAddress address = new InetSocketAddress("115.71.35.37", 8090); // 개발
            socket.connect(address);
            log.info("적합성검사 서버 연결됨 : {}", address);
            OutputStream os = socket.getOutputStream();
            os.write(sendByteBuffer.array());
            os.flush();
            os.close();

        } catch (IOException e) {

        }
    }
}