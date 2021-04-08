package com.qa.pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;

import java.util.List;
import java.util.Map;

public class ManageBookingPage extends TestBase{
    BookingPageInformation bookingPageInformation;
    WebDriver driver;
    @FindBy(xpath = "//button[@id = 'find-a-booking']")
    public WebElement manageBooking;
    @FindBy(xpath = "//input[@id = 'booking-reference-input']")
    public WebElement bookingReferenceTextField;
    @FindBy(xpath = "//input[@id = 'booking-surname-input']")
    public WebElement bookingSurName;
    @FindBy(xpath = "//div[contains(text(),'Arrival date *')]")
    public WebElement arrivalDate;
    @FindBy(xpath = "//button[contains(text(), 'Search')]")
    public WebElement searchButton;
    @FindBy(xpath = "//*[@id='find-booking-form']/div[3]/div[3]/drop-down-group/div[1]/div/input")
    public WebElement dropDownButton;
    @FindBy(xpath = "//button[@id = 'date-picker-day-2152021'][contains (@aria-label, '21 May 2021') ]")
    public WebElement mayOption;
    @FindBy(xpath = "//*[@id='date-picker-day-date-picker-header']/button[2]")
    public WebElement datePickerRightArrow;
    public ManageBookingPage()
    {
        PageFactory.initElements(TestBase.driver, this);
    }
    public void userClicksOnManageBookingButton()
    {
        System.out.println("Manage Booking Button");
        manageBooking.click();
    }
    public BookingPageInformation filling_the_details_of_the_Manage_Booking_Pop_up(DataTable bookingTable) {
        List<List<String>> data = bookingTable.asLists();

        bookingReferenceTextField.click();
        bookingReferenceTextField.sendKeys(data.get(0).get(0));
        bookingSurName.click();
        bookingSurName.sendKeys(data.get(0).get(1));
        dropDownButton.click();
        String flag = "False";
        while(flag == "False")
        {
            if (driver.findElements(By.xpath("//button[@id = 'date-picker-day-2152021'][contains (@aria-label, '21 May 2021') ]")).size() > 0 )
            {
                driver.findElements(By.xpath("//button[@class = 'calendar-chevron date-picker-right-arrow']")).get(1).click();
                driver.findElement(By.xpath("//button[@id = 'date-picker-day-2152021'][contains (@aria-label, '21 May 2021') ]")).click();
                flag = "True";
            }
            else
            {
                System.out.println("Checking loop here");
                driver.findElements(By.xpath("//button[@class = 'calendar-chevron date-picker-right-arrow']")).get(1).click();
            }
        }
        searchButton.click();
        return new BookingPageInformation();
    }
}
