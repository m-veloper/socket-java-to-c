package com.socket.javatoc.socket.server;

import lombok.*;


@Getter
@Setter
@Builder
public class FitnessResultDto {

    // 헤더
    private int length;             // 전문종별코드
    public String svcDiv;          // 서비스구분
    public int gramKindCd;         // 전문종별코드
    public int procRstCd;          // 응답코드
    public String errMsg;          // 오류메시지
    public int gramSeq;            // 전문일련번호
    public Long gramSendDtm;       // 전문전송시간
    public String filler64;        // FILLER

    // 바디
    public String normProcYn;      // 정상_처리_여부\
    public String procRsltCntn;    // 처리_결과_내용
    public String bizNo;           // 사업자_번호
    public String fitLnmRstCd;     // 적합성_결과_코드
    public String fitLnmMngNo;     // 적합성_관리_번호
    public String filler177;       //예비130
}
