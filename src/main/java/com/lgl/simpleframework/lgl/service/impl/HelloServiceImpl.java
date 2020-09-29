package com.lgl.simpleframework.lgl.service.impl;

import com.lgl.simpleframework.framework.core.annotation.Service;
import com.lgl.simpleframework.lgl.service.HelloService;

/**
 * <p>
 * description
 * </p>
 *
 * @author lgl 2020/09/29 14:48
 * @since 1.0
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public void doSay() {
        System.out.println("say hello");
    }
}
