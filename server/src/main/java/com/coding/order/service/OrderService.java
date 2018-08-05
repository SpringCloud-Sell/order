/*
 * 文件名称：OrderService.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180731 08:11
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180731-01         Rushing0711     M201807310811 新建文件
 ********************************************************************************/
package com.coding.order.service;

import com.coding.order.dto.OrderDTO;

public interface OrderService {

    /**
     * 创建订单.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180731 08:15</font><br>
     * [请在此输入功能详述]
     *
     * @param orderDTO -
     * @return com.coding.order.dto.OrderDTO
     * @author Rushing0711
     * @since 1.0.0
     */
    OrderDTO create(OrderDTO orderDTO);
}
