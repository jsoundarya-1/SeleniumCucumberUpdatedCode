package StepDefinitions;

import com.qa.pages.BookingPageInformation;
import com.qa.pages.ManageBookingPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileWriter;
import java.io.IOException;

public class BookingPageSteps {
    WebDriver driver;

    BookingPageInformation bookingPageInformation = new BookingPageInformation();




    @Given("User is already on Booking Information Page")
    public void user_is_already_on_Booking_Information_Page() {
       boolean flag = bookingPageInformation.isBookingTitleDisplayed();
        Assert.assertTrue(flag);
    }
    @Then("Verify whether the booking got cancelled")
    public void verify_whether_the_booking_got_cancelled() throws IOException {
        String cancellationNumber = bookingPageInformation.bookingReference.getText();
        System.out.println(cancellationNumber);
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        FileWriter DestFile = new FileWriter(dir + "\\src\\main\\resources\\cancellationnumber.csv");
        DestFile.write(cancellationNumber);
        DestFile.close();
    }

//    @When("User clicks on Cancel Booking button")
//    public void user_clicks_on_Cancel_Booking_button() {
//      bookingPageInformation.userClicksOnCancelBookingButton();
//    }
//
//    @And("Cancel your booking pop up appears")
//    public void cancel_your_booking_pop_up_appears() {
//      bookingPageInformation.isCancelBookingPopupPageDisplayed();
//    }
//
//    @When("User clicks on  Cancel booking button on the pop up")
//    public void user_clicks_on_Cancel_booking_button_on_the_pop_up() {
//      bookingPageInformation.userClicksOnPopupCancelBookingButton();
//    }
//
//    @Then("Verify whether the booking got cancelled")
//    public void verify_whether_the_booking_got_cancelled() {
//
//    }


}
