package com.orangehrm.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.orangehrm.framework.webdriver.WebDriverClass;
import com.orangehrm.pages.ForgotPassword;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;

public class OranageHRMTest extends WebDriverClass {
	
	@Test(priority=1)
	public void VerifyApplicationTitle() throws IOException {
		initiateTestCaseReporting("Verify Application Title");
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.launchTheApplication();
		loginpage.verfiyTitle();		
	}
	
	@Test(dataProvider="data",priority=2)
	public void VerifyApplicationLogin(String Username,String Password) throws IOException {
		initiateTestCaseReporting("Verify Application Login is Successful or not");
		LoginPage loginpage = LoginPage.getLoginPage();
		HomePage homePage = HomePage.getHomePage();
		loginpage.launchTheApplication();
		loginpage.LoginIntoApplication(Username, Password);
		homePage.verifyWhetherAppLoginIsSuccessful();		
	}
	
	@Test(dataProvider="LogoutData",priority=3)
	public void VerifyApplicationLogout(String Username,String Password) throws IOException {
		initiateTestCaseReporting("Verify Application Logout is Successful or not");
		LoginPage loginpage = LoginPage.getLoginPage();
		HomePage homePage = HomePage.getHomePage();
		loginpage.launchTheApplication();
		loginpage.LoginIntoApplication(Username, Password);
		homePage.verifyWhetherAppLoginIsSuccessful();		
		homePage.verifyApplicationLogout();
	}
	
	@Test(priority=4)
	public void VerfiyForgotPasswordPage() throws IOException {
		initiateTestCaseReporting("Verify Forgot Password Page");
		LoginPage loginpage = LoginPage.getLoginPage();
		ForgotPassword forgotPasswordPage=ForgotPassword.getForgotPassword();
		loginpage.launchTheApplication();
		forgotPasswordPage.verifyForgotPasswordPageElements();
	}
	
	

}
