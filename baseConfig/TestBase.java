package baseConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected static WebDriver webDriver;
    protected static WebDriverWait wait;
    @BeforeSuite
    public void setUp() {
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    protected WebDriver getDriver() {
        if (webDriver == null)
            webDriver = new FirefoxDriver();
        return webDriver;
    }
    @AfterSuite
    public void closeDown() {
        webDriver.quit();
    }
}


