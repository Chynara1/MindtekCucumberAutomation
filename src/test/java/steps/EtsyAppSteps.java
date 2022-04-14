package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EtsyAppSearchPage;
import pages.EtsyHomePage;
import pages.WebOrdersLoginPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Locale;

public class EtsyAppSteps {

    WebDriver driver = Driver.getDriver();
    EtsyHomePage etsyHomePage = new EtsyHomePage();
    EtsyAppSearchPage etsyAppSearchPage = new EtsyAppSearchPage();

    @Given("user navigates to the Etsy application")
    public void user_navigates_to_the_Etsy_application() {
        driver.get(ConfigReader.getProperty("EtsyURL"));
    }


    @When("user searches for {string}")
    public void user_searches_for(String itemName) {
        etsyHomePage.searchBox.sendKeys(itemName + Keys.ENTER);

    }


    @When("user applies price filter over {int}")
    public void user_applies_price_filter_over(Integer price) {
        etsyAppSearchPage.allFilterButton.sendKeys(Keys.ENTER);
        BrowserUtils.scrollUpOrDown(500);
        etsyAppSearchPage.priceRadioButton.click();
        etsyAppSearchPage.applyButton.click();

    }

    @Then("user validates the items price is equal  over {double}")
    public void user_validates_the_items_price_is_equal_over(Double price) throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> prices = etsyAppSearchPage.prices;

        for (WebElement element : prices) {
//            System.out.println(element.getText());
            String priceStr = element.getText().replace(",", "");//1,800.00 ->1800.00
            double doublePrice = Double.parseDouble(priceStr);
            System.out.println(doublePrice);
            Assert.assertTrue(doublePrice >= price);


        }
    }

    @Then("user validates search result items contain  keyword {string} or {string}")
    public void userValidatesSearchResultItemsContainKeyword(String item, String item2) {
        List<WebElement> itemNames = etsyAppSearchPage.itemNames;

        for (int i = 0; i < itemNames.size(); i++) {
            String newItemNames = itemNames.get(i).getText();//looping through  the list of Element and getting Text from each WebElement
            boolean condition = newItemNames.toLowerCase(Locale.ROOT).contains(item) || newItemNames.toLowerCase(Locale.ROOT).contains(item2);
            if (condition) {
                StringBuilder str = new StringBuilder();//create an StringBuilder object
                str.append(newItemNames);// each time it will add one more String from newItemNames until the list of WEbElement has elements
                System.out.println(str);
                Assert.assertTrue(str.toString().toLowerCase(Locale.ROOT).contains(item) || str.toString().toLowerCase(Locale.ROOT).contains(item2));
            }
        }
    }

    @When("user clicks on {string} section")
    public void userClicksOnSection(String section) {
        if (section.equalsIgnoreCase("Mother's Day Gifts")) {
            etsyHomePage.mothersDayGift.click();
        } else if (section.equalsIgnoreCase("Jewelery and Accessories")) {
            etsyHomePage.jeweleryAccessories.click();
        } else if (section.equalsIgnoreCase("Clothing and Shoes")) {
            etsyHomePage.clothingAndShoes.click();
        } else if (section.equalsIgnoreCase("Home and Living")) {
            etsyHomePage.homeAndLiving.click();
        } else if (section.equalsIgnoreCase("Wedding and Party")) {
            etsyHomePage.weddingAndParty.click();
        } else if (section.equalsIgnoreCase("Toys and Entertainment")) {
            etsyHomePage.toysAndEntertainment.click();
        } else if (section.equalsIgnoreCase("Art and Collectibles")) {
            etsyHomePage.artAndCollectible.click();
        } else if (section.equalsIgnoreCase("Craft Supplies and Tools")) {
            etsyHomePage.craftSupplies.click();
        } else if (section.equalsIgnoreCase("Gifts and Gift Cards")) {
            etsyHomePage.giftAndGiftCards.click();
        }
    }

    @Then("user validates title is {string}")
    public void userValidatesTitleIs(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
