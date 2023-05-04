package org.course.spring_aop.step3_start_aop;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
//@Component
public class RestaurantServiceAspect {

    public RestaurantServiceAspect() {
        System.out.println("Создан аспект: " + this.getClass());
    }

    @Pointcut("execution(public * order(String))")
    public void orderMethod(){}

    @Before("orderMethod()")
    public void beforeOrder() {
        System.out.println("Aspect: beforeOrder");
        System.out.println("aspect class: " + this.getClass());
    }

    @After("orderMethod()")
    public void afterOrder() {
        System.out.println("Aspect: afterOrder");
    }

    @AfterReturning(value = "orderMethod()", returning = "result")
    public void afterReturningOrder(Object result) {
        System.out.println("Aspect: afterReturningOrder");
        System.out.println("result: " + result);
    }

    @AfterThrowing("orderMethod()")
    public void afterThrowingOrder() {
        System.out.println("Aspect: afterThrowingOrder");
    }

    @SneakyThrows
    @Around("orderMethod()")
    public String aroundOrder(ProceedingJoinPoint pjp) {
        System.out.println("Aspect: aroundOrder");
        System.out.println("pjp: " + pjp.proceed());

        return "Ваш заказ готов от аспекта";
    }
}
