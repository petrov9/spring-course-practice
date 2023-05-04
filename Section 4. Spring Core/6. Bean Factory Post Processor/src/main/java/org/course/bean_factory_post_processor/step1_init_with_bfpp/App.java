package org.course.bean_factory_post_processor.step1_init_with_bfpp;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class.getPackageName());

        context.getBean(RestaurantService.class).order("Pizza");
    }

    @PostConstruct
    public  void ss() {
        System.out.println("ss");
    }


    @Bean
    public static BeanFactoryPostProcessor initMethodFactoryPostProcessor(){
        return new InitMethodFactoryPostProcessor();
    }

}
