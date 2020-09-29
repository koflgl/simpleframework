package com.lgl.simpleframework.annotation;

import com.lgl.simpleframework.framework.core.BeanContainer;
import com.lgl.simpleframework.framework.inject.annotation.DependencyInjector;
import com.lgl.simpleframework.lgl.controller.HelloController;
import com.lgl.simpleframework.lgl.service.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <p>
 * description
 * </p>
 *
 * @author lgl
 * @since 1.0
 */
public class DependencyTest {

    @Test
    @DisplayName("测试依赖注入")
    void doIocTest() {
        BeanContainer container = BeanContainer.getInstance();
        container.loadBeans("com.lgl.simpleframework.lgl");
        Assertions.assertEquals(true, container.isLoaded());
        HelloController helloController = (HelloController) container.getBean(HelloController.class);
        Assertions.assertEquals(true, helloController instanceof HelloController);
        HelloService helloService = helloController.getHelloService();
        Assertions.assertEquals(null, helloService);
        new DependencyInjector().doIoc();
        Assertions.assertNotEquals(null,helloController.getHelloService());
    }
}
