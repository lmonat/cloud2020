package com.study.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo(Integer id) {
        return "PaymentFallbackService paymentInfo o(╥﹏╥)o";
    }

    @Override
    public String paymentTimeOut(Integer id) {
        return "PaymentFallbackService paymentTimeOut o(╥﹏╥)o";
    }
}
