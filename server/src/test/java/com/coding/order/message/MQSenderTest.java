/*
 * 文件名称：MQSenderTest.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180812 14:32
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180812-01         Rushing0711     M201808121432 新建文件
 ********************************************************************************/
package com.coding.order.message;

import com.coding.order.OrderApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 发送MQ消息测试.
 *
 * <p>创建时间: <font style="color:#00FFFF">20180812 14:35</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class MQSenderTest extends OrderApplicationTests {

    @Autowired private AmqpTemplate amqpTemplate;

    @Test
    public void send1() {
        amqpTemplate.convertAndSend("myQueue1", "now " + new Date());
    }

    @Test
    public void send2() {
        amqpTemplate.convertAndSend("myQueue2", "now " + new Date());
    }

    @Test
    public void send3() {
        amqpTemplate.convertAndSend("myQueue3", "now " + new Date());
    }

    @Test
    public void sendComputer() {
        amqpTemplate.convertAndSend("myOrderExchange", "computer", "now " + new Date());
    }
}
