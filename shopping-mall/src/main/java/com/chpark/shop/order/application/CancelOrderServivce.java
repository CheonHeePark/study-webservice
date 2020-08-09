package com.chpark.shop.order.application;

import com.chpark.shop.order.domain.Order;
import com.chpark.shop.order.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 주문 취소를 위한 응용 서비스
 * TODO 실제 구현은 추후..
 */
@RequiredArgsConstructor
@Service
public class CancelOrderServivce {
    private final OrderRepository orderRepository;

    @Transactional
    public void cancel(String orderNumber, String canceler) {
        // 주문을 가져온다.
        Order order = findOrder(orderNumber);
        // TODO 주문취소자(구매자)의 유효성 검사(권한이 있는지 등등)

        // 다 완료되면 취소처리
        order.cancel();
    }

    private Order findOrder(String orderNumber) {
        Order order = orderRepository.findById(orderNumber)
                .orElseThrow(() -> new IllegalArgumentException("Wrong orderNumber:<" + orderNumber + ">"));
        return order;
    }
}
