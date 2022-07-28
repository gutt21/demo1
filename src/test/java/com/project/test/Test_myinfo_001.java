package com.project.test;

import org.junit.Assert;
import org.testng.annotations.Test;
import com.project.base.baseclass;
import com.project.pageloads.*;

public class Test_myinfo_001 extends baseclass{

	loginpage log;
	myinfo my;

	@Test
	public void myinfo() {	
		log=new loginpage();
		log.user(username);
		log.pass(password);
		log.button();
		my=new myinfo();
		my.my();
		boolean ad=	my.verify();
		Assert.assertTrue(ad);
		logger.info("verify my info");
		my.edit();

	}

}
