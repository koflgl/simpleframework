package com.lgl.simpleframework.proxy;


/**
 * @author lgl
 */
public class AliToC implements ToCPayment {
    private ToCPayment toCPayment;
    public AliToC(ToCPayment toCPayment){
        this.toCPayment = toCPayment;
    }
    @Override
    public void pay() {
        beforePay();
        toCPayment.pay();
        afterPay();
    }

    private void afterPay() {
        System.out.println("支付给收钱方");
    }

    private void beforePay() {
        System.out.println("从银行卡取款");
    }
}