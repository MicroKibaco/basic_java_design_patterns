package com.design.patterns.cor;

import com.design.patterns.cor.handler.PriceHandler;
import com.design.patterns.cor.handler.PriceHandlerFactory;

import java.util.Random;

/**
 * 客户,申请折扣
 */
public class Customer {

    private PriceHandler mPriceHandler;

    public void setPriceHandler(PriceHandler priceHandler) {
        mPriceHandler = priceHandler;
    }

    public void requestDiscount(float discount) {
        mPriceHandler.processDiscount(discount);
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setPriceHandler(PriceHandlerFactory.createPriceHandler());


        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(i+":");
            customer.requestDiscount(rand.nextFloat());
        }
    }

}
