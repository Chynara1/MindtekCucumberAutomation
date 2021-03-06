package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrangeHRMHomePage {
  public   OrangeHRMHomePage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="menu_time_viewTimeModule")
    public WebElement timeBox;

    @FindBy(id="menu_time_Timesheets")
    public WebElement timeSheetButton;

    @FindBy(id="menu_time_viewMyTimesheet")
    public WebElement myTimeSheet;


}
