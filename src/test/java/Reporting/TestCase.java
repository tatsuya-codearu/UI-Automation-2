package Reporting;

import org.testng.annotations.Test;

import Application.CompareProducts;

public class TestCase extends BaseTest{
	
	@Test
	public void prodComp1() {
		CompareProducts comp = new CompareProducts(driver);
		comp.comp1();
	}
}
