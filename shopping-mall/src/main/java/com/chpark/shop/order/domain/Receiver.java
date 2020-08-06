package com.chpark.shop.order.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 수신자
 */
@Getter
@AllArgsConstructor
class Receiver {
    private String name;
    private String phone;
}
