package Utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ExtendReport {
    static ExtentTest test;
    static ExtentReports report;

    static Random numero = new Random();
    static int numeroAleatorio = numero.nextInt(10000);

    @BeforeClass
    public static void startTest()
    {

        report = new ExtentReports(System.getProperty("user.dir")+"\\reportes\\ejecucion_"+numeroAleatorio+"\\ExtentReportResults_"+numeroAleatorio+".html");
        test = report.startTest("ExtentDemo");
    }

    @AfterClass
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }

    public static String capture(WebDriver driver)  {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File Dest = new File("reportes\\ejecucion_"+numeroAleatorio+"\\ejecucion_"+ numeroAleatorio + /*System.currentTimeMillis()
                    +*/ ".png");
            String errflpath = Dest.getAbsolutePath();
            FileUtils.copyFile(scrFile, Dest);
            return errflpath;
        }catch (IOException e ){
            return e.getMessage();
        }
    }
}
