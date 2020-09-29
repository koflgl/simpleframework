package com.lgl.simpleframework.proxy.impl;


import com.lgl.simpleframework.proxy.ToCPayment;

/**
 * @author lgl
 */
public class ToCPaymentImpl implements ToCPayment {
    @Override
    public void pay() {
        System.out.println("以用户的名义进行支付");
    }
}