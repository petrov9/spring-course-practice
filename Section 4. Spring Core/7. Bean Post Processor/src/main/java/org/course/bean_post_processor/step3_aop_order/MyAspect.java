package org.course.bean_post_processor.step3_aop_order;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Pointcut("execution(* org.course.bean_post_processor.step3_aop_order.RestaurantService.order*(String))")
    public void orderMethod() {}
    @After("orderMethod()")
    public void afterOrder() {
        System.out.println("Заказ выполнен");
    }

}
