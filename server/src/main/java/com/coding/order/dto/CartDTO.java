/*
 * 文件名称：CartDTO.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180804 07:23
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180804-01         Rushing0711     M201808040723 新建文件
 ********************************************************************************/
package com.coding.order.dto;

import lombok.Data;

@Data
public class CartDTO {

    /** 商品ID. */
    private String productId;

    /** 商品数量. */
    private Integer productQuantity;

    public CartDTO() {}

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
