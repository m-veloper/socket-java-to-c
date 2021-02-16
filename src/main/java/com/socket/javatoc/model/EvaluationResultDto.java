package com.socket.javatoc.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EvaluationResultDto {

    private String mrktCustNo;          // 마켓_고객_번호 예: 999912319003
    private String saleMembCustNo;      // 판매_회원_고객_번호	예: 200203111111
    private String ftrgPrdtDivCd;       // 팩토링_상품_구분_코드 예: "1:팩토링(프로모션) 2:선정산(일반)"
    private String saleMembMrktId;      // 판매_회원_마켓_아이디 예:scmID01,scmID02
    private String examRqstDt;          // 심사_요청_일자 예: 2021-01-01
    private String examCmplDt;          // 심사_완료_일자 예: 2021-01-01
    private String aprvYn;              // 승인_여부 예 : Y
    private String rjctRsnCntn;         // 거절_사유_내용 예: 한도초과
    private String limAmt;              // 한도_금액 예 : 10000000
    private String limStrtDt;           // 한도_시작_일자 예: 2021-01-01
    private String limEndDt;            // 한도_종료_일자 예: 2021-12-31

}
