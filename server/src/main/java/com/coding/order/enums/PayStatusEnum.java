/*
 * 文件名称：PayStatusEnum.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180730 08:15
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180730-01         Rushing0711     M201807300815 新建文件
 ********************************************************************************/
package com.coding.order.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum implements CodeEnum<Integer> {
    /** 0-等待支付. */
    WAIT(0, "等待支付"),
    /** 1-支付成功. */
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;

    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
