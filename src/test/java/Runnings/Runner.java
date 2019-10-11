package Runnings;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.apache.log4j.BasicConfigurator;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = "Definitions",
        tags = {"not @todo"},
        plugin = {"pretty","json:target/cucumber-report/cucumber.json", "junit:target/cucumber.xml", "html:target/cucumber-report"})

public class Runner {

    @BeforeClass
    public static void configure(){
        BasicConfigurator.configure();
    }

}
