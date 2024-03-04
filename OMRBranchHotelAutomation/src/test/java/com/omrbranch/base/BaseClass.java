package com.omrbranch.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	protected static WebDriver driver;
	//1
	  public static void browserLaunch(String browserType) {
		switch (browserType) {
		case "Chrome":
			driver=new ChromeDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		default:
			break;
		}
	}
	  
	  public static String getPropertyFileValue(String Key) throws FileNotFoundException, IOException {
		Properties properties=new Properties();
        properties.load(new FileInputStream(getProjectPath()+"\\config\\config.properties"));
          Object object = properties.get(Key);
          String value= (String) object;
		return value;    
	}
	  
	  public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}
	  
	  //2
	  public static void applnUrl(String url) {
		driver.get(url);
	}
	  //3
	  public static void maximizeWindow() {
		driver.manage().window().maximize();
	}
	  public void enterKey() throws AWTException {
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	  public void tabAndEnterKey() throws AWTException {
		  Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
	}
	  //40
	  public static boolean isDisplayed(WebElement element) {
	     boolean b = element.isDisplayed();
	 	return b;
	 }
	  //41
	  public boolean isEnabled(WebElement element) {
	 	    boolean b = element.isEnabled();
	 		return b;
	 }
	  //42
	  public boolean isSelected(WebElement element) {
	 	    boolean b = element.isSelected();
	 		return b;
	 }
	//55
	public void visibilityOf(int time,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void visibilityOf(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	  //4
	 public void elementSendKeys(WebElement element,String data) {
		 visibilityOf(element);
		 if(isEnabled(element)&&isDisplayed(element)&&data!=null) {
		 element.sendKeys(data);
		 }
	 }
	 //5
	 public void elementClick(WebElement element) {
	   if(isEnabled(element)&&isDisplayed(element)){
		element.click();
		 }
	}
	 //6
	 public String getApplnTitle() {
	    String title = driver.getTitle();
	    return title;
	}
	 //7
	 public WebElement findLocatorById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		visibilityOf(element);
		return element;
	}
	 //8
	 public WebElement findLocatorByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		visibilityOf(element);
		return element;
	}
	 //9
	 public WebElement findLocatorByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		visibilityOf(element);
		return element;
	}
	 //10
	 public WebElement findLocatorByXpath(String attributeValue) {
		WebElement element = driver.findElement(By.xpath(attributeValue));
		visibilityOf(element);
		return element;
	}
	 //11
	 public static String elementGetText(WebElement element) {
		 String text=null;
		 visibilityOf(element);
		 if(isDisplayed(element)) {
		    text = element.getText();
		 }
		 System.out.println(text);
		return text;
	}
	 //12
	 public String elementGetAttribute(WebElement element,String attributeName) {
		 String text=null;
		 visibilityOf(element);
		 if(isDisplayed(element)&&attributeName!=null) {
		     text = element.getAttribute(attributeName);
		 }
		return text;
	}
	 //13
	 public String elementGetAttribute(WebElement element) {
		 String attribute=null;
		    visibilityOf(element);
		    if(isDisplayed(element)) {
			 attribute = element.getAttribute("value");
		    }
			return attribute;
	}
	 //14
	 public static void quitWindow() {
		 driver.quit();
	 }
	 //15
	 public void closeWindow() {
		 driver.close();
	 }
	 //16
	 public String getCurrentUrl() {
		 String currentUrl = driver.getCurrentUrl();
		 return currentUrl;
	}
	 //17
	 public void selectOptionByText(WebElement element,String text) {
		 visibilityOf(element);
		 if(isDisplayed(element)&&text!=null) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
		}
	}
	 //18
	 public void selectOptionByValue(WebElement element,String value) {
		 visibilityOf(element);
		 if(isDisplayed(element)&&value!=null) {
		Select select=new Select(element);
		select.selectByValue(value);
		 }
	}
	 //19
	 public void selectOptionByIndex(WebElement element,int index) {
		 visibilityOf(element);
		 if(isDisplayed(element)) {
			Select select=new Select(element);
			select.selectByIndex(index);
		 }
	}
	 //20
	 public String getFirstSelectedOption(WebElement element) {
		 String text =null;
		 visibilityOf(element);
		 if(isDisplayed(element)) {
		 Select select=new Select(element);
		 WebElement first1 = select.getFirstSelectedOption();
		  text = first1.getText();
		 }
		 return text;
	}
	 //21
	 public void deselectOptionByIndex(WebElement element,int index) {
		 visibilityOf(element);
		 if(isDisplayed(element)) {
		 Select select=new Select(element);
			select.deselectByIndex(index);
	}
	 }
	 //22
	 public void deselectOptionByAttribute(WebElement element,String value) {
		 visibilityOf(element);
		 if(isDisplayed(element)&&value!=null) {
		 Select select=new Select(element);
			select.deselectByValue(value);
	}
	 }
	 //23
	 public void deselectOptionByText(WebElement element,String Text) {
		 visibilityOf(element);
		 if(isDisplayed(element)&&Text!=null) {
		     Select select=new Select(element);
			select.deselectByVisibleText(Text);
	}
	 }
	 //24
	 public void deselectAllOption(WebElement element){
		 visibilityOf(element);
		 if(isDisplayed(element)) {
		 Select select=new Select(element);
			select.deselectAll();
	}
	 }
	 //25
	 public void elementSendKeysJS(WebElement element,String data) {
		 visibilityOf(element);
		 if(isDisplayed(element)&&isEnabled(element)&&data!=null) {
	  JavascriptExecutor executor=(JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].setAttribute('value','"+data+"')", element);
	}
	 }
	 //26
	 public void elementlickJS(WebElement element) {
		 visibilityOf(element);
		 if(isDisplayed(element)) {
		  JavascriptExecutor executor=(JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click()", element);
		}
	 }
	 //27
	  public void navigateToUrl(String url) {
	   Navigation navigate=driver.navigate();
	   navigate.to(url);
	}
	  //28
	  public void navigateForward() {
		driver.navigate().forward();
	}
	  //29
	  public void navigatePreviousPage() {
		driver.navigate().back();
	}
	  //30
	  public void navigateRefreshPage() {
		driver.navigate().refresh();;
	}
	  //31
	  public void alertClickOk() {
	    Alert a = driver.switchTo().alert();
	    a.accept();
	}
	  //32
	  public void alertClickCancel() {
		    Alert a=driver.switchTo().alert();
		    a.dismiss();
		}
	  //33
	  public String alertGetText() {
		    Alert a=driver.switchTo().alert();
		    String text = a.getText();
			return text;	    
		}
	  //34
	  public void alertSendKeys(String data) {
		  if(data!=null) {
		    Alert a=driver.switchTo().alert();
		    a.sendKeys(data);	    
		}
	  }
	  //35
	  public void mouseOverOption(WebElement element) {
		  visibilityOf(element);
		  if(isDisplayed(element)) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	  }
	  //36
	  public void elementRightClick(WebElement element) {
		  visibilityOf(element);
		  if(isDisplayed(element)) {
		  Actions action=new Actions(driver);
	      action.contextClick(element).perform();
	}
	  }
	  //37
	  public void elementDoubleClick(WebElement element) {
		  visibilityOf(element);
		  if(isDisplayed(element)) {
		  Actions action=new Actions(driver);
		  action.doubleClick(element).perform();
	}
	  }
	  //38
	 public void actionDragAndDrop(WebElement element1,WebElement element2) {
		  visibilityOf(element1);
		  visibilityOf(element2);
		  if(isDisplayed(element1)&&isDisplayed(element2)) {
		  Actions action=new Actions(driver);
		  action.dragAndDrop(element1, element2).perform();
	}
	 }
	 //39
	 public void elementClearTextbox(WebElement element) {
		 visibilityOf(element);
	    element.clear();
	} 

	 //43
	 public List<WebElement> findLocatorsById(String attributename) {
		List<WebElement> elements = driver.findElements(By.id(attributename));
		return elements;
	}
	 //44
	 public List<WebElement> findLocatorsByName(String attributename) {
		List<WebElement> elements = driver.findElements(By.name(attributename));
		return elements;
	}
	 //45
	 public List<WebElement> findLocatorsByClassName(String attributename) {
		List<WebElement> elements = driver.findElements(By.className(attributename));
		return elements;
	}
	 //46
	 public List<WebElement> findLocatorsByXpath(String xpathExpression) {
		List<WebElement> elements = driver.findElements(By.xpath(xpathExpression));
		return elements;
	}
	 //47
	 public void switchFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}
	 //48
	 public void switchFrameById(String data) {
		 if(data!=null) {
	 driver.switchTo().frame(data);
	}
	 }
	 //49
	 public String getParentWindow() {
	 String parentWin = driver.getWindowHandle();
	 return parentWin;
	}
	 //50
	 public Set<String> getAllWindow() {
		Set<String> allWindow = driver.getWindowHandles();
		return allWindow;
	}
	 //51
	 public void TakeScreenshot(String name) throws IOException {
		 if(name!=null) {
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File s=screenshot.getScreenshotAs(OutputType.FILE);
		File d=new File("C:\\Users\\wel\\eclipse-workspace\\Frame2\\Screenshot\\"+name+".png");
		FileUtils.copyFile(s, d);
	}
	 }
	 //52
	 public void screenshotForElement(WebElement element,String name) throws IOException {
		 visibilityOf(element);
		 if(isDisplayed(element)&&name!=null) {
	 File s = element.getScreenshotAs(OutputType.FILE);
	 File d=new File("C:\\Users\\wel\\eclipse-workspace\\Frame2\\Screenshot\\"+name+".png");
	 FileUtils.copyFile(s, d);
	}
	 }
	 //53
	public void insertValueAndEnter(WebElement element,String value) {
		visibilityOf(element);
		if(isDisplayed(element)) {
		element.sendKeys(value,Keys.ENTER);
	}
	}
	//54
	public static void implicitWait() {
	//	driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	//56
	public void frameToWindow() {
		driver.switchTo().defaultContent();
	}
	//57
	public WebElement findLocatorByTagName(String tagName) {
		WebElement element = driver.findElement(By.tagName(tagName));
		return element;
	}

	//58
	public List<WebElement> getOptions(WebElement element) {
		visibilityOf(element);
		 Select select=new Select(element);
		 List<WebElement> options = select.getOptions();
		return options;
	 }
	//59
	public String getCellData(String sheetName,int rownum,int cellnum) throws IOException {
		String res=null;
		File file=new File("C:\\Users\\wel\\eclipse-workspace\\Frame2\\Excel\\studdata.xlsx");
		FileInputStream fileInputStream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
	    Row row = sheet.getRow(rownum);
	    Cell cell = row.getCell(cellnum);
	    CellType type = cell.getCellType();
	    
	    switch(type) {
	    case STRING:
	    	res = cell.getStringCellValue();
	    	break;
	    case NUMERIC:
	    	if(DateUtil.isCellDateFormatted(cell)) {
	    		Date dateCellValue = cell.getDateCellValue();
	    		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/YYYY");
	    		res = dateFormat.format(dateCellValue);
	    	}
	    	else {
	    		double numericCellValue = cell.getNumericCellValue();
	    		long round = Math.round(numericCellValue);
	    		if(numericCellValue==round) {
	    			res=String.valueOf(round);
	    		}
	    		else {
	    			res=String.valueOf(numericCellValue);
	    		}
	    	}
	    	break;
	    	
	    default:
	    	break;
	    }
	  return res;
	}
	//60
	public void updateCellData(String sheetName,int rownum,int cellnum,String oldData,String newData) throws IOException {

		File file=new File("C:\\Users\\wel\\eclipse-workspace\\Work\\excel\\studdata.xlsx");
		FileInputStream fileInputStream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
	    Row row = sheet.getRow(rownum);
	    Cell cell = row.getCell(cellnum);
	    String value = cell.getStringCellValue();
	    if(value.equals(oldData)) {
	    	cell.setCellValue(newData);
	    }
		FileOutputStream fileoutputstream=new FileOutputStream(file);
		workbook.write(fileoutputstream);
	}
	//61
	public void writeCellData(String sheetName,int rownum,int cellnum,String Data) throws IOException {
		File file=new File("C:\\Users\\wel\\eclipse-workspace\\Frame2\\Excel\\studdata.xlsx");
		FileInputStream fileInputStream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
	    Row row = sheet.getRow(rownum);
	    Cell cell = row.createCell(cellnum);
	    cell.setCellValue(Data);
	    FileOutputStream fileoutputstream=new FileOutputStream(file);
	    workbook.write(fileoutputstream);

	}

}
