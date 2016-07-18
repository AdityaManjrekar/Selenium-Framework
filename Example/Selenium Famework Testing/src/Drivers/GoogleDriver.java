package Drivers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import Framework.*;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
public class GoogleDriver 
{
	

	public Boolean launchGoogle(HashMap<String,String> input,HashMap<String,String> output,HashMap<String,String> globalConfig,UIDrivers oUiDrivers,HashMap<String,String> oObjRepository,ReportPath oReportPath) throws NumberFormatException, InterruptedException, RowsExceededException, BiffException, WriteException, IOException
	{
		FirefoxUIDriver oFirefoxUIDriver = oUiDrivers.oFirefoxUIDriver;
		WebElement oWebElement = oUiDrivers.oFirefoxUIDriver.oWebElement;
		Boolean bFlag = true;
		
		oFirefoxUIDriver.navigate(input.get("urlName"));
		if(oFirefoxUIDriver.getTitle().equals("Google"))
			oFirefoxUIDriver.result(oReportPath,"launchGoogle","PASS","Google Webpage should be launched","Google Webpage has been launched",true);
		else
		{
			oFirefoxUIDriver.result(oReportPath,"launchGoogle","FAIL","Google Webpage should be launched","Google Webpage has not been launched",true);
			bFlag = false;
		}
		return bFlag;
	}
	
	public Boolean searchGoogle(HashMap<String,String> input,HashMap<String,String> output,HashMap<String,String> globalConfig,UIDrivers oUiDrivers,HashMap<String,String> oObjRepository,ReportPath oReportPath) throws NumberFormatException, InterruptedException, RowsExceededException, BiffException, WriteException, IOException
	{
		FirefoxUIDriver oFirefoxUIDriver = oUiDrivers.oFirefoxUIDriver;
		WebElement oWebElement = oUiDrivers.oFirefoxUIDriver.oWebElement;
		Boolean bFlag = true;
		
		oWebElement =  oFirefoxUIDriver.findElement(oObjRepository.get("txtSearch"));
		oFirefoxUIDriver.sendKeys(oWebElement, input.get("searchText"));
		
		oWebElement = oFirefoxUIDriver.findElement(oObjRepository.get("btnSearch"));
		oFirefoxUIDriver.click(oWebElement);
		
		oFirefoxUIDriver.unconditionalWait("MEDIUM");
		if(oFirefoxUIDriver.getTitle().equals(input.get("searchValidation")))
			oFirefoxUIDriver.result(oReportPath,"searchGoogle","PASS","Search profile " + input.get("searchText") + " on Google Webpage should be successful","Search profile " + input.get("searchText") + " on Google Webpage is successful",true);
		else
		{
			oFirefoxUIDriver.result(oReportPath,"searchGoogle","FAIL","Search profile " + input.get("searchText") + " on Google Webpage should be successful","Search profile " + input.get("searchText") + " on Google Webpage is not successful",true);
			bFlag = false;
		}
		
		return bFlag;
		}
	
	public Boolean openProfile(HashMap<String,String> input,HashMap<String,String> output,HashMap<String,String> globalConfig,UIDrivers oUiDrivers,HashMap<String,String> oObjRepository,ReportPath oReportPath) throws NumberFormatException, InterruptedException, RowsExceededException, BiffException, WriteException, IOException
	{
		FirefoxUIDriver oFirefoxUIDriver = oUiDrivers.oFirefoxUIDriver;
		WebElement oWebElement = oUiDrivers.oFirefoxUIDriver.oWebElement;
		Boolean bFlag = true;

		List<WebElement> aWebElements = oFirefoxUIDriver.findElements(oObjRepository.get("lnkProfile"));
			for (WebElement webElement : aWebElements) {
					if(webElement.getText().indexOf(input.get("lnkText")) > -1)
					{
						webElement.click();
						break;
					}
			}
			oFirefoxUIDriver.unconditionalWait("MEDIUM");
			if(oFirefoxUIDriver.getTitle().equals(input.get("searchValidation")))
				oFirefoxUIDriver.result(oReportPath,"openProfile","PASS",input.get("searchValidation") + " should be opened successfully",input.get("searchValidation") + " is opened successfully",true);
			else
			{
				oFirefoxUIDriver.result(oReportPath,"openProfile","FAIL",input.get("searchValidation") + " should be opened successfully", input.get("searchValidation") + " is opened successfully",true);
				bFlag = false;
			}
				
		return bFlag;
	}
}
