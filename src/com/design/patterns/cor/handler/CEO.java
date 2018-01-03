package com.design.patterns.cor.handler;

/*
 * 折扣超过55%, 就拒绝申请
 */
public class CEO extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if(discount<=0.55){
			System.out.format("%s批准了折扣 : %.2f%n",this.getClass().getName(),discount);
		}else{
			System.out.format("%s批准了折扣 : %.2f%n", this.getClass().getName(),discount);
		}

	}

}
