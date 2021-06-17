package com.nevertrouble.demo.aopdebug.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Around("execution(* com.nevertrouble.demo.aopdebug.service..*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = point.proceed();
        return result;
    }

}
