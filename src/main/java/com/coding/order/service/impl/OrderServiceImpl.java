/*
 * 文件名称：OrderServiceImpl.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180731 08:16
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180731-01         Rushing0711     M201807310816 新建文件
 ********************************************************************************/
package com.coding.order.service.impl;

import com.coding.order.dataobject.OrderMaster;
import com.coding.order.dto.OrderDTO;
import com.coding.order.enums.OrderStatusEnum;
import com.coding.order.enums.PayStatusEnum;
import com.coding.order.repository.OrderDetailRepository;
import com.coding.order.repository.OrderMasterRepository;
import com.coding.order.service.OrderService;
import com.coding.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired private OrderDetailRepository detailRepository;

    @Autowired private OrderMasterRepository masterRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        // TODO: 2018/7/31 查询商品信息（调用商品服务）

        // TODO: 2018/8/1 计算总价

        // TODO: 2018/8/1 扣库存（调用商品服务）

        // 订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.getUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        masterRepository.save(orderMaster);
        return orderDTO;
    }
}
