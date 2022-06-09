package com.study.springcloud.controller;

import com.study.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        return paymentService.paymentInfo(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentTimeOut(@PathVariable("id") Integer id) {
        return paymentService.paymentTimeOut(id);
    }

    // ============ 服务熔断
    @GetMapping("/payment/hystrix/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        return paymentService.paymentCircuitBreaker(id);
    }
}
