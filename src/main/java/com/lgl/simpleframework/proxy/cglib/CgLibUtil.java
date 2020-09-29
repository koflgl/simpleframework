package com.lgl.simpleframework.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;


/**
 * @author lgl
 */
public class CgLibUtil {
    public static  <T> T  createProxy(T targetObject , MethodInterceptor interceptor){
       return (T) Enhancer.create(targetObject.getClass(), interceptor);
    }
}