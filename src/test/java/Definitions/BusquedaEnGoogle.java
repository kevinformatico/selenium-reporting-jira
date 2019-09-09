package Definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

public class BusquedaEnGoogle {

    WebDriver driver;

    @Given("Estoy en la pagina {string}")
    public void estoy_en_la_pagina(String url) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headles");
        this.driver = new ChromeDriver(chromeOptions);

        driver.get(url);
    }

    @When("busco la palabra {string}")
    public void busco_la_palabra(String palabraABuscar) {

        driver.findElement(By.name("q")).sendKeys(palabraABuscar);
        driver.findElement(By.name("q")).submit();

    }

    @Then("aparecen enlaces relacionados con {string}")
    public void aparecen_enlaces_relacionados_con(String palabraRelacionada) {

        String texto = driver.findElement(By.xpath("//*[@id=\"vn1s0p1c0\"]/h3")).getText();
        assertTrue(texto.contains(palabraRelacionada));

    }

    @Then("hacer click en el enlace")
    public void hacer_click_en_el_enlace() {
        driver.findElement(By.xpath("//*[@id=\"vn1s0p1c0\"]/h3")).click();
    }

}
