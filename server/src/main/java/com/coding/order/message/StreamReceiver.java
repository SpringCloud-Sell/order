/*
 * 文件名称：StreamReceiver.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180812 15:50
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180812-01         Rushing0711     M201808121550 新建文件
 ********************************************************************************/
package com.coding.order.message;

import com.coding.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * 定义stream的监听事件.
 *
 * <p>创建时间: <font style="color:#00FFFF">20180814 07:54</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    @StreamListener(value = StreamClient.INPUT)
    @SendTo(StreamClient.OUTPUT)
    public String process1(Object message) {
        log.info("StreamReceiver1: {}", message);
        return "received.";
    }

    // 接收orderDTO对象
    @StreamListener(value = StreamClient.OUTPUT)
    public void process2(OrderDTO message) {
        log.info("StreamReceiver2: {}", message);
    }
}
