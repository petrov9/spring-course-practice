package org.course.bean_post_processor.step1_post_construct_dynamic_proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

@Component
public class MyBPP implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (!beanName.equals("restaurantService")) {
            return bean;
        }

        System.out.println("work before init, bean: " + bean.getClass() + ", bean name: " + beanName);

        boolean isDynamic = true;
        Object proxyBean = null;

        if (isDynamic) {
            proxyBean = Proxy.newProxyInstance(this.getClass().getClassLoader(), bean.getClass().getInterfaces(), (proxy, method, args) -> {
                System.out.println("before method: " + method.getName());
                Object invoke = method.invoke(bean, args);
                System.out.println("after method: " + method.getName());
                return invoke;
            });
        } else {
                Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(RestaurantService.class);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    System.out.println("before method: " + method.getName());
                    Object invoke = method.invoke(bean, args);
                    System.out.println("after method: " + method.getName());
                    return invoke;
                }
            });

            System.out.println("before enhancer create");
            proxyBean = enhancer.create();
            System.out.println("after enhancer create");
        }

        return proxyBean;

//        return bean;

    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (!beanName.equals("restaurantService")) {
            return bean;
        }

        System.out.println("work after init, bean: " + bean.getClass() + ", bean name: " + beanName);
        return bean;
    }
}
