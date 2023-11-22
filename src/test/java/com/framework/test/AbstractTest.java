package com.framework.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class AbstractTest {

    protected WebDriver driver;

    @BeforeTest
    public void setParameters(){
        this.driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void quitDriver()
    {
        driver.quit();
    }
}
