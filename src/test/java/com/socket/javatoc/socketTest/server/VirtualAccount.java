package com.socket.javatoc.socketTest.server;

import com.socket.javatoc.common.ByteUtils;
import com.socket.javatoc.model.ScmVirtualAccountResultDto;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class VirtualAccount {

    public static void main(String[] args) throws IOException {
        VirtualAccount socketServer5 = new VirtualAccount();
        socketServer5.run();
    }

    public void run() throws IOException {

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

                    byte[] tempArr = new byte[4];
                    System.arraycopy(buff, 0, tempArr, 0, 4);
                    System.out.println(new String(tempArr).trim());

                    tempArr = new byte[4];
                    System.arraycopy(buff, 4, tempArr, 0, 4);
                    System.out.println(new String(tempArr).trim());

                    tempArr = new byte[4];
                    System.arraycopy(buff, 8, tempArr, 0, 4);
                    System.out.println(new String(tempArr).trim());

                    tempArr = new byte[200];
                    System.arraycopy(buff, 12, tempArr, 0, 200);
                    System.out.println(new String(tempArr).trim());

                    tempArr = new byte[10];
                    System.arraycopy(buff, 212, tempArr, 0, 10);
                    System.out.println(new String(tempArr).trim());

                    tempArr = new byte[14];
                    System.arraycopy(buff, 222, tempArr, 0, 14);
                    System.out.println(new String(tempArr).trim());

                    tempArr = new byte[64];
                    System.arraycopy(buff, 236, tempArr, 0, 64);
                    System.out.println(new String(tempArr).trim());

                    // Body 변환
                    tempArr = new byte[13];
                    System.arraycopy(buff, 300, tempArr, 0, 13);
                    System.out.println(new String(tempArr).trim());
                    tempArr = new byte[1];
                    System.arraycopy(buff, 313, tempArr, 0, 1);
                    System.out.println(new String(tempArr).trim());
                    tempArr = new byte[1];
                    System.arraycopy(buff, 314, tempArr, 0, 1);
                    System.out.println(new String(tempArr).trim());
                    tempArr = new byte[10];
                    System.arraycopy(buff, 315, tempArr, 0, 10);
                    System.out.println(new String(tempArr).trim());
                    tempArr = new byte[13];
                    System.arraycopy(buff, 325, tempArr, 0, 13);
                    System.out.println(new String(tempArr).trim());
                    tempArr = new byte[100];
                    System.arraycopy(buff, 338, tempArr, 0, 100);
                    System.out.println(new String(tempArr).trim());
                    tempArr = new byte[13];
                    System.arraycopy(buff, 438, tempArr, 0, 13);
                    System.out.println(new String(tempArr).trim());
                    tempArr = new byte[50];
                    System.arraycopy(buff, 451, tempArr, 0, 50);
                    System.out.println(new String(tempArr).trim());
                    tempArr = new byte[50];
                    System.arraycopy(buff, 501, tempArr, 0, 50);
                    System.out.println(new String(tempArr).trim());
                    tempArr = new byte[2];
                    System.arraycopy(buff, 551, tempArr, 0, 2);
                    System.out.println(new String(tempArr).trim());
                    tempArr = new byte[4];
                    System.arraycopy(buff, 553, tempArr, 0, 4);
                    System.out.println(new String(tempArr).trim());
                    tempArr = new byte[4];
                    System.arraycopy(buff, 557, tempArr, 0, 4);
                    System.out.println(new String(tempArr).trim());
                    tempArr = new byte[4];
                    System.arraycopy(buff, 561, tempArr, 0, 4);
                    System.out.println(new String(tempArr).trim());
                    tempArr = new byte[50];
                    System.arraycopy(buff, 565, tempArr, 0, 50);
                    System.out.println(new String(tempArr).trim());
                    tempArr = new byte[3];
                    System.arraycopy(buff, 615, tempArr, 0, 3);
                    System.out.println(new String(tempArr).trim());
                    tempArr = new byte[40];
                    System.arraycopy(buff, 618, tempArr, 0, 40);
                    System.out.println(new String(tempArr).trim());
                    tempArr = new byte[100];
                    System.arraycopy(buff, 658, tempArr, 0, 100);
                    System.out.println(new String(tempArr).trim());
                    tempArr = new byte[142];
                    System.arraycopy(buff, 758, tempArr, 0, 142);
                    System.out.println(new String(tempArr).trim());


                    sendData(buff, socket);
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sendData(byte[] bytes, Socket socket) throws InterruptedException {

//        Thread.sleep(10000);

        ByteUtils byteUtils = new ByteUtils();
        ScmVirtualAccountResultDto scmVirtualAccountResultDto = ScmVirtualAccountResultDto.builder()

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
                .saleMembCustNo("200203111111")
                .iacntBankCd("020")
                .iacntNo("62000004118233")
                .iacntOwnnm("김대표(주)우리카드")
                .filler130("")

//                .svcDiv("AAA")
//                .gramKindCd(1100)
//                .procRstCd(0)
//                .errMsg("사업자정보 불일치")
//                .gramSeq(1400000002)
//                .gramSendDtm(20140301130000L)
//                .filler64("")
//                .normProcYn("N")
//                .procRsltCntn("실패처리")
//                .mrktCustNo("999912319003")
//                .saleMembCustNo("200203111111")
//                .iacntBankCd("020")
//                .iacntNo("62000004118233")
//                .iacntOwnnm("김대표(주)우리카드")
//                .filler130("")

                .build();
        try {
            // 전체 길이 설정
            ByteBuffer sendByteBuffer = ByteBuffer.allocate(800);
            // C언어 계설 서버에서 받을 데이터 타입 설정
            sendByteBuffer.order(ByteOrder.BIG_ENDIAN);

            //Header 전문 만들기
            sendByteBuffer.put(scmVirtualAccountResultDto.getSvcDiv().getBytes("UTF-8"));
            sendByteBuffer.put(new byte[4 - scmVirtualAccountResultDto.getSvcDiv().getBytes("UTF-8").length]);

            byte[] gramKindCd = byteUtils.intToByteArray(scmVirtualAccountResultDto.getGramKindCd());
            sendByteBuffer.put(gramKindCd);
            sendByteBuffer.put(new byte[4 - gramKindCd.length]);

            byte[] procRstCd = byteUtils.intToByteArray(scmVirtualAccountResultDto.getProcRstCd());
            sendByteBuffer.put(procRstCd);
            sendByteBuffer.put(new byte[4 - procRstCd.length]);

            sendByteBuffer.put(scmVirtualAccountResultDto.getErrMsg().getBytes("UTF-8"));
            sendByteBuffer.put(new byte[200 - scmVirtualAccountResultDto.getErrMsg().getBytes("UTF-8").length]);

            byte[] gramSeq = byteUtils.intToByteArray(scmVirtualAccountResultDto.getGramSeq());
            sendByteBuffer.put(gramSeq);
            sendByteBuffer.put(new byte[10 - gramSeq.length]);

            byte[] gramSendDtm = byteUtils.longToBytes(scmVirtualAccountResultDto.getGramSendDtm());
            sendByteBuffer.put(gramSendDtm);
            sendByteBuffer.put(new byte[14 - gramSendDtm.length]);

            sendByteBuffer.put(scmVirtualAccountResultDto.getFiller64().getBytes("UTF-8"));
            sendByteBuffer.put(new byte[64 - scmVirtualAccountResultDto.getFiller64().getBytes("UTF-8").length]);

            //Body 전문 만들기
            sendByteBuffer.put(scmVirtualAccountResultDto.getNormProcYn().getBytes("UTF-8"));
            sendByteBuffer.put(new byte[1 - scmVirtualAccountResultDto.getNormProcYn().getBytes("UTF-8").length]);

            sendByteBuffer.put(scmVirtualAccountResultDto.getProcRsltCntn().getBytes("UTF-8"));
            sendByteBuffer.put(new byte[200 - scmVirtualAccountResultDto.getProcRsltCntn().getBytes("UTF-8").length]);

            sendByteBuffer.put(scmVirtualAccountResultDto.getMrktCustNo().getBytes("UTF-8"));
            sendByteBuffer.put(new byte[13 - scmVirtualAccountResultDto.getMrktCustNo().getBytes("UTF-8").length]);

            sendByteBuffer.put(scmVirtualAccountResultDto.getSaleMembCustNo().getBytes("UTF-8"));
            sendByteBuffer.put(new byte[13 - scmVirtualAccountResultDto.getSaleMembCustNo().getBytes("UTF-8").length]);

            sendByteBuffer.put(scmVirtualAccountResultDto.getIacntBankCd().getBytes("UTF-8"));
            sendByteBuffer.put(new byte[3 - scmVirtualAccountResultDto.getIacntBankCd().getBytes("UTF-8").length]);

            sendByteBuffer.put(scmVirtualAccountResultDto.getIacntNo().getBytes("UTF-8"));
            sendByteBuffer.put(new byte[40 - scmVirtualAccountResultDto.getIacntNo().getBytes("UTF-8").length]);

            sendByteBuffer.put(scmVirtualAccountResultDto.getIacntOwnnm().getBytes("UTF-8"));
            sendByteBuffer.put(new byte[100 - scmVirtualAccountResultDto.getIacntOwnnm().getBytes("UTF-8").length]);

            sendByteBuffer.put(scmVirtualAccountResultDto.getFiller130().getBytes("UTF-8"));
            sendByteBuffer.put(new byte[130 - scmVirtualAccountResultDto.getFiller130().getBytes("UTF-8").length]);

            OutputStream os = socket.getOutputStream();
            os.write(sendByteBuffer.array());
            os.flush();

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}