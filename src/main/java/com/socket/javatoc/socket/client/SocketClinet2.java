package com.socket.javatoc.socket.client;

import com.socket.javatoc.socket.server.ScmVirtualAccountResultDto;
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
public class SocketClinet2 {
    public static void main(String[] args) {

        try {

            log.info("====== 가상계좌 응답 소켓 실행 ======");

            // 소켓 세팅
            Socket socket = new Socket();

            int authNo = (int)(Math.random() * (9999999 - 1000000 + 1)) + 1000000;
            String saleMembCustNo = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMdd")) + authNo;

            ScmVirtualAccountResultDto scmVirtualAccountResultDto = ScmVirtualAccountResultDto.builder()
                    .length(800)
                    .svcDiv("SCM")
                    .gramKindCd(1100)
                    .procRstCd(0)
                    .errMsg("")
                    .gramSeq(2103240000)
                    .gramSendDtm(20140301130000L)
                    .filler64("")

//                    .normProcYn("N")
//                    .procRsltCntn("정보부족")
//                    .mrktCustNo("")
//                    .saleMembCustNo("")
//                    .iacntBankCd("")
//                    .iacntNo("")
//                    .iacntOwnnm("")
//                    .filler130("")

                    .normProcYn("Y")
                    .procRsltCntn("정상처리")
                    .mrktCustNo("WCWP")
                    .saleMembCustNo(saleMembCustNo)
                    .iacntBankCd("020")
                    .iacntNo("62000004118233")
                    .iacntOwnnm("김대표(주)우리카드")
                    .filler130("")

                    .build();

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

            SocketAddress address = new InetSocketAddress("127.0.0.1", 8090); // 로컬
//            SocketAddress address = new InetSocketAddress("115.71.35.37", 8090); // 개발
            socket.connect(address);
            log.info("가상계좌 응답 우리카드 서버 연결됨 : {}", address);
            OutputStream os = socket.getOutputStream();
            os.write(sendByteBuffer.array());
            os.flush();
            os.close();

        } catch (IOException e) {

        }
    }
}