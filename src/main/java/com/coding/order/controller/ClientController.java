/*
 * 文件名称：ClientController.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180803 07:19
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180803-01         Rushing0711     M201808030719 新建文件
 ********************************************************************************/
package com.coding.order.controller;

import com.coding.order.client.ProductClient;
import com.coding.order.dataobject.ProductInfo;
import com.coding.order.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientController {

    @Autowired private ProductClient productClient;

    /** 第四种方式 */
    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        String response = productClient.productMsg();
        log.info("response={}", response);
        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList() {
        List<ProductInfo> productInfoList =
                productClient.listForOrder(Arrays.asList("10000001", "10000002"));
        log.info("response={}", productInfoList);
        return "ok";
    }

    @GetMapping("/productDecreaseStock")
    public String productDecreaseStock() {
        productClient.decreaseStock(Arrays.asList(new CartDTO("10000001", 5)));
        return "ok";
    }

    @Autowired private LoadBalancerClient loadBalancerClient;

    /** 第一种方式（直接使用restTemplate，url写死） */
    @GetMapping("/getProductMsg1")
    public String getProductMsg1() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://localhost:8751/msg", String.class);
        log.info("response={}", response);
        return response;
    }

    /** 第二种方式（利用loadBalancerClient通过应用名称获取url，再使用restTemplate） */
    @GetMapping("/getProductMsg2")
    public String getProductMsg2() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url =
                String.format(
                        "http://%s:%s/msg", serviceInstance.getHost(), serviceInstance.getPort());

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);
        return response;
    }

    @Autowired private RestTemplate restTemplate;

    /** 第三种方式（利用@LoadBalanced，可在restTemplate里使用应用名称） */
    @GetMapping("/getProductMsg3")
    public String getProductMsg3() {
        String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
        log.info("response={}", response);
        return response;
    }
}
