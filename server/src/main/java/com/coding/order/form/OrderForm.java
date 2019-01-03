/*
 * 文件名称：OrderForm.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180801 07:50
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180801-01         Rushing0711     M201808010750 新建文件
 ********************************************************************************/
package com.coding.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class OrderForm {

    /** 买家姓名 */
    @NotEmpty(message = "姓名必填")
    private String name;

    /** 买家手机号. */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /** 买家地址. */
    @NotEmpty(message = "地址必填")
    private String address;

    /** 买家微信openid. */
    @NotEmpty(message = "openid必填")
    private String openid;

    /** 购物车. */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
