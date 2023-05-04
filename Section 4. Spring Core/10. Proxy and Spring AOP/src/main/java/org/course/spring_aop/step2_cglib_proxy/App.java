package org.course.spring_aop.step2_cglib_proxy;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class App {

    public static void main(String[] args) {
        RestaurantService restaurantService = new RestaurantService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RestaurantService.class);
        enhancer.setCallback((org.springframework.cglib.proxy.MethodInterceptor) (obj, method, args1, proxy) -> {
            System.out.println("[proxy] before");
            Object invoke = method.invoke(restaurantService, args1);
            System.out.println("[proxy] after");
            return invoke;
        });

        RestaurantService restaurantProxy = (RestaurantService) enhancer.create();
        restaurantProxy.order("Pizza");

    }
}
