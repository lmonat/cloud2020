package com.study.springcloud.controller;

import com.study.springcloud.entities.CommonResult;
import com.study.springcloud.entities.Payment;
import com.study.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @PostMapping("/consumer/payment/create")
    public CommonResult creat(@RequestBody Payment payment) {
        return paymentFeignService.creat(payment);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }
}
