/*
 * 文件名称：OrderForm2OrderDTOConverter.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180801 08:08
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180801-01         Rushing0711     M201808010808 新建文件
 ********************************************************************************/
package com.coding.order.converter;

import com.coding.order.dataobject.OrderDetail;
import com.coding.order.dto.OrderDTO;
import com.coding.order.enums.ResultEnum;
import com.coding.order.exception.OrderException;
import com.coding.order.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList;
        try {
            orderDetailList =
                    gson.fromJson(
                            orderForm.getItems(), new TypeToken<List<OrderDetail>>() {}.getType());
        } catch (JsonSyntaxException e) {
            log.error("【JSON转换错误】错误,string={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
