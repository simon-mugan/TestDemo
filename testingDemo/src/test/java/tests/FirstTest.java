package tests;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.checkerframework.common.util.report.qual.ReportCall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class FirstTest {
	WebDriver driver;
	
  @Test
  public void f() {
	  System.out.println("Click Sports link");
	  driver.findElement(By.xpath("//span[contains(.,'Sport')]")).click();
	  try {Thread.sleep(5000);} catch (Exception e) {};
	  showArticles("Paragraph");
	  System.out.println("Click Home link");
	  driver.findElement(By.xpath("//span[contains(@class,'LogoIconWrapper')]")).click();
	  try {Thread.sleep(5000);} catch (Exception e) {};
	  System.out.println("Click News link");
	  driver.findElement(By.xpath("//span[contains(.,'News')]")).click();
	  try {Thread.sleep(5000);} catch (Exception e) {};
	  showArticles("promo-summary");
  }
  
  private void showArticles(String contains) {
	  List articles = driver.findElements(By.xpath("//p[contains(@class,'" +contains + "')]"));
	  for (int i=0; i<articles.size(); i++) {
		  WebElement article = (WebElement) articles.get(i);
		  if (!article.getText().isEmpty())
			  System.out.println(i + " = " + article.getText());
	  }
  }
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @BeforeTest
  public void beforeTest() {
	  driver.get("https://bbc.co.uk");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

  @BeforeSuite
  public void beforeSuite() {
	  try {
		  System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		  ChromeOptions opts = new ChromeOptions();
		  opts.addArguments("--remote-allow-origins=*");
		  driver = new ChromeDriver(opts);
//		  driver.manage().window().maximize();
//	  WebDriverManager.chromedriver().setup();
//	  driver=new ChromeDriver();
	  } catch (Exception e) {}
  }

}
