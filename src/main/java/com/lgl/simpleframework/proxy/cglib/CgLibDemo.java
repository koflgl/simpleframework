package com.lgl.simpleframework.proxy.cglib;


import com.lgl.simpleframework.proxy.ToCPayment;
import com.lgl.simpleframework.proxy.impl.ToCPaymentImpl;
import com.lgl.simpleframework.proxy.jdkproxy.AliPayInvocationHandler;
import com.lgl.simpleframework.proxy.jdkproxy.JdkUtil;

/**
 * @author lgl
 */
public class CgLibDemo {
    public static void main(String[] args) {
        CommonPay commonPay = new CommonPay();
        AliPayMethodInterceptor interceptor = new AliPayMethodInterceptor();
        CommonPay commonPayProxy = CgLibUtil.createProxy(commonPay,interceptor);
        commonPayProxy.pay();
//        //tocPayMent的实现类
        ToCPayment toCPayment = new ToCPaymentImpl();
        AliPayMethodInterceptor antherInterceptor = new AliPayMethodInterceptor();
        ToCPayment proxy = CgLibUtil.createProxy(toCPayment, antherInterceptor);
        proxy.pay();
        //尝试使用JDK动态代理
        CommonPay JDKcommonPay = new CommonPay();
        AliPayInvocationHandler handler = new AliPayInvocationHandler(JDKcommonPay);
        CommonPay newProxyInstance = JdkUtil.newProxyInstance(JDKcommonPay, handler);
        newProxyInstance.pay();
    }
}