package com.lgl.simpleframework.proxy;


import com.lgl.simpleframework.proxy.impl.ToCPaymentImpl;
import com.lgl.simpleframework.proxy.jdkproxy.AliPayInvocationHandler;
import com.lgl.simpleframework.proxy.jdkproxy.JdkUtil;

/**
 * @author lgl
 */
public class ProxyDemo {
    public static void main(String[] args) {
/*
        ToCPayment toCProxy = new AliToC( new ToCPaymentImpl());
        toCProxy.pay();*/
        //被代理的对象
        ToCPayment toCPayment = new ToCPaymentImpl();
        AliPayInvocationHandler handler = new AliPayInvocationHandler(toCPayment);
        ToCPayment payment = JdkUtil.newProxyInstance(toCPayment, handler);
        payment.pay();
    }
}