package tests;

import org.testng.annotations.DataProvider;

public class MyDataProvider {
	
	  @DataProvider(name = "myTest1")
	  public static Object[][] createData() {
	    return new Object[][] {
	      new Object[] { "//a[contains(@title, 'IT industry software company')]" },
	      new Object[] {"//a[contains(@title, 'Finance web application')]"}
	    };
	  }
		
	  @DataProvider(name = "myTest2")
	  public static Object[][] createData2() {
	    return new Object[][] {
	    	{ "IT Industry Software Company Services - Web Application Development Solutions", "//a[contains(@title, 'IT industry software company')]" },
	    	   { "Banking Software Development - Financial Software Developers - Investment Banking Software Solutions", "//a[contains(@title, 'Finance web application')]"},
	    	 };

	  }

}
