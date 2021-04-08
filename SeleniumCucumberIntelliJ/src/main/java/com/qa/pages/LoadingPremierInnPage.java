package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;

public class LoadingPremierInnPage extends TestBase {
   WebDriver driver;
   @FindBy(xpath = "//button[@id = 'log-in']")
   public WebElement loginButton;

   public LoadingPremierInnPage()
    {
      PageFactory.initElements(TestBase.driver, this);
    }
    public boolean isPremierInnLogoDisplayed()

    {
        System.out.println("Is Premier Inn");
        System.out.println(loginButton.isDisplayed());
        System.out.println("Its working");
       return loginButton.isDisplayed();

    }

}
