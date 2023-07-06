package Reporting;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Application.CompareProducts;
import Application.Home;
import Application.Logging;
import Application.Tees;
import Application.checkout;

public class TestCase extends BaseTest{
	@Test(groups="TS-001")
	public void TestCase1() {
		CompareProducts comp = new CompareProducts(driver);
		comp.comp1();
	}
	
	@Test(groups="TS-001")
	public void TestCase2() throws InterruptedException {
		CompareProducts comp = new CompareProducts(driver);
		
		comp.comp2();
	}
	
	@Test(groups="TS-001")
	public void TestCase3() throws InterruptedException {
		CompareProducts comp = new CompareProducts(driver);
		
		comp.comp3();
	}
	
	@Test(groups="TS-002")
	public void TestCase4() throws InterruptedException {
		Home home = new Home(driver);
		Logging lg = new Logging(driver);
		
		lg.verifyNotLogged();
		home.hero();
	}
	
	@Test(groups="TS-003")
	@Parameters({"testId5"})
	public void TestCase5(String testId5) throws Exception {
		Tees tee = new Tees(driver);
		tee.test5(testId5);
	}
	
	@Test(groups="TS-004")
	@Parameters("testId6")
	public void TestCase6(String testId6) throws IOException, InterruptedException {
		checkout check = new checkout(driver);
		check.checkTest(testId6);
	}
}
