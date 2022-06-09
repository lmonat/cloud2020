package com.study.springcloud.controller;

import com.study.springcloud.entities.CommonResult;
import com.study.springcloud.entities.Payment;
import com.study.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    // 不添加@RequestBody注解 无法接受到order发送过来的数据
    @PostMapping("/payment/create")
    public CommonResult creat(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        log.info("插入结果成功");
        if (i > 0) {
            return new CommonResult(200, "插入成功，serverPort：" + serverPort, i);
        }

        return new CommonResult(500, "插入失败，serverPort：" + serverPort);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询成功");
        if (payment != null) {
            return new CommonResult(200, "查询成功，serverPort：" + serverPort, payment);
        }

        return new CommonResult(500, "没有对应记录，serverPort：" + serverPort);
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
