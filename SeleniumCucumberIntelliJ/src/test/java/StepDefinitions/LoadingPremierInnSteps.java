package StepDefinitions;

import com.qa.pages.BookingPageInformation;
import com.qa.pages.LoadingPremierInnPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.TestBase;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoadingPremierInnSteps extends TestBase {
    WebDriver driver;


    //LoadingPremierInnPage loadingPremierInnPage = new LoadingPremierInnPage();
    LoadingPremierInnPage loadingPremierInnPage;
    BookingPageInformation bookingPageInformation;

    @Given("user opens premier Inn booking website")
    public void user_opens_premier_Inn_booking_website()
    {
        TestBase.initialization();
        //boolean flag = loadingPremierInnPage.isPremierInnLogoDisplayed();
        loadingPremierInnPage = new LoadingPremierInnPage();
        boolean flag = loadingPremierInnPage.isPremierInnLogoDisplayed();
        Assert.assertTrue(flag);
    }




}
