package com.adel.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class CustomAspect {

    @Around("@annotation(com.adel.spring.aop.annotation.LogExecTime)")
    public Object logExecTime(final ProceedingJoinPoint point) throws Throwable {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        final Object pt = point.proceed();

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

        return pt;
    }

}
