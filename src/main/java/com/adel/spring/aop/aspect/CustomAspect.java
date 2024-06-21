package com.adel.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class CustomAspect {

    //Just @Aspect
    @Around("@annotation(com.adel.spring.aop.annotation.LogExecTime)")
    public Object logExecTime(final ProceedingJoinPoint point) throws Throwable {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.currentTaskName();
        stopWatch.start(point.toLongString());

        final Object pt = point.proceed();

        stopWatch.stop();
        log.info(stopWatch.prettyPrint());

        return pt;
    }

    //---------------------------------------------------------------------------------

//    @Pointcut("execution(* com.adel.spring.aop.AopApplication.run(..))")
//    public void onRun(){}
//
//    @Pointcut("onRun()")
//    public void joinPointCut(){}
//
//    @Around("joinPointCut()")
//    public Object logSomething(final ProceedingJoinPoint point) throws Throwable {
//        System.out.println("START PIN");
//        final Object proceed = point.proceed();
//        System.out.println("END PIN");
//        return proceed;
//    }



}
