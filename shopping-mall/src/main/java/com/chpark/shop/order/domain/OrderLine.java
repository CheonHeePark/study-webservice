package com.chpark.shop.order.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 주문 항목
 * 주문은 1개 이상 상품을 N개까지 구매할 수 있어야 한다.
 * 주문 항목 클래스는 주문 도메인에서 관리된다.
 */
@Getter
public class OrderLine {
    private Product product;
    private int price;
    private int count;
    private int amounts;

    public OrderLine(Product product, int price, int count) {
        this.product = product;
        this.price = price;
        this.count = count;
        this.amounts = price * count;
    }

    /**
     * @return 주문금액
     */
    public int getAmounts() {
        return amounts;
    }
}
