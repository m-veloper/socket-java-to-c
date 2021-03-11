package com.socket.javatoc.socket.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Configuration
public class SocketServer {


    @Bean
    public void run() throws IOException{
        try {

            BufferedInputStream bis = null;
            try {
                int port = 9999;
                ServerSocket server = new ServerSocket(port);

                while (true) {
                    System.out.println("-------가상계좌 요청 접속 대기중------");
                    Socket socket = server.accept();         // 계속 기다리고 있다가 클라이언트가 접속하면 통신할 수 있는 소켓 반환
                    System.out.println(socket.getInetAddress() + "로 부터 연결요청이 들어옴");
                    InputStream is = socket.getInputStream();

                    bis = new BufferedInputStream(socket.getInputStream());
                    byte[] buff = new byte[1024];

                    int read = 0;
                    while (true) {
                        if (socket == null) {
                            break;
                        }
                        read = bis.read(buff, 0, 1024);
                        if (read < 0) {
                            break;
                        }

                        //헤더
                        byte[] tempArr = new byte[4];
                        System.arraycopy(buff, 0, tempArr, 0, 4);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 

                        tempArr = new byte[4];
                        System.arraycopy(buff, 4, tempArr, 0, 4);
                        System.out.println(new String(tempArr, "EUC-KR").trim());  

                        tempArr = new byte[4]; 
                        System.arraycopy(buff, 8, tempArr, 0, 4);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 

                        tempArr = new byte[4]; 
                        System.arraycopy(buff, 12, tempArr, 0, 4);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 

                        tempArr = new byte[200];
                        System.arraycopy(buff, 16, tempArr, 0, 200);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 

                        tempArr = new byte[10];
                        System.arraycopy(buff, 216, tempArr, 0, 10);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 

                        tempArr = new byte[14];
                        System.arraycopy(buff, 226, tempArr, 0, 14);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 

                        tempArr = new byte[64];
                        System.arraycopy(buff, 240, tempArr, 0, 64);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 

                        // Body 변환
                        tempArr = new byte[13];
                        System.arraycopy(buff, 304, tempArr, 0, 13);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 
                        tempArr = new byte[1];
                        System.arraycopy(buff, 317, tempArr, 0, 1);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 
                        tempArr = new byte[1];
                        System.arraycopy(buff, 318, tempArr, 0, 1);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 
                        tempArr = new byte[10];
                        System.arraycopy(buff, 319, tempArr, 0, 10);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 
                        tempArr = new byte[13];
                        System.arraycopy(buff, 329, tempArr, 0, 13);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 
                        tempArr = new byte[100];
                        System.arraycopy(buff, 342, tempArr, 0, 100);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 
                        tempArr = new byte[13];
                        System.arraycopy(buff, 442, tempArr, 0, 13);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 
                        tempArr = new byte[50];
                        System.arraycopy(buff, 455, tempArr, 0, 50);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 
                        tempArr = new byte[50];
                        System.arraycopy(buff, 505, tempArr, 0, 50);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 
                        tempArr = new byte[2];
                        System.arraycopy(buff, 555, tempArr, 0, 2);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 
                        tempArr = new byte[4];
                        System.arraycopy(buff, 557, tempArr, 0, 4);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 
                        tempArr = new byte[4];
                        System.arraycopy(buff, 561, tempArr, 0, 4);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 
                        tempArr = new byte[4];
                        System.arraycopy(buff, 565, tempArr, 0, 4);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 
                        tempArr = new byte[50];
                        System.arraycopy(buff, 569, tempArr, 0, 50);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 
                        tempArr = new byte[3];
                        System.arraycopy(buff, 619, tempArr, 0, 3);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 
                        tempArr = new byte[40];
                        System.arraycopy(buff, 622, tempArr, 0, 40);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 
                        tempArr = new byte[100];
                        System.arraycopy(buff, 662, tempArr, 0, 100);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 
                        tempArr = new byte[142];
                        System.arraycopy(buff, 762, tempArr, 0, 142);
                        System.out.println(new String(tempArr, "EUC-KR").trim()); 


                        sendData(buff, socket);
                    }


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendData(byte[] bytes, Socket socket){
        ByteUtils byteUtils = new ByteUtils();

        // 인증번호 생성
        int authNo = (int)(Math.random() * (9999999 - 1000000 + 1)) + 1000000;
        String saleMembCustNo = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMdd")) + authNo;

        ScmVirtualAccountResultDto scmVirtualAccountResultDto = ScmVirtualAccountResultDto.builder()
                .length(800)
                .svcDiv("SCM")
                .gramKindCd(1100)
                .procRstCd(0)
                .errMsg("")
                .gramSeq(2102230155)
                .gramSendDtm(20140301130000L)
                .filler64("")
                .normProcYn("Y")
                .procRsltCntn("정상처리")
                .mrktCustNo("WCWP")
                .saleMembCustNo(saleMembCustNo)
                .iacntBankCd("020")
                .iacntNo("62000004118233")
                .iacntOwnnm("김대표(주)우리카드")
                .filler130("")
                .build();

        try {

            // 전체 길이 설정
            ByteBuffer sendByteBuffer = ByteBuffer.allocate(804);
            // C언어 계설 서버에서 받을 데이터 타입 설정
            sendByteBuffer.order(ByteOrder.BIG_ENDIAN);

            //Header 전문 만들기
            StringBuffer typeFormat1 = new StringBuffer();
            typeFormat1.append("%0");    // 채워질 형태 : 0
            typeFormat1.append(4);  // 총자리수
            typeFormat1.append("d");     // d: 정수타입
            sendByteBuffer.put(String.format(String.valueOf(typeFormat1), scmVirtualAccountResultDto.getLength()).getBytes("EUC-KR"));
//            byte[] totLength = byteUtils.intToByteArray(scmVirtualAccountResultDto.getLength());
//            sendByteBuffer.put(totLength);
//            sendByteBuffer.put(new byte[4 - totLength.length]);

            sendByteBuffer.put(scmVirtualAccountResultDto.getSvcDiv().getBytes("EUC-KR"));
            sendByteBuffer.put(new byte[4 - scmVirtualAccountResultDto.getSvcDiv().getBytes("EUC-KR").length]);

            StringBuffer typeFormat2 = new StringBuffer();
            typeFormat2.append("%0");    // 채워질 형태 : 0
            typeFormat2.append(4);  // 총자리수
            typeFormat2.append("d");     // d: 정수타입
            sendByteBuffer.put(String.format(String.valueOf(typeFormat2), scmVirtualAccountResultDto.getGramKindCd()).getBytes("EUC-KR"));
//            byte[] gramKindCd = byteUtils.intToByteArray(scmVirtualAccountResultDto.getGramKindCd());
//            sendByteBuffer.put(gramKindCd);
//            sendByteBuffer.put(new byte[4 - gramKindCd.length]);

            StringBuffer typeFormat3 = new StringBuffer();
            typeFormat3.append("%0");    // 채워질 형태 : 0
            typeFormat3.append(4);  // 총자리수
            typeFormat3.append("d");     // d: 정수타입
            sendByteBuffer.put(String.format(String.valueOf(typeFormat3), scmVirtualAccountResultDto.getProcRstCd()).getBytes("EUC-KR"));
//            byte[] procRstCd = byteUtils.intToByteArray(scmVirtualAccountResultDto.getProcRstCd());
//            sendByteBuffer.put(procRstCd);
//            sendByteBuffer.put(new byte[4 - procRstCd.length]);

            sendByteBuffer.put(scmVirtualAccountResultDto.getErrMsg().getBytes("EUC-KR"));
            sendByteBuffer.put(new byte[200 - scmVirtualAccountResultDto.getErrMsg().getBytes("EUC-KR").length]);

            StringBuffer typeFormat4 = new StringBuffer();
            typeFormat4.append("%0");    // 채워질 형태 : 0
            typeFormat4.append(10);  // 총자리수
            typeFormat4.append("d");     // d: 정수타입
            sendByteBuffer.put(String.format(String.valueOf(typeFormat4), scmVirtualAccountResultDto.getGramSeq()).getBytes("EUC-KR"));
//            byte[] gramSeq = byteUtils.intToByteArray(scmVirtualAccountResultDto.getGramSeq());
//            sendByteBuffer.put(gramSeq);
//            sendByteBuffer.put(new byte[10 - gramSeq.length]);


            StringBuffer typeFormat5 = new StringBuffer();
            typeFormat5.append("%0");    // 채워질 형태 : 0
            typeFormat5.append(14);  // 총자리수
            typeFormat5.append("d");     // d: 정수타입
            sendByteBuffer.put(String.format(String.valueOf(typeFormat5), scmVirtualAccountResultDto.getGramSendDtm()).getBytes("EUC-KR"));
//            byte[] gramSendDtm = byteUtils.longToBytes(scmVirtualAccountResultDto.getGramSendDtm());
//            sendByteBuffer.put(gramSendDtm);
//            sendByteBuffer.put(new byte[14 - gramSendDtm.length]);

            sendByteBuffer.put(scmVirtualAccountResultDto.getFiller64().getBytes("EUC-KR"));
            sendByteBuffer.put(new byte[64 - scmVirtualAccountResultDto.getFiller64().getBytes("EUC-KR").length]);

            //Body 전문 만들기
            sendByteBuffer.put(scmVirtualAccountResultDto.getNormProcYn().getBytes("EUC-KR"));
            sendByteBuffer.put(new byte[1 - scmVirtualAccountResultDto.getNormProcYn().getBytes("EUC-KR").length]);

            sendByteBuffer.put(scmVirtualAccountResultDto.getProcRsltCntn().getBytes("EUC-KR"));
            sendByteBuffer.put(new byte[200 - scmVirtualAccountResultDto.getProcRsltCntn().getBytes("EUC-KR").length]);

            sendByteBuffer.put(scmVirtualAccountResultDto.getMrktCustNo().getBytes("EUC-KR"));
            sendByteBuffer.put(new byte[13 - scmVirtualAccountResultDto.getMrktCustNo().getBytes("EUC-KR").length]);

            sendByteBuffer.put(scmVirtualAccountResultDto.getSaleMembCustNo().getBytes("EUC-KR"));
            sendByteBuffer.put(new byte[13 - scmVirtualAccountResultDto.getSaleMembCustNo().getBytes("EUC-KR").length]);

            sendByteBuffer.put(scmVirtualAccountResultDto.getIacntBankCd().getBytes("EUC-KR"));
            sendByteBuffer.put(new byte[3 - scmVirtualAccountResultDto.getIacntBankCd().getBytes("EUC-KR").length]);

            sendByteBuffer.put(scmVirtualAccountResultDto.getIacntNo().getBytes("EUC-KR"));
            sendByteBuffer.put(new byte[40 - scmVirtualAccountResultDto.getIacntNo().getBytes("EUC-KR").length]);

            sendByteBuffer.put(scmVirtualAccountResultDto.getIacntOwnnm().getBytes("EUC-KR"));
            sendByteBuffer.put(new byte[100 - scmVirtualAccountResultDto.getIacntOwnnm().getBytes("EUC-KR").length]);

            sendByteBuffer.put(scmVirtualAccountResultDto.getFiller130().getBytes("EUC-KR"));
            sendByteBuffer.put(new byte[130 - scmVirtualAccountResultDto.getFiller130().getBytes("EUC-KR").length]);

            OutputStream os = socket.getOutputStream();
            os.write(sendByteBuffer.array());
            os.flush();

        } catch(Exception e1){
            e1.printStackTrace();
        }
    }
}