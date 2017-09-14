package com.libertymutual.goforcode.invoicify.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RateBasedBillingRecord extends BillingRecord{

	
	private double rate;
	
	private double quantity;
	
	@Override
	public double getTotal() {
		double total = rate * quantity;
		return total;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	
}
