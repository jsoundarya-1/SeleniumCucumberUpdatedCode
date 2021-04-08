package StepDefinitions;

import com.qa.pages.BookingPageInformation;
import com.qa.pages.ManageBookingPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import util.TestBase;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ManageBookingSteps {
    WebDriver driver;
    ManageBookingPage manageBookingPage = new ManageBookingPage();
    BookingPageInformation bookingPageInformation = new BookingPageInformation();

    @When("User clicks on Manage Booking Button")
    public void user_clicks_on_Manage_Booking_Button() {
        manageBookingPage.userClicksOnManageBookingButton();

    }

    @Then("user will be landing on the Booking Informationn Page")
    public BookingPageInformation user_will_be_landing_on_tnhe_Booking_Information_Page() {

        manageBookingPage.searchButton.click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        return new BookingPageInformation();
    }

    @When("User clickks on Manage Booking Button")
    public void user_clickks_on_Manage_Booking_Button() {


        if (manageBookingPage.manageBooking.isDisplayed()) {
            System.out.println("Test message here");
            manageBookingPage.manageBooking.click();
        } else {
            System.out.println("Test message here - Web Element not displayed");
        }

    }

    @And("Filling the details of the Manage Booking Pop up Menu")
    public void filling_the_details_of_the_Manage_Booking_Pop_up_Menu(DataTable bookingTable) {
        List<List<String>> data = bookingTable.asLists();
        manageBookingPage.bookingReferenceTextField.click();
        manageBookingPage.bookingReferenceTextField.sendKeys(data.get(0).get(0));
        manageBookingPage.bookingSurName.click();
        manageBookingPage.bookingSurName.sendKeys(data.get(0).get(1));
        manageBookingPage.dropDownButton.click();
        String flag = "False";
        while(flag == "False")
        {
            if (manageBookingPage.mayOption.isDisplayed())
            {
                //manageBookingPage.datePickerRightArrow.click();
                manageBookingPage.mayOption.click();
                flag = "True";
            }
            else
            {
                System.out.println("Checking loop here");
                manageBookingPage.datePickerRightArrow.click();
            }
        }
        manageBookingPage.searchButton.click();

    }

    }
