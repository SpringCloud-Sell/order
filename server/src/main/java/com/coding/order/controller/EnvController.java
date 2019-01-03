/*
 * 文件名称：EnvController.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180811 12:07
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180811-01         Rushing0711     M201808111207 新建文件
 ********************************************************************************/
package com.coding.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("env")
@RefreshScope
public class EnvController {

    @Value("${env}")
    private String env;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eureka;

    @GetMapping("/print")
    public String print() {
        return String.format("env=%s,eureka=%s", env, eureka);
    }
}
