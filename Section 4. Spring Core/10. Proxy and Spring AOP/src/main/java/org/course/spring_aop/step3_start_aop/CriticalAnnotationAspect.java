package org.course.spring_aop.step3_start_aop;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CriticalAnnotationAspect {


    @Pointcut("@annotation(org.course.spring_aop.step1_start_aop.Critical)")
    public void criticalAnnotationMethod(){}

    @SneakyThrows
    @Around("criticalAnnotationMethod()")
    public String aroundOrder(ProceedingJoinPoint pjp) {

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        String methodName = signature.getName();

        Critical annotation = signature.getMethod().getAnnotation(Critical.class);
        long maxExecuteTime = annotation.maxTime();

        long start = System.currentTimeMillis();
        Object returnedObject = pjp.proceed();
        long end = System.currentTimeMillis();

        if (end - start > maxExecuteTime) {
            System.out.println("метод: " + methodName + " выполнялся слишком долго: " + (end - start) + " ms, максимально допустимое время: " + maxExecuteTime + " "
                + "ms");
        }


        return "Ваш заказ готов от аспекта";
    }
}
