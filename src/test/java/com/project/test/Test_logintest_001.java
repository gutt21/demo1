package com.project.test;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.project.base.baseclass;
import com.project.pageloads.loginpage;

public class Test_logintest_001 extends baseclass {
	loginpage log;
	@Test
	public void logintest() {
		log=new loginpage();
		log.user(username);
		log.pass(password);
		log.button();		
		boolean test=log.dashbord();
		Assert.assertTrue(test);
		logger.info("successfully login");
		logger.info("dashbord verify successfull");
	}
}
