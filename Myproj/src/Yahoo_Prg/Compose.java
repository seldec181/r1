package Yahoo_Prg;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import Yahoo_prop.ComposeP;
import Yahoo_prop.LoginP;

public class Compose extends MainClass
{
 public void sendmail() throws Exception
 {
	 Thread.sleep(5000);
	 driver.findElement(By.xpath(ComposeP.xcompose)).click();
	 Thread.sleep(5000);
	 try
	 {
		 if(driver.findElement(By.id(ComposeP.ito)).isDisplayed())
		 {
			    log=ext.createTest("passTest");
				log.log(Status.PASS, "Compose is Working");
				takescreenshot(imagepath+"compose.png");
				log.addScreenCaptureFromPath(imagepath+"compose.png"); 
		 }
	 }
	 catch(Exception e)
	 {
		    log=ext.createTest("failTest");
			log.log(Status.FAIL, "Compose is Working");
			takescreenshot(imagepath+"compose.png");
			log.addScreenCaptureFromPath(imagepath+"compose.png"); 
	 }
	 
	 driver.findElement(By.id(ComposeP.ito)).sendKeys("abcd@gmail.com");
	 driver.findElement(By.id(ComposeP.isub)).sendKeys("testmail");
	 driver.findElement(By.name(ComposeP.nbody)).sendKeys("This is sample message in the body");
	 driver.findElement(By.id(ComposeP.isend)).click();
	 Thread.sleep(5000);
 }
 public void close()
 {
	 driver.findElement(By.linkText(LoginP.lsignout)).click();
	 driver.close();
 }
}
