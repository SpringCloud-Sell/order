package com.coding.order.repository;

import com.coding.order.OrderApplicationTests;
import com.coding.order.dataobject.OrderDetail;
import com.coding.order.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;

import static org.junit.Assert.*;

@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests {

    @Autowired private OrderDetailRepository repository;

    private static final String DEFAULT_PRODUCT_ID = "10000001";

    @Test
    @Transactional
    public void testSave() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId(KeyUtil.getUniqueKey());
        orderDetail.setOrderId(KeyUtil.getUniqueKey());
        orderDetail.setProductIcon("http://xxxxx.jpg");
        orderDetail.setProductId(DEFAULT_PRODUCT_ID);
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(2.2));
        orderDetail.setProductQuantity(3);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }
}
