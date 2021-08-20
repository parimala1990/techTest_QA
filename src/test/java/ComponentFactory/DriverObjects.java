package ComponentFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.picocontainer.Disposable;

import java.util.concurrent.TimeUnit;

public class DriverObjects{

    WebDriver driver;

    public WebDriver getDriver() {
        driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.co.uk/");
        driver.findElement(By.id("sp-cc-accept")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        driver.manage().window().maximize();
        return driver;
    }

    public void quitDriver()
    {
        driver.quit();
    }

}
