package Definitions;

import com.cucumber.listener.Reporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class BasePage {

    //commit

    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;

    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(id = "loading-bar")
    private WebElement barraCargando;

    public BasePage() {
    }

    protected BasePage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    protected BasePage(WebDriver driver, int timeOutSec){
        this.driver=driver;
        this.wait= new WebDriverWait(driver, timeOutSec, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeOutSec), this);
    }

    protected BasePage(WebDriver driver, int timeOutSec, int pollingSec){
        this.driver=driver;
        this.wait= new WebDriverWait(driver, timeOutSec, pollingSec);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeOutSec), this);
    }

    protected WebDriver getDriver(){
        return driver;
    }

    protected void waitForElementToAppear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToDisappear(WebElement locator) {
        wait.until(ExpectedConditions.invisibilityOf(locator));
    }

    protected void waitForTextToDisappear(WebElement locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(locator, text)));
    }

    protected boolean isVisible(WebElement webElement){
        boolean isVisible;
        try {
            isVisible = webElement.isDisplayed();
        }catch (NoSuchElementException e){
            isVisible=false;
        }
        return isVisible;
    }

    protected void waitUntilEscritorioComercialIsLoaded() {
        while (isVisible(barraCargando)){
            waitFor(1);
        }
    }

    protected void waitFor(int segundos){
        try {
            Thread.sleep(segundos*1000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    protected void scrollEndPage() {
        try {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public byte[] takeScreenshot(){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void screenshot(WebDriver driver, String nombre) {
        try {
            // Sacar screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File path = new File(System.getProperty("user.dir") + "/reportes/screenshots/" + nombre+ "_" + System.currentTimeMillis() + ".jpg");
            File newPath = new File(System.getProperty("user.dir") + "/reportes/html/Reporte_Automatizacion.html");
            FileUtils.copyFile(screenshot, path);
            // Agrega screenshot al reporte
            Reporter.addScreenCaptureFromPath(newPath.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}