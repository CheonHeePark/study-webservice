package com.chpark.shop.order.domain;

import com.chpark.shop.common.model.Money;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * 주문 항목
 * 주문은 1개 이상 상품을 N개까지 구매할 수 있어야 한다.
 * 주문 항목 클래스는 주문 도메인에서 관리된다.
 */
@Getter
@Embeddable
public class OrderLine {
    @Embedded
    private Product product;

    @Column(name = "price")
    private Money price;

    @Column(name = "count")
    private int count;

    @Column(name = "amounts")
    private Money amounts;

    public OrderLine(Product product, Money price, int count) {
        this.product = product;
        this.price = price;
        this.count = count;
        this.amounts = price.multiply(count);
    }

    /**
     * @return 주문금액
     */
    public Money getAmounts() {
        return amounts;
    }
}
