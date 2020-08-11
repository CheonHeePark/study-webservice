package com.chpark.shop.order.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 수신자
 * 수신자는 배송자, 주문자 등 밸류로 표현될 수 있다.
 */
@Getter
@AllArgsConstructor
@Embeddable
public class Receiver {
    @Column(name = "receiver_name")
    private String name;
    @Column(name = "receiver_phone")
    private String phone;

    // JPA-Provider(구현체)가 DB에서 데이터를 조회하고 매핑된 객체를 사용할 때, 기본 생성자를 사용한다. (따라서 기본생성자 필수 존재해야함)
    // 하지만 그 외에서는 사용안하므로 protected로 선언해서 외부에서는 생성하지 못하도록 한다.
    // private이 아닌 protected인 이유는, JPA(Hibernate)가 지연로딩을 위해 프록시를 사용할 때,
    // 프록시 클래스에서 상위 클래스의 생성자를 호출해야하는데 이 때 생성자가 필요함. (private인 경우 상속이 안되므로 불가능)
    // Entity, Embededable 모두 해당한다.
    protected Receiver() {}
}
