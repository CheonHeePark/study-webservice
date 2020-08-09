package com.chpark.shop.order.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 배송 정보
 */
@Getter
@AllArgsConstructor
public
class ShippingInfo {
    private String address;
    private String message;
    private Receiver receiver;
}
