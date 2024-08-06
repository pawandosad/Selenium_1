package com.itlearn.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.LoginPage;
import com.itlearn.utility.ReadExcelFile;

public class LoginTestDriverData extends BaseTest {

	String fileName = System.getProperty("user.dir")+"\\TestData\\TestInfo.xlsx";
	   @Test(priority =1,dataProvider="LoginDataProvider")
		 void verifyLogin(String userEmail, String userPwd)
	{ 
	   LoginPage lp= new LoginPage(driver);
//	   String username = "Demo12";
//	   String password = "Test123456$";
	   lp.loginPortal(userEmail, userPwd);
	   lp.logout();
			}
	   @DataProvider(name="LoginDataProvider")
		public String[][] LoginDataProvider()
		{
			
			
			int ttlRows= ReadExcelFile.getRowCount(fileName, "LoginData");
			int ttlColumns= ReadExcelFile.getColCount(fileName, "LoginData");
			
			String data[][]= new String[ttlRows-1][ttlColumns];
			
			for(int i=1;i<ttlRows;i++)
			{
				for(int j=0;j<ttlColumns;j++)
				{
					data[i-1][j]=ReadExcelFile.getCellValue(fileName, "LoginData", i, j);
				}
			}
			return data;
		}
}
