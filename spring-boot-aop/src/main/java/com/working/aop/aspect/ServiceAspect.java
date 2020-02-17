package com.working.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component // bu classin ioc container'da initialize olmasi icin
public class ServiceAspect {

    @Before(value = "execution(* com.working.aop.service.*.getMessage(..))")
    public void beforeGetMessageBefore(JoinPoint joinPoint){
        //Joinpoint o anki state'i yakalar.
        System.out.println("The parameter caught before getMessage method." + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

    @After(value = "execution(* com.working.aop.service.*.getMessage(..))")
    public void afterGetMessageBefore(JoinPoint joinPoint){
        System.out.println("The parameter caught after getMessage method." + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }
}
