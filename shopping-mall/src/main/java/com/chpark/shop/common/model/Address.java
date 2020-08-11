package com.chpark.shop.common.model;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 12/08/2020
 * Time : 12:41 AM
 */

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 배송지 주소
 * 배송지 주소는 주문 엔티티의 밸류로 표현되거나 배송정보 밸류의 밸류로 표현될 수 있따.
 */
@Getter
@AllArgsConstructor
@Embeddable
public class Address {
    @Column(name = "zipcode")
    private String zipCode;

    @Column(name = "address")
    private String address;
}
