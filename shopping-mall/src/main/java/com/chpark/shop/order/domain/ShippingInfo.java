package com.chpark.shop.order.domain;

import com.chpark.shop.common.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

/**
 * 배송 정보
 */
@Getter
@AllArgsConstructor
// 배송정보는 주문 엔티티의 밸류로 표현된다.
@Embeddable
public
class ShippingInfo {
    // 다른 밸류를 포함했으므로 @Embeded 애너테이션을 사용한다.
    @Embedded
    // Address Value에서 정의한 컬럼명을 변경해서 사용하기 위해 재구현함
    // @AttributeOverride의 name은 참조할 클래스의 필드명, column은 변경할 컬럼명으로 설정한다.
    @AttributeOverrides({
            @AttributeOverride(name = "zipCode", column = @Column(name = "shipping_zipcode")),
            @AttributeOverride(name = "address", column = @Column(name = "shipping_address"))
    })
    private Address address;

    @Column(name = "shipping_message")
    private String message;

    @Embedded
    private Receiver receiver;
}
