package Definitions;

import JiraServer.ClientJira;
import JiraServer.FuncionesBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.ws.rs.client.Client;
import java.util.ArrayList;
import java.util.Properties;

import static org.junit.Assert.assertTrue;

public class BusquedaEnGoogle extends BasePage{

    public static ArrayList<String> stepTest = new ArrayList<String>(), listaPasos, listaResultados;
    static Client client;

    public BusquedaEnGoogle() {
    }

    public BusquedaEnGoogle(WebDriver driver) {
        super(driver);
    }

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

        try {

            //Describir nombres de pasos
            stepTest.add("Abrir URL Web BanFalabella_A");
            stepTest.add("Ingresar al Login Web BanFalabella_A");
            stepTest.add("Seleccionar Categoria_a");
            stepTest.add("Seleccionar Item_a");

            //Crea los pasos en Zephyr(JIRA)
            client = ClientJira.getInstance();
            String idIssue = ClientJira.retornaIdIssue("MT","CDP-Hector");

            //Recuperamos la cantidad de pasos asociados al caso
            int size = ClientJira.retornaCantidadPasosTestJIRA(idIssue);

            //Si contiene pasos, debemos eliminar
            if(size > 0) {
                listaPasos = ClientJira.retornaListaPasosTestJIRA(idIssue);
                ClientJira.eliminaPasosTestJIRA(idIssue, listaPasos);
            }

            //Creamos los pasos en Zephyr en base a la lista ingresada
            for (int i = 0; i < stepTest.size(); i++) {
                ClientJira.crearPasoTestJIRA(stepTest.get(i), "", "", idIssue);
            }

        }catch(Exception e) {
            System.out.println("Error al setear pasos al test: " + e.getMessage());
        }

        estado = "OK";
        if(!FuncionesBase.estadoPaso("Abrir URL Web BanFalabella", estado, false).equals("OK")) {
            this.exitTest();
        }
    }

    @When("busco la palabra {string}")
    public void busco_la_palabra(String palabraABuscar) {

        driver.findElement(By.name("q")).sendKeys(palabraABuscar);
        driver.findElement(By.name("q")).submit();

        estado =  estado = "OK";
        if(!FuncionesBase.estadoPaso("Ingresar al Login Web BanFalabella", estado, false).equals("OK")) {
            this.exitTest();
        }
    }

    @Then("aparecen enlaces relacionados con {string}")
    public void aparecen_enlaces_relacionados_con(String palabraRelacionada) {
        String primerLink = driver.findElement(By.xpath("(//h3[contains(text(),'Autos ')])[1]")).getText();
        if(primerLink.contains(palabraRelacionada)) {
            //test.log(LogStatus.PASS, "Navigated to the specified URL");
            //screenshot(driver,"BusquedaEnGoogle");
        } else {
            //test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
        }

        estado =  estado = "OK";
        if(!FuncionesBase.estadoPaso("Seleccionar Categoria", estado, false).equals("OK")) {
            this.exitTest();
        }
    }

    @Then("hacer click en el enlace")
    public void hacer_click_en_el_enlace() {
        estado =  estado = "OK";
        if(!FuncionesBase.estadoPaso("Seleccionar Item", estado, false).equals("OK")) {
            this.exitTest();
        }
    }

}
