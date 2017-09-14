package com.libertymutual.goforcode.invoicify.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;

public class FlatFeeBillingRecordModelTests {

	@Test
    public void test_all_gets_and_sets() {
		Configuration configuration = new ConfigurationBuilder()
              .ignoreProperty("createdOn")
              .build();
        BeanTester tester = new BeanTester();
        tester.testBean(FlatFeeBillingRecord.class, configuration);
    }

	@Test
	public void test_get_total_returns_amount() {
		// Arrange
		FlatFeeBillingRecord flatFeeBilling = new FlatFeeBillingRecord();
		flatFeeBilling.setAmount(15);
		// Act
		double actual = flatFeeBilling.getTotal();
		
		// Assert
		assertThat(actual).isEqualTo(15);
	}
	
	@Test
	public void test_get_and_set_CreatedOn_Date() {
		// Arrange
		FlatFeeBillingRecord flatFeeBilling = new FlatFeeBillingRecord();
		flatFeeBilling.setCreatedOn(Date.valueOf("2017-05-15"));
		// Act
		Date actual = flatFeeBilling.getCreatedOn();
		
		// Assert
		assertThat(actual).isEqualTo(Date.valueOf("2017-05-15"));
	}
}
