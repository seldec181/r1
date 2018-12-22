package yahoo_suite;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Yahoo_Prg.Compose;
import Yahoo_Prg.Login;
import Yahoo_Prg.MainClass;

public class SanityTest extends MainClass
{
  @Test	
  @Parameters({"browser"})
  public void sanitytesting(String str)  throws Exception
  {
	  if(str.matches("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver","D:\\sel_dec18\\Myproj\\geckodriver.exe");
		  driver=new FirefoxDriver();
	  }
	  if(str.matches("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver","D:\\sel_dec18\\Myproj\\chromedriver.exe");
		  driver=new ChromeDriver();
	  }
	  FileInputStream fin=new FileInputStream("d:\\sel_dec18\\TestCases.xlsx");
	  XSSFWorkbook wb=new XSSFWorkbook(fin);
	  XSSFSheet ws=wb.getSheet("sanitytest");  
		
	    String classname,methodname;
		Row row;
		for(int r=1;r<=ws.getLastRowNum();r++) //for all the rows in the sheet
		{
			row=ws.getRow(r);
			if(row.getCell(5).getStringCellValue().matches("yes"))
			{
				classname=row.getCell(3).getStringCellValue();
				methodname=row.getCell(4).getStringCellValue();
				
				Class c=Class.forName(classname);  
				Method m=c.getMethod(methodname, null);  
				Object obj=c.newInstance();   
				m.invoke(obj, null);   				
			}
		}
		fin.close();
  }
}
