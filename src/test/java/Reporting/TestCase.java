package Reporting;

import org.testng.annotations.Test;

import Application.CompareProducts;

public class TestCase extends BaseTest{
	@Test
	public void TestCase1() {
		CompareProducts comp = new CompareProducts(driver);
		comp.comp1();
	}
	
	@Test
	public void TestCase2() {
		CompareProducts comp = new CompareProducts(driver);
		
		comp.comp2();
	}
	
	@Test
	public void TestCase3() {
		CompareProducts comp = new CompareProducts(driver);
		
		comp.comp3();
	}
}
