package com.orangehrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orangehrm.frameowrk.commons.WebCommons;
import com.orangehrm.framework.webdriver.WebDriverClass;

public class AdminPannel extends WebCommons{
	
	@FindBy(xpath="//b[text()='Admin']")
	private WebElement AdminPage;
	
	@FindBy(xpath="//a[text()='Users']")
	private WebElement userspage;
	
	@FindBy(xpath="//input[@name='searchSystemUser[userName]']")
	private WebElement username;
	
	@FindBy(xpath="//select[@name='searchSystemUser[userType]']")
	private WebElement userrole;
	
	@FindBy(xpath="//input[@name='searchSystemUser[employeeName][empName]']")
	private WebElement employeename;
	
	@FindBy(xpath="//select[@name='searchSystemUser[status]']")
	private WebElement status;
	
	@FindBy(xpath="//input[@id='searchBtn']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//input[@id='resetBtn']")
	private WebElement resetBtn;
	
		
	public void verifyAdminPageElements() throws IOException {
		Logger = WebDriverClass.getLogger();
		
		try {
			Click(AdminPage);
			username.isDisplayed();
			userrole.isSelected();
			employeename.isDisplayed();
			status.isSelected();
			searchBtn.isDisplayed();
			resetBtn.isDisplayed();
			Logger.pass("Admin Page working as expected");
		} catch (Exception e) {
			Logger.addScreenCaptureFromPath(TakeScreenshot(driver, "AdminPage"));
			Logger.fail("Admin Page Elements not Available");
			Assert.fail("Admin Page Elements not Available");
		}
	}
	
	public static AdminPannel getAdminPannel() {
		return PageFactory.initElements(WebDriverClass.getDriver(), AdminPannel.class);
	}

}

