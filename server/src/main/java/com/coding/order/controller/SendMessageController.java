/*
 * 文件名称：SendMessageController.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180812 15:52
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180812-01         Rushing0711     M201808121552 新建文件
 ********************************************************************************/
package com.coding.order.controller;

import com.coding.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SendMessageController {

    @Autowired private StreamClient streamClient;

    @GetMapping("sendMessage")
    public void process() {
        String message = "now " + new Date();
        streamClient.output().send(MessageBuilder.withPayload(message).build());
    }
}
