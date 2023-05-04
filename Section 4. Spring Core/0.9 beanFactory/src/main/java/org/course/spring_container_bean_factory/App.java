package org.course.spring_container_bean_factory;

import java.util.UUID;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;


//@Configuration
public class App {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory1 = new DefaultListableBeanFactory();

        //case 1
        /*beanFactory1.registerSingleton("myStr", new String("Hello World!"));
        String myStr = (String) beanFactory1.getBean("myStr");
        System.out.println(myStr);*/

        // case 2, бин в консруктор, и новый обьект в консруктор
        /*beanFactory1.registerSingleton("fastCook", new FastCook());
        FastCook fastCook = beanFactory1.getBean(FastCook.class);
        beanFactory1.registerSingleton("restaurantService", new RestaurantService(fastCook));
        RestaurantService restaurantService = beanFactory1.getBean(RestaurantService.class);
        restaurantService.cook("Pizza");*/

        // case 3
        /*DefaultListableBeanFactory beanFactory2 = new DefaultListableBeanFactory();
        beanFactory2.registerSingleton("fastCook", new FastCook());
        fastCook = beanFactory2.getBean(FastCook.class);
        beanFactory2.registerSingleton("restaurantService", new RestaurantService(fastCook));
        restaurantService = beanFactory2.getBean(RestaurantService.class);
        restaurantService.cook("Pizza");*/

        // case 4 xml
        /*DefaultListableBeanFactory beanFactory4 = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory4);
        ClassPathResource resource = new ClassPathResource("applicationContext.xml");
        xmlBeanDefinitionReader.loadBeanDefinitions(resource);

        FastCook fastCook = beanFactory4.getBean(FastCook.class);
        beanFactory4.registerSingleton("restaurantService", new RestaurantService(fastCook));
        RestaurantService restaurantService = beanFactory4.getBean(RestaurantService.class);
        restaurantService.cook("Pizza");*/

        // case 5 java config
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
        ClassPathResource resource = new ClassPathResource("applicationContext.xml");
        xmlBeanDefinitionReader.loadBeanDefinitions(resource);



        FastCook fastCook = beanFactory.getBean(FastCook.class);
        beanFactory.registerSingleton("restaurantService", new RestaurantService(fastCook));
        RestaurantService restaurantService = beanFactory.getBean(RestaurantService.class);
        restaurantService.cook("Pizza");


    }

    static class RestaurantService {

        private FastCook fastCook;

        public RestaurantService(FastCook fastCook) {
            System.out.println("Я ресторан " + UUID.randomUUID().toString());
            this.fastCook = fastCook;
        }

        public void cook(String food) {
            fastCook.cook(food);
        }
    }

    static class FastCook {

        public FastCook() {
            System.out.println("Я повар " + UUID.randomUUID().toString());
        }

        public void cook(String food) {
            System.out.println("Cooking " + food);
        }
    }
}
