package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "thread pool: " + Thread.currentThread().getName() + " paymentInfo_OK, id " + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_Timeout(Integer id) {
        int timeout = 5;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "thread pool: " + Thread.currentThread().getName() + " paymentInfo_Timeout, id " + id + "\t consume " + timeout + " seconds";
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        return "thread pool: " + Thread.currentThread().getName() + " system busy, please retry later. id " + id + "\t o(0_0)o";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_ExceptionHandler")
    public String paymentInfo_Exception() {
        throw new RuntimeException();
    }

    public String paymentInfo_ExceptionHandler() {
        return "thread pool: " + Thread.currentThread().getName() + " system error. \t o(0_0)o";
    }

}
