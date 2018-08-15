/*
 * 文件名称：StreamClient.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180812 15:48
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180812-01         Rushing0711     M201808121548 新建文件
 ********************************************************************************/
package com.coding.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 这里定义的@Input和@Output都会生成对应名称的Exchanges，并且@Input会生成同名开头的Queue，@Output会生成SpringCloudBus开头的Queue.
 *
 * <p>创建时间: <font style="color:#00FFFF">20180814 07:36</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
public interface StreamClient {

    String INPUT = "streamInput";

    String OUTPUT = "streamOutput";

    /** 消息消费者. */
    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    /** 消息生产者. */
    @Output(StreamClient.OUTPUT)
    MessageChannel output();
}
