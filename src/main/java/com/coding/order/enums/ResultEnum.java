/*
 * 文件名称：ResultEnum.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180801 08:03
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180801-01         Rushing0711     M201808010803 新建文件
 ********************************************************************************/
package com.coding.order.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    /** 0 - 成功. */
    SUCCESS(0, "成功"),
    /** 1- 参数不正确. */
    PARAM_ERROR(1, "参数不正确"),
    /** 2 - 购物车不能为空. */
    CART_EMPTY(2, "购物车不能为空"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
