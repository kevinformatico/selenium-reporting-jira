package Definitions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;

import static org.junit.Assert.assertTrue;

public class BusquedaEnGoogle extends ExtendReportsss {

    public BusquedaEnGoogle(ExtentTest test, ExtentReports report) {
        super(test, report);
    }

    WebDriver driver;

    @Given("Estoy en la pagina {string}")
    public void estoy_en_la_pagina(String url) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Tested in Google Chrome 59 on Linux. More info on:
        // https://developers.google.com/web/updates/2017/04/headless-chrome
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        this.driver = new ChromeDriver(options);
        driver.get(url);
    }

    @When("busco la palabra {string}")
    public void busco_la_palabra(String palabraABuscar) {

        driver.findElement(By.name("q")).sendKeys(palabraABuscar);
        driver.findElement(By.name("q")).submit();

    }

    @Then("aparecen enlaces relacionados con {string}")
    public void aparecen_enlaces_relacionados_con(String palabraRelacionada) {

        if(driver.getTitle().equals("Google")) {
            test.log(LogStatus.PASS, "Navigated to the specified URL");
        } else {
            test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
        }

    }

    @Then("hacer click en el enlace")
    public void hacer_click_en_el_enlace() {
        //PRUEBA
    }

}
