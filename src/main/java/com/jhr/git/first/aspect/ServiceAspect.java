package com.jhr.git.first.aspect;

import com.jhr.git.first.util.PerformanceTools;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author jinhuari
 * date: 2017/12/5
 */
@Aspect
@Component
public class ServiceAspect {

    @Pointcut("@target(org.springframework.stereotype.Service) " +
            "&& execution(public * com.jhr..*.*(..))" +
            " &&(this(com.jhr.git.first.service.BusinessService) || this(com.jhr.git.first.service.DomainService))")
    public void serviceAspect() {

    }



    @Around("serviceAspect()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result;
        String methodName = point.getSignature().getName();
        Class<?> classTarget = point.getTarget().getClass();
        Long start = System.currentTimeMillis();

        try {
            //执行目标方法
            result = point.proceed();
        } catch (Throwable e) {
            throw e;
        } finally {
            Long spendTime = System.currentTimeMillis() - start;
            PerformanceTools.logMethodPerformance("SERVICE", classTarget.getSimpleName(), methodName, spendTime);
        }
        return result;
    }
}
