/*
 * 文件名称：MQReceiver.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180812 14:30
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180812-01         Rushing0711     M201808121430 新建文件
 ********************************************************************************/
package com.coding.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收MQ消息.
 *
 * <p>创建时间: <font style="color:#00FFFF">20180812 14:32</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
@Slf4j
public class MQReceiver {

    /** 第一种：myQueue这个队列必须事先存在. */
    @RabbitListener(queues = "mqQueue1")
    public void process1(String message) {
        log.info("MQReceiver1: {}", message);
    }

    /** 第二种：自动创建队列. */
    @RabbitListener(queuesToDeclare = @Queue("mqQueue2"))
    public void process2(String message) {
        log.info("MQReceiver2: {}", message);
    }

    /** 第三种：自动创建队列，Exchanges和Queues绑定. */
    @RabbitListener(
        bindings = @QueueBinding(value = @Queue("mqQueue3"), exchange = @Exchange("mqExchange3"))
    )
    public void process3(String message) {
        log.info("MQReceiver3: {}", message);
    }

    @RabbitListener(
        bindings =
                @QueueBinding(
                    exchange = @Exchange("mqOrderExchange"),
                    value = @Queue("computerQueue"),
                    key = "computer"
                )
    )
    public void processComputer(String message) {
        log.info("computer MQReceiver: {}", message);
    }

    @RabbitListener(
        bindings =
                @QueueBinding(
                    exchange = @Exchange("mqOrderExchange"),
                    value = @Queue("fruitQueue"),
                    key = "fruit"
                )
    )
    public void processFruit(String message) {
        log.info("fruit MQReceiver: {}", message);
    }
}
