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

import com.coding.order.converter.OrderForm2OrderDTOConverter;
import com.coding.order.dto.OrderDTO;
import com.coding.order.enums.ResultEnum;
import com.coding.order.exception.OrderException;
import com.coding.order.form.OrderForm;
import com.coding.order.service.OrderService;
import com.coding.order.utils.ResultVOUtil;
import com.coding.order.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired private OrderService orderService;

    public ResultVO create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        // 1.参数校验
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确，orderForm={}", orderForm);
            throw new OrderException(
                    ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());

        return ResultVOUtil.success(map);

        // 2.查询商品信息（调用商品服务）
        // 3.计算总价
        // 4.扣库存（调用商品服务)
        // 5.订单入库
    }
}
