package com.adel.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class CustomAspect {

    //Just @Aspect
    @Around("@annotation(com.adel.spring.aop.annotation.LogExecTime)")
    public Object logExecTime(final ProceedingJoinPoint point) throws Throwable {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        final Object pt = point.proceed();

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

        return pt;
    }

    //---------------------------------------------------------------------------------

    @Pointcut("@target(com.adel.spring.aop.AopApplication)")
    public void aopApplication(){}

    @Pointcut("execution(* *..run(..))")
    public void onRun(){}

    @Pointcut("aopApplication() && onRun()")
    public void joinPointCut(){}

    @Around("joinPointCut()")
    public Object logSomething(final ProceedingJoinPoint point) throws Throwable {
        System.out.println("START PIN");
        final Object proceed = point.proceed();
        System.out.println("END PIN");
        return proceed;
    }



}
