package org.course.basic_annotations_2.step6_qualifier_annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class.getPackageName());

        context.getBean(IRestaurantService.class).order("Pizza");
        context.getBean(IRestaurantService.class).order("Pizza");

    }

    @Bean
    @FastCookQualifier
    @CookQualifier
    public Cook fastCook() {
        return new FastCook();
    }

    @Bean
    @SlowCookQualifier
    public Cook slowCook() {
        return new SlowCook();
    }



}
