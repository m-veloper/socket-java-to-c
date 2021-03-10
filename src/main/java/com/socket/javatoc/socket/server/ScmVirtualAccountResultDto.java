package com.socket.javatoc.socket.server;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class ScmVirtualAccountResultDto {

    // 헤더
    private String svcDiv;          // 서비스구분
    private int gramKindCd;         // 전문종별코드
    private int procRstCd;          // 응답코드
    private String errMsg;          // 오류메시지
    private int gramSeq;            // 전문일련번호
    private Long gramSendDtm;       // 전문전송시간
    private String filler64;        // FILLER

    // 바디
    private String normProcYn;      // 정상_처리_여부
    private String procRsltCntn;    // 처리_결과_내용
    private String mrktCustNo;      // 마켓_고객_번호
    private String saleMembCustNo;  // 판매_회원_고객_번호
    private String iacntBankCd;     // 가상계좌_은행_코드
    private String iacntNo;         // 가상계좌_번호
    private String iacntOwnnm;      // 가상계좌계좌_예금주명
    private String filler130;       //예비130
}
