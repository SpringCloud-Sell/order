/*
 * 文件名称：CodeEnum.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180730 08:10
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180730-01         Rushing0711     M201807300810 新建文件
 ********************************************************************************/
package com.coding.order.enums;

public interface CodeEnum<T> {
    T getCode();

    String getMsg();
}
