package com.chpark.shop.domain;

import com.chpark.shop.order.domain.OrderLine;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestOrder {
    @Test
    public void testTotalAmounts() {
        List<OrderLine> orderLineList = new ArrayList<>();
        orderLineList.add(new OrderLine(null, 1000, 2));
        orderLineList.add(new OrderLine(null, 5000, 1));

        int totalAmounts = orderLineList.stream().map(OrderLine::getAmounts).reduce(0, (a, b) -> a + b);
        Assert.assertEquals(totalAmounts, 1000 * 2 + 5000);
    }
}
