/*
 * 文件名称：OrderController.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180731 08:08
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180731-01         Rushing0711     M201807310808 新建文件
 ********************************************************************************/
package com.coding.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    public void create() {
        // 1.参数校验
        // 2.查询商品信息（调用商品服务）
        // 3.计算总价
        // 4.扣库存（调用商品服务)
        // 5.订单入库
    }
}
