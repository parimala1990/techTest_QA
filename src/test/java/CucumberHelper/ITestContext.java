package CucumberHelper;

import ComponentFactory.DriverObjects;
import ComponentFactory.PageObjects;

public class ITestContext {
    private DriverObjects webDriverManager;
    private PageObjects pageObjectManager;

    public ITestContext() {
        this.webDriverManager = new DriverObjects();
        this.pageObjectManager = new PageObjects(this.webDriverManager.getDriver());
    }

    public DriverObjects getWebDriverManager() {
        return this.webDriverManager;
    }

    public PageObjects getPageObjectManager() {
        return this.pageObjectManager;
    }

    public void tearDown()
    {
        webDriverManager.quitDriver();
    }

}
