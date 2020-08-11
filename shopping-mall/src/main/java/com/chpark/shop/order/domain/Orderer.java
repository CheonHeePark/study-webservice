package com.chpark.shop.order.domain;

import com.chpark.shop.member.domain.MemberId;

import javax.persistence.*;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 11/08/2020
 * Time : 12:28 AM
 */

/**
 * 주문자
 * 주문 도메인의 애그리거트 루트는 주문Entity이므로, 주문자는 주문에 속해있는 밸류로 표현될 수 있다.
 */
@Embeddable
public class Orderer {
    @Embedded
    // MemberId에 member_id컬럼이 정의되어있는데, 그 이름을 주문자에 맞게 orderer_id로 변경해서 사용한다.
    // 다른 클래스의 컬럼명을 변경해서 사용할경우 @AttributeOverride 애너테이션을 사용한다.
    @AttributeOverrides(
           @AttributeOverride(name = "id", column = @Column(name = "orderer_id"))
    )
    private MemberId memberId;      // 이제 Orderer 클래스의 memberId는 "member_id"가 아니라 "orderer_id"로 테이블에 저장된다.

    @Column(name = "orderer_name")
    private String name;


}
