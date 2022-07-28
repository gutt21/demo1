package com.project.pageloads;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.project.base.baseclass;

public class myinfo extends baseclass {

	@FindBy(id = "menu_pim_viewMyDetails")
	WebElement my;
	
	@FindBy(xpath = "//a[contains(text(),'Personal Details')]")
	WebElement verify;
	
	@FindBy(id = "btnSave")
	WebElement edit;
	
	
	public myinfo() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void my() {
		my.click();
	}
	
	public boolean verify() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return verify.isDisplayed();
	}
	
	public void edit() {
		edit.click();
	}
	
}
