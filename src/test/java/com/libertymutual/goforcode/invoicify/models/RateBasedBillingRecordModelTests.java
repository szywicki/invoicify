package com.libertymutual.goforcode.invoicify.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;

public class RateBasedBillingRecordModelTests {

	@Test
    public void test_all_gets_and_sets() {
		Configuration configuration = new ConfigurationBuilder()
	              .ignoreProperty("createdOn")
	              .build();
        new BeanTester().testBean(RateBasedBillingRecord.class, configuration);
    }
	
	@Test
	public void test_get_total_returns_total() {
		// Arrange
		RateBasedBillingRecord billingRecord = new RateBasedBillingRecord();
		billingRecord.setRate(5);
		billingRecord.setQuantity(4);
		
		// Act
		double actual = billingRecord.getTotal();
		
		// Assert
		assertThat(actual).isEqualTo(20);
		
	}

}
