package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AmazonAppFiltersPage {
    public AmazonAppFiltersPage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "p_36/2661614011")
    public WebElement searchPrizeOver50;

    @FindBy(xpath = "//span[@class='a-price-whole']")
    public List<WebElement> pricesForDresses;
}
