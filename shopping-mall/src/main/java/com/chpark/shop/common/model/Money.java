package com.chpark.shop.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 12/08/2020
 * Time : 1:00 AM
 */

/**
 * 금액 밸류
 * 주문 총금액, 제품 가격 등에 표현될 수 있다.
 * 불변으로 생성될 수 있도록 한다.
 */
@Getter
@RequiredArgsConstructor
public class Money {
    private final int value;

    public Money multiply(int multiplier) {
        return new Money(value * multiplier);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
