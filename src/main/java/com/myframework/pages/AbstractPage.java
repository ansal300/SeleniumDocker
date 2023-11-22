package com.myframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(this.driver, Duration.ofSeconds(50));
        PageFactory.initElements(driver,this);
    }

    public abstract boolean isAt();
}
