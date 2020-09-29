package com.lgl.simpleframework.lgl.controller;

import com.lgl.simpleframework.framework.core.annotation.Controller;
import com.lgl.simpleframework.framework.inject.annotation.Autowired;
import com.lgl.simpleframework.lgl.service.HelloService;
import lombok.Data;

/**
 * <p>
 * description
 * </p>
 *
 * @author lgl 2020/09/29 14:47
 * @since 1.0
 */
@Data
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    public void sayHello(){
        helloService.doSay();
    }

}
