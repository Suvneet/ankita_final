package com.qa.tester;

import org.testng.Assert;
import org.testng.annotations.*;

public class NewTest {
  
	@BeforeMethod
	public void before_method() {
		System.out.println("Before method");
	}
	
	@BeforeClass
	public void before_class() {
		System.out.println("Before class");
	}
	
	@BeforeSuite
	public void before_suite() {
		System.out.println("Before suite");
	}
	
	@BeforeTest
	public void before_test() {
		System.out.println("Before test");
	}
	
	@BeforeGroups
	public void before_groups() {
		System.out.println("Before groups");
	}
	
	
	@Test
    public void z() {
		System.out.println("In Z");
		Assert.assertEquals(true, false);
   }
	
	@Test
    public void o() {
		System.out.println("In O");
		Assert.assertEquals(true, false);
   }
	
	@Test
    public void a() {
		System.out.println("In A");
		Assert.assertEquals(true, true);
   }
	
}
