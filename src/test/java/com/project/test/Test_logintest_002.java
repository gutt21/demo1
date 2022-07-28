package com.project.test;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.base.baseclass;
import com.project.pageloads.loginpage;

public class Test_logintest_002 extends baseclass {
	loginpage log;
	@Test(dataProvider = "akash")
	public void logintest(String name,String pass) throws Exception {
		log=new loginpage();
		log.user(name);
		log.pass(pass);
		log.button();
		logger.info("successfully login");
		boolean test=log.dashbord();
		Assert.assertTrue(test);
		logger.info("dashbord verify successfull");
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}
	
	
	
	@DataProvider(name="akash")	
	public String [][] data() throws Exception {
		
		XSSFWorkbook excel=new XSSFWorkbook("C:\\Users\\akash\\eclipse-workspace\\projectdemo2\\src\\test\\java\\com\\project\\testdata\\logindata.xlsx");
		XSSFSheet sheet=excel.getSheet("Sheet1");
		int a=sheet.getPhysicalNumberOfRows();
		int b=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(a);
		System.out.println(b);
		String [][] data=new String[a][b];
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
			}
			
			System.out.println();
		}
		return data;
	}
}

