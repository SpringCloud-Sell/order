package com.coding.order.repository;

import com.coding.order.OrderApplicationTests;
import com.coding.order.dataobject.OrderMaster;
import com.coding.order.enums.OrderStatusEnum;
import com.coding.order.enums.PayStatusEnum;
import com.coding.order.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired private OrderMasterRepository repository;

    private static final String OPENID = "110110";

    @Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(KeyUtil.getUniqueKey());
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("12345678900");
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.3));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }
}
