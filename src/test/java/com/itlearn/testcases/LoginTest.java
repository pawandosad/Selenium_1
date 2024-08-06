package com.itlearn.testcases;
import org.testng.annotations.Test;
import com.itlearn.pages.BaseTest;
import com.itlearn.pages.LoginPage;


public class LoginTest extends BaseTest{
   @Test(priority =1,dataProvider="LoginDataProvider")
	 void verifyLogin()
{ 
   LoginPage lp= new LoginPage(driver);
   String username = "Demo12";
   String password = "Test123456$";
   lp.loginPortal(username, password);
		}
   
}
