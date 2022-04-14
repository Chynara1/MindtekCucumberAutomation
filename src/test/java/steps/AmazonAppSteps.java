package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AmazonAppFiltersPage;
import pages.AmazonAppHomePage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class AmazonAppSteps {
    WebDriver driver = Driver.getDriver();
    AmazonAppHomePage amazonAppHomePage = new AmazonAppHomePage();
    AmazonAppFiltersPage amazonAppFiltersPage=new AmazonAppFiltersPage();


    @Given("user navigates to the Amazon application")
    public void user_navigates_to_the_Amazon_application() {
        driver.get(ConfigReader.getProperty("AmazonAppURL"));

    }


    @When("user searches for the {string}")
    public void user_searches_for_the(String string) {
        amazonAppHomePage.searchBox.sendKeys(string + Keys.ENTER);

    }

    @When("user applies price filter over {string}")
    public void user_applies_price_filter_over(String string) {
        BrowserUtils.scrollUpOrDown(800);
        amazonAppFiltersPage.searchPrizeOver50.click();

    }

    @Then("user validates the items price is equal to over {int}")
    public void user_validates_the_items_price_is_equal_to_over(Integer price) {
        List <WebElement> prices=amazonAppFiltersPage.pricesForDresses;

        for(WebElement element: prices){
            System.out.println(element.getText());
//
        }


    }


}
