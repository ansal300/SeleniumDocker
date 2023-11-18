package com.myframework.pages.flightreservation;

import com.myframework.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationConfirmationPage extends AbstractPage {

    private WebDriver driver;
    @FindBy(id = "go-to-flights-search")
    private WebElement goToFlightsSearchButton;

    @FindBy(css = "#registration-confirmation-section p b")
    private WebElement firstNameElement;

    public RegistrationConfirmationPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.goToFlightsSearchButton));
        return goToFlightsSearchButton.isDisplayed();
    }

//    @Override
//    public boolean isAt() {
//        this.wait.until(ExpectedConditions.visibilityOf(this.goToFlightsSearchButton));
//        return this.goToFlightsSearchButton.isDisplayed();
//    }

    public String getFirstName(){
        return this.firstNameElement.getText();
    }

    public void goToFlightsSearch(){
        goToFlightsSearchButton.click();
    }
}
