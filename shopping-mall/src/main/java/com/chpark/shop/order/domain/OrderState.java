package com.chpark.shop.order.domain;

public enum OrderState {
    BEFORE,
    PAYMENT_WAITING,
    PRODUCT_PREPARING,
    SHIPPING_COMPLETED,
    DELIVERING,
    DELIVERY_COMPLETED,
    CANCELED,
}
