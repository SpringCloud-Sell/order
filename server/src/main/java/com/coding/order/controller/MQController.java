/*
 * 文件名称：MQController.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180813 08:15
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180813-01         Rushing0711     M201808130815 新建文件
 ********************************************************************************/
package com.coding.order.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/mq")
public class MQController {

    @Autowired private AmqpTemplate amqpTemplate;

    @GetMapping("/send1")
    public void send1() {
        amqpTemplate.convertAndSend("myQueue1", "now " + new Date());
    }

    @GetMapping("/send2")
    public void send2() {
        amqpTemplate.convertAndSend("myQueue2", "now " + new Date());
    }

    @GetMapping("/send3")
    public void send3() {
        amqpTemplate.convertAndSend("myQueue3", "now " + new Date());
    }

    @GetMapping("/sendComputer")
    public void sendComputer() {
        amqpTemplate.convertAndSend("myOrderExchange", "computer", "now " + new Date());
    }
}
