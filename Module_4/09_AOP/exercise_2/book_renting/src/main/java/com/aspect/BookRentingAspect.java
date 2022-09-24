package com.aspect;

import com.service.ITrafficService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BookRentingAspect {
    @Autowired
    private ITrafficService trafficService;

    @AfterReturning(pointcut = " execution(public * com.controller.BookController.*(..)) ")
    public void logHistory(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("The " + name + " method just worked");
    }

    @After(" execution(public * com.controller.BookController.showHome(..)), && args(showDetail(..)) ")
    public void increaseTraffic(JoinPoint joinPoint) {
        trafficService.increase();
    }
}
