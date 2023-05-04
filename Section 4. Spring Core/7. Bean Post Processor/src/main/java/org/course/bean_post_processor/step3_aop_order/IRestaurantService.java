package org.course.bean_post_processor.step3_aop_order;


interface IRestaurantService {

    void order(String food);
    void order2(String food);

    void myInit();
}
