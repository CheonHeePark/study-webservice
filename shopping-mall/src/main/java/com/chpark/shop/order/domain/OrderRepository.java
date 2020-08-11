package com.chpark.shop.order.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {
    // 특정 주문자가 주문한 OrderList를 가져온다.
    @Query(value = "SELECT * FROM TB_Order where orderer_id = ?1", nativeQuery = true)
    List<Order> findByOrdererId(String ordererId);
}
