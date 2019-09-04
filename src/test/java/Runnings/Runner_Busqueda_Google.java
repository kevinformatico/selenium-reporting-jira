package Runnings;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@busquedaGoogle",
        plugin = {"junit:target/cucumber.xml", "json:target/cucumber.json"})

public class Runner_Busqueda_Google extends Runner{
}
