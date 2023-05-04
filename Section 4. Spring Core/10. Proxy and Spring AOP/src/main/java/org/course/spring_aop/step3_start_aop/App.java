package org.course.spring_aop.step3_start_aop;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configurable
class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class.getPackageName());

        IRestaurantService restaurantService = context.getBean(IRestaurantService.class);
        System.out.println("restaurantService class: " + restaurantService.getClass());

        System.out.println(restaurantService.order("Pizza"));
        System.out.println("--------------------------------------------------");
        System.out.println(restaurantService.order("Pizza"));

        System.out.println(context.getBean("menuOrder", MenuOrder.class));

    }

}
