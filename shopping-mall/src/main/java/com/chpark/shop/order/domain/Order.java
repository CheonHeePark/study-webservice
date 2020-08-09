package com.chpark.shop.order.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * 주문 도메인
 * 기능
 * 1. 주문 진행
 * 2. 주문 취소
 * 3. 배송지 정보 변경
 * 4. 발송 완료 처리
 * TODO 필요없는 주석은 개발 이후 삭제한다.
 */
@Getter
public class Order {
    // TODO 주문번호는 DB에서 생성할것인지, Entity에서 생성할것인지, 사용자 정의값을 사용할것인지 고민해보자.
    private String orderNumber;
    private OrderState state;
    private ShippingInfo shippingInfo;
    private List<OrderLine> orderLines;
    private int totalAmounts;

    /**
     * 주문할 때, 주문항목과 배송지정보는 필수값이므로 생성자에서 필수항목들을 전달받도록 한다.
     * @param orderLines 주문항목 리스트
     * @param shippingInfo 배송지 정보
     */
    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
        // TODO 예외가 발생할 수 있는 코드를 생성자에서 처리하는것이 맞는가?
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
        // TODO 주문 전 상태가 꼭 있어야 하는지? 주문 생성 시점 => 이미 주문된것이 아닐까?
        state = OrderState.BEFORE;
    }

    /**
     * 주문을 취소한다.
     */
    public void cancel() {
        // 발송완료가 되었다면 주문을 취소하기 어렵다.
        verifyNotYetShippiingCompleted();
        state = OrderState.CANCELED;
    }

    /**
     * 배송지 정보를 변경한다.
     * @param shippingInfo 새로운 배송지 정보
     */
    public void changeShippingInfo(ShippingInfo shippingInfo) {
        // 발송완료가 되었다면 배송지 정보를 변경하기 어렵다.
        verifyNotYetShippiingCompleted();
        setShippingInfo(shippingInfo);
    }

    /**
     * 발송 완료 처리한다. (상품 출고됨)
     */
    public void changeShippingCompleted() {
        this.state = OrderState.SHIPPING_COMPLETED;
    }

    /*
     * 주문항목리스트를 설정한다.
     */
    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    /*
     * 배송지 정보를 설정한다.
     */
    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) throw new IllegalArgumentException("Wrong ShippingInfo");
       this.shippingInfo = shippingInfo;
    }

    /*
     * 주문은 최소 1개 이상해야하므로, 주문항목이 1개 이상 있는지 확인한다.
     */
    private void verifyAtLeastOneOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) throw new IllegalArgumentException("Wrong Orderlines");
    }

    /*
     * 상품 발송완료가 되었는지 확인한다. (결제전, 상품 발송 준비중일때만 배송지 변경이 가능하다)
     */
    private void verifyNotYetShippiingCompleted() {
        if (state != OrderState.BEFORE && state != OrderState.PAYMENT_WAITING && state != OrderState.PRODUCT_PREPARING)
            throw new IllegalStateException("Already Shipping-Completed");
    }

    /*
     * 전체 주문금액을 계산한다.
     */
    private void calculateTotalAmounts() {
        // 총 주문금액은 OrderLines를 통해 값이 계산된다. (주문 애그리거트 내부의 주문항목 객체를 조합하여 총주문금액 계산 기능이 완성된다.)
        this.totalAmounts = orderLines.stream()
                .map(OrderLine::getAmounts)
                .reduce(0, (a, b) -> a + b);
    }

    @Override
    public boolean equals(Object obj) {
        // 같은 객체라면 O
        if (this == obj) return true;
        if (obj == null) return false;
        // 클래스타입이 다르면 X
        if (obj.getClass() != Order.class) return false;
        Order other = (Order) obj;
        // 주문번호가 없으면 X
        if (this.orderNumber == null || this.orderNumber.isEmpty()) return false;
        // 객체는 다르지만, 클래스타입이 갖고 주문번호가 일치하다면 동일한 주문으로 인정한다.
        return this.orderNumber.equals(other.orderNumber);
    }

    @Override
    public int hashCode() {
        final int prime = 31; // Integer.MAX < 2^32
        int result = 1;
        result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
        return result;
    }
}
