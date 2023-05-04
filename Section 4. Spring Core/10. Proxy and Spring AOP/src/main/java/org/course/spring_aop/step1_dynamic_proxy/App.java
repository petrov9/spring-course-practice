package org.course.spring_aop.step1_dynamic_proxy;

import java.lang.reflect.Proxy;

public class App {

    public static void main(String[] args) {
        //case 1
//        RestaurantService restaurantService1 = new RestaurantService();
//        restaurantService1.order("Pizza");

        //case 2
        RestaurantService restaurantService2 = new RestaurantService();
        IRestaurantService restaurantProxy = (IRestaurantService) Proxy.newProxyInstance(
            App.class.getClassLoader(),
            new Class[] { IRestaurantService.class },
            (proxy, method, args1) -> {
                System.out.println("[proxy] before");
                method.invoke(restaurantService2, args1);
                System.out.println("[proxy] after");
                return null;
            }
        );
        restaurantProxy.order("Pizza");

    }
}
