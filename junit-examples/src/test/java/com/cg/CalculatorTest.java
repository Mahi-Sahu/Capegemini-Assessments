package com.cg;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.BeforeEach;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertFalse;

public class CalculatorTest {
	static Calculator cal;
	@BeforeAll
	public static void init() {
		cal = new Calculator();
		System.out.println("Calculator object created");
	}
	
	@AfterAll
	public static void destroy() {
		cal = null;
		System.out.println("Calculator object destroyed");
	}
	//@Test
	@DisplayName(value = "Testing calculate method")
	@ParameterizedTest
	@CsvSource({"2,4,6","6,5,11","10,15,25"})
	public void calTest(int num1,int num2,int result) {
		//Calculator cal = new Calculator();
		System.out.println("Testing  calculate method");
		assertEquals(result,cal.calculate(num1, num2));
	}
	//@Test
	//@Timeout(value = 2,unit = TimeUnit.MILLISECONDS)//in milliseconds
	//@Disabled
	@ParameterizedTest
	@ValueSource(ints = {13,17,19,23,53})
	public void isPrimeTest(int num) {
		//Calculator ca = new Calculator();
		System.out.println("Testing isPrime method");
		assertTrue(cal.isPrime(num));
		//assertTrue(cal.isPrime(13));
		//assertFalse(cal.isPrime(16));
	}
	
}
