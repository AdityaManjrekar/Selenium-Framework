package Drivers;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Framework.FirefoxUIDriver;
import Framework.ReportPath;
import Framework.UIDrivers;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class GitHubDriver {
	
/*
 * Author: ADitya Manjrekar
 * Date: 07/12/2015
 * Description:Lanch Guthub website
 */
	public Boolean launchGithub(HashMap<String,String> input,HashMap<String,String> output,HashMap<String,String> globalConfig,UIDrivers oUiDrivers,HashMap<String,String> oObjRepository,ReportPath oReportPath) throws NumberFormatException, InterruptedException, RowsExceededException, BiffException, WriteException, IOException
	{
		FirefoxUIDriver oFirefoxUIDriver = oUiDrivers.oFirefoxUIDriver;
		WebElement oWebElement = oUiDrivers.oFirefoxUIDriver.oWebElement;
		Boolean bFlag = true;
		
		oFirefoxUIDriver.navigate(input.get("urlName"));
		if(oFirefoxUIDriver.getTitle().equals("How people build software · GitHub"))
			oFirefoxUIDriver.result(oReportPath,"launchGithub","PASS","Git Hub Webpage should be launched","Git Hub Webpage has been launched",true);
		else
		{
			oFirefoxUIDriver.result(oReportPath,"launchGithub","FAIL","Git Hub Webpage should be launched","Git Hub Webpage has not been launched",true);
			bFlag = false;
		}
		return bFlag;
	}
	
	/*
	 * Author: ADitya Manjrekar
	 * Date: 07/12/2015
	 * Description:Log in to Gihub account
	 */
		public Boolean loginGithHub(HashMap<String,String> input,HashMap<String,String> output,HashMap<String,String> globalConfig,UIDrivers oUiDrivers,HashMap<String,String> oObjRepository,ReportPath oReportPath) throws NumberFormatException, InterruptedException, RowsExceededException, BiffException, WriteException, IOException
		{
			FirefoxUIDriver oFirefoxUIDriver = oUiDrivers.oFirefoxUIDriver;
			WebElement oWebElement = oUiDrivers.oFirefoxUIDriver.oWebElement;
			Boolean bFlag = true;
			
			oWebElement = oFirefoxUIDriver.findElement(oObjRepository.get("btnSignIn"));
			oWebElement.click();
			oWebElement = oFirefoxUIDriver.findElement(oObjRepository.get("txtLogin"));
			if(oFirefoxUIDriver.exists(oWebElement))
				oFirefoxUIDriver.result(oReportPath,"loginGithHub","PASS","Login page should be displayed","Login page has been displayed.",true);
			else
			{
				oFirefoxUIDriver.result(oReportPath,"loginGithHub","FAIL","Login page should be displayed","Login page has been displayed",true);
				bFlag = false;
			}
			oFirefoxUIDriver.sendKeys(oWebElement, input.get("usrName"));
			oWebElement = oFirefoxUIDriver.findElement(oObjRepository.get("txtPassword"));
			oFirefoxUIDriver.sendKeys(oWebElement, input.get("password"));
			oWebElement = oFirefoxUIDriver.findElement(oObjRepository.get("btnlogin"));
			oWebElement.click();
			oWebElement = oFirefoxUIDriver.findElement(oObjRepository.get("btnStartProject"));
			if(oFirefoxUIDriver.exists(oWebElement))
				oFirefoxUIDriver.result(oReportPath,"loginGithHub","PASS","Git Hub Start page should be displayed","Git hub Start page has been displayed.",true);
			else
			{
				oFirefoxUIDriver.result(oReportPath,"loginGithHub","FAIL","Git hUb Start page should be displayed","Git Hub Start page has been displayed",true);
				bFlag = false;
			}
			
			return bFlag;
		}
		/*
		 * Author: ADitya Manjrekar
		 * Date: 07/12/2015
		 * Description:Create a new Repository in Github
		 */
			public Boolean createRepository(HashMap<String,String> input,HashMap<String,String> output,HashMap<String,String> globalConfig,UIDrivers oUiDrivers,HashMap<String,String> oObjRepository,ReportPath oReportPath) throws NumberFormatException, InterruptedException, RowsExceededException, BiffException, WriteException, IOException
			{
				FirefoxUIDriver oFirefoxUIDriver = oUiDrivers.oFirefoxUIDriver;
				WebElement oWebElement = oUiDrivers.oFirefoxUIDriver.oWebElement;
				Boolean bFlag = true;

				oWebElement = oFirefoxUIDriver.findElement(oObjRepository.get("btnStartProject"));
				oWebElement.click();
				
				oWebElement = oFirefoxUIDriver.findElement(oObjRepository.get("txtRepositoryName"));
				oFirefoxUIDriver.sendKeys(oWebElement, input.get("repositoryName"));
				
				oWebElement = oFirefoxUIDriver.findElement(oObjRepository.get("txtRepositoryDescription"));
				oFirefoxUIDriver.sendKeys(oWebElement, input.get("description"));
				if(input.get("initializeReadMe").equals("Yes"))
				{
					oWebElement = oFirefoxUIDriver.findElement(oObjRepository.get("chkbxReadMe"));
					oWebElement.click();
				}
				List<WebElement> aWebElements = oFirefoxUIDriver.findElements(oObjRepository.get("btnCreateRepository"));
				for (WebElement webElement : aWebElements) {
					if(webElement.getAttribute("class").equals("btn btn-primary first-in-line"))
					{
						webElement.click();
						break;
					}
					
				}
				Boolean bTempFlag = false;
				 aWebElements = oFirefoxUIDriver.findElements(oObjRepository.get("lnkTest"));
					for (WebElement webElement : aWebElements) {
						if(webElement.getAttribute("href").indexOf("/AdityaManjrekar/test")>-1)
						{
							oFirefoxUIDriver.result(oReportPath,"createRepository","PASS","repository Should be created","repository has been created",true);
							bTempFlag = true;
							break;
						}
					}
					if(bTempFlag)
					{
						bFlag = true;
					}
					else
					{
						oFirefoxUIDriver.result(oReportPath,"createRepository","FAIL","repository Should be created ","repository has not been created",true);
						bFlag = false;
					}

				return bFlag;
			}
			/*
			 * Author: ADitya Manjrekar
			 * Date: 07/12/2015
			 * Description:Delete a new Repository in Github
			 */
				public Boolean deleteRepository(HashMap<String,String> input,HashMap<String,String> output,HashMap<String,String> globalConfig,UIDrivers oUiDrivers,HashMap<String,String> oObjRepository,ReportPath oReportPath) throws NumberFormatException, InterruptedException, RowsExceededException, BiffException, WriteException, IOException
				{
					FirefoxUIDriver oFirefoxUIDriver = oUiDrivers.oFirefoxUIDriver;
					WebElement oWebElement = oUiDrivers.oFirefoxUIDriver.oWebElement;
					Boolean bFlag = true;
					List<WebElement> aWebElements = oFirefoxUIDriver.findElements(oObjRepository.get("lnkSettings"));
					for (WebElement webElement : aWebElements) {
						if(webElement.getAttribute("class").equals("octicon octicon-gear"))
						{ 
							webElement.click();
							break;
						}
					}
					oFirefoxUIDriver.unconditionalWait("LOW");
					 aWebElements = oFirefoxUIDriver.findElements(oObjRepository.get("btnCreateRepository"));
					 int i=0;
					 
					for (WebElement webElement : aWebElements) {
						if(webElement.getAttribute("class").equals("btn btn-danger boxed-action") && webElement.getAttribute("type").equals("button"))
						{
							if(i>0)
							{
								webElement.click();
								break;
							}
							else
							{
								i++;
							}
						}
					}
					oFirefoxUIDriver.unconditionalWait("LOW");
					
					Robot robot = null;
					try {
						robot = new Robot();
					} catch (AWTException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//r.keyPress(keycode);
					String sRepoName = input.get("repositoryName");
					byte[] bytes = sRepoName.getBytes();
				    for (byte b : bytes)
				    {
				      int code = b;
				      // keycode only handles [A-Z] (which is ASCII decimal [65-90])
				      if (code > 96 && code < 123) code = code - 32;
				      robot.delay(40);
				      robot.keyPress(code);
				      robot.keyRelease(code);
				    }
					
						 aWebElements = oFirefoxUIDriver.findElements(oObjRepository.get("btnCreateRepository"));
							for (WebElement webElement : aWebElements) {
								if(webElement.getAttribute("class").equals("btn btn-block btn-danger") && webElement.getAttribute("type").equals("submit"))
								{
									if(webElement.getText().indexOf("delete") > 0)
									{
										webElement.click();
										break;
									}
								}
							}
							
							 aWebElements = oFirefoxUIDriver.findElements(oObjRepository.get("lblDelRepo"));
							 Boolean btnExistFlag = false;
								for (WebElement webElement : aWebElements) {
									if(webElement.getAttribute("class").equals("container"))
									{
										if(webElement.getText().indexOf(input.get("txtConfirmation")) > -1)
										{
											oFirefoxUIDriver.result(oReportPath,"deleteRepository","PASS","repository Should be deleted ","repository has been deleted",true);
											btnExistFlag = true;
											break;
										}
										
									}
								}
							if(!btnExistFlag)
								oFirefoxUIDriver.result(oReportPath,"deleteRepository","FAIL","repository Should be deleted ","repository has not been deleted",true);
					
					
					return bFlag;
				}
				/*
				 * Author: ADitya Manjrekar
				 * Date: 07/12/2015
				 * Description: Logout of the Repository
				 */
					public Boolean logout(HashMap<String,String> input,HashMap<String,String> output,HashMap<String,String> globalConfig,UIDrivers oUiDrivers,HashMap<String,String> oObjRepository,ReportPath oReportPath) throws NumberFormatException, InterruptedException, RowsExceededException, BiffException, WriteException, IOException
					{
						FirefoxUIDriver oFirefoxUIDriver = oUiDrivers.oFirefoxUIDriver;
						WebElement oWebElement = oUiDrivers.oFirefoxUIDriver.oWebElement;
						Boolean bFlag = true;
						List<WebElement> aWebElements = null;
						 aWebElements = oFirefoxUIDriver.findElements(oObjRepository.get("imgProfile"));
							for (WebElement webElement : aWebElements) {
								if(webElement.getAttribute("class").equals("avatar"))
								{
										webElement.click();
										break;
								}
							}
							
							 oFirefoxUIDriver.unconditionalWait("LOW");
							 aWebElements = oFirefoxUIDriver.findElements(oObjRepository.get("btnLogOut"));
								for (WebElement webElement : aWebElements) {
									if(webElement.getAttribute("class").equals("dropdown-item dropdown-signout"))
									{
										if(webElement.getText().indexOf("Sign out") > -1)
										{
											webElement.click();
											break;
										}
									}
								}
								 oFirefoxUIDriver.unconditionalWait("LOW");

								if(oFirefoxUIDriver.getTitle().equals("How people build software · GitHub"))
									oFirefoxUIDriver.result(oReportPath,"logOut","PASS","Git Hub Log Out should be succesfull","Git Hub Log Out has been succesfull",true);
								else
								{
									oFirefoxUIDriver.result(oReportPath,"logOut","FAIL","Git Hub Log Out should be succesfull","Git Hub Log Out has not been succesfull",true);
									bFlag = false;
								}
								oFirefoxUIDriver.close();
						return bFlag;
					}
					
}
