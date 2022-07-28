package com.project.pageloads;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.base.baseclass;

public class loginpage extends baseclass {

	@FindBy(id = "txtUsername")
	WebElement id;
	
	@FindBy(id = "txtPassword")
	WebElement pass;
	
	@FindBy(id = "btnLogin")
	WebElement button;	
	
	@FindBy(id = "menu_dashboard_index")
	WebElement dash;
	
	public loginpage() {
		PageFactory.initElements(driver, this);
	}
	
	public void user(String name) {
		id.sendKeys(name);
	}
	
	public void pass(String pas) {
		pass.sendKeys(pas);
	}
	
	public myinfo button() {
		button.click();
		return new myinfo();
		
	}
	
	public boolean dashbord(){
		return dash.isDisplayed();
	}
	
	
}
