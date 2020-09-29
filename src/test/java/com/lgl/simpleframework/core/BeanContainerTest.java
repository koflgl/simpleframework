package com.lgl.simpleframework.core;


import com.lgl.simpleframework.framework.core.BeanContainer;
import com.lgl.simpleframework.framework.core.annotation.Controller;
import com.lgl.simpleframework.lgl.controller.HelloController;
import com.lgl.simpleframework.lgl.service.HelloService;
import com.lgl.simpleframework.lgl.service.impl.HelloServiceImpl;
import org.junit.jupiter.api.*;


/**
 * <p>
 * description
 * </p>
 *
 * @author lgl
 * @since 1.0
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BeanContainerTest {
    private static BeanContainer beanContainer;

    @BeforeAll
    static void init() {
        beanContainer = BeanContainer.getInstance();
    }

    @Test
    @Order(1)
    public void loadBeansTest() {
        Assertions.assertEquals(false, beanContainer.isLoaded());
        beanContainer.loadBeans("com.lgl.simpleframework.lgl");
        System.out.println(beanContainer.size());
    }

    /**
     * getBean
     */
    @Test
    @Order(2)
    @DisplayName("根据类获取实例：getBeanTest")
    public void getBeansTest() {
        beanContainer.loadBeans("com.lgl.simpleframework.lgl");
        HelloController helloController = (HelloController) beanContainer.getBean(HelloController.class);
        System.out.println(helloController);
        Assertions.assertEquals(true, helloController instanceof HelloController);
        HelloService helloService = (HelloService) beanContainer.getBean(HelloServiceImpl.class);
        System.out.println(helloService);
        Assertions.assertEquals(null, helloService);
    }

    @Test
    @Order(3)
    @DisplayName("根据注解获取实例")
    public void getClassByAnnotationTest() {
        beanContainer.loadBeans("com.lgl.simpleframework.lgl");
        Assertions.assertEquals(true, beanContainer.isLoaded());
        Assertions.assertEquals(1, beanContainer.getClassesByAnnotation(Controller.class).size());
    }

    @Test
    @DisplayName("根据接口获取实例")
    @Order(4)
    public void getClassBySuperClass() {
        beanContainer.loadBeans("com.lgl.simpleframework.lgl");
        Assertions.assertEquals(true,beanContainer.isLoaded());
        Assertions.assertEquals(true,beanContainer.getClassesBySuper(HelloService.class).contains(HelloServiceImpl.class));
    }
}
