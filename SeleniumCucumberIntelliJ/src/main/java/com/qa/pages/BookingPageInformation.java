package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;

public class BookingPageInformation extends TestBase{
    WebDriver driver;
    @FindBy(xpath = "//h3[contains(text(), 'Booking information')]")
    public WebElement BookingInformationTitle;
    @FindBy(xpath = "//button[contains(text(),'Cancel booking')]")
    public WebElement cancelBookingButton;
    @FindBy(xpath = "//button[contains(text(),'Keep booking')]")
    public WebElement cancelBookingPopupPage;
    @FindBy(xpath = "//button[@class = 'wb-btn print--remove wb-btn--primary wb-btn--small wb-btn--full-width wb-push--bottom']")
    public WebElement popUpCancelBookingButton;
    @FindBy(xpath = "//h3[@data-test-id = 'booking-reference']")
    public WebElement bookingReference;

    public BookingPageInformation()
    {
        PageFactory.initElements(TestBase.driver, this);
    }
    public boolean isBookingTitleDisplayed()
    {
        return BookingInformationTitle.isDisplayed();
    }
    public void userClicksOnCancelBookingButton()
    {
        cancelBookingButton.click();
    }
    public boolean isCancelBookingPopupPageDisplayed()
    {
        return cancelBookingPopupPage.isDisplayed();
    }
    public void userClicksOnPopupCancelBookingButton()
    {
        popUpCancelBookingButton.click();
    }
}
