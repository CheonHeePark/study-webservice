package com.chpark.shop.domain;

import com.chpark.shop.order.domain.Order;
import com.chpark.shop.order.domain.OrderLine;
import com.chpark.shop.order.domain.Receiver;
import com.chpark.shop.order.domain.ShippingInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestOrder {
    List<OrderLine> orderLineList;
    @Before
    public void init() {
      orderLineList = new ArrayList<>();
    }

    @Test
    public void testTotalAmounts() {
        System.out.println("testTotalmounts");
        List<OrderLine> orderLineList = new ArrayList<>();
        orderLineList.add(new OrderLine(null, 1000, 2));
        orderLineList.add(new OrderLine(null, 5000, 1));

        int totalAmounts = orderLineList.stream().map(OrderLine::getAmounts).reduce(0, (a, b) -> a + b);
        Assert.assertEquals(totalAmounts, 1000 * 2 + 5000);
    }

    @Test
    public void testChangeShippingInfo() {
        System.out.println("testChangeShippingInfo");
        ShippingInfo shippingInfo = new ShippingInfo("Suwon-si, Yeongtong-gu", "Nothing", new Receiver("chpark", "00-1111-1111"));
        orderLineList.add(new OrderLine(null, 1000, 2));
        orderLineList.add(new OrderLine(null, 5000, 1));
        Order order = new Order(orderLineList, shippingInfo);
        ShippingInfo newShippingInfo = new ShippingInfo("Seoul-si, Gangnam-gu", "MyHome", new Receiver("chpark", "00-1111-1111"));
        order.changeShippingInfo(newShippingInfo);
        Assert.assertEquals(order.getShippingInfo().getAddress(), "Seoul-si, Gangnam-gu");
    }
}
