package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrangeHRMyTimesheetPage {
    public OrangeHRMyTimesheetPage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="startDates")
    public WebElement timeSheetDropdown;

    @FindBy(xpath = "//option[@value='0']")
    public WebElement date1;
   //

    @FindBy(id="btnEdit")
    public WebElement editButton;

    @FindBy(id="btnAddRow")
    public WebElement addRowButton;

    @FindBy(id="initialRows_0_projectName")
    public WebElement projectName;

    @FindBy(id="initialRows_0_projectActivityName")
    public WebElement activityName;

    @FindBy(id="initialRows_0_0")
    public WebElement monday;

    @FindBy(id="initialRows_0_1")
    public WebElement tuesday;

    @FindBy(id="initialRows_0_2")
    public WebElement wednesday;

    @FindBy(id="initialRows_0_3")
    public WebElement thursday;

    @FindBy(id="initialRows_0_4")
    public WebElement friday;

    @FindBy(id="initialRows_0_5")
    public WebElement saturday;

    @FindBy(id="initialRows_0_6")
    public WebElement sunday;

    @FindBy(id="submitSave")
    public WebElement saveButton;

    @FindBy(id="timesheet_status")
    public WebElement statusOfSubmitted;

    @FindBy(id="btnEdit")
    public WebElement editButtonToRemove;

    @FindBy(id="initialRows_0_toDelete")
    public WebElement chooseRadioButton;

    @FindBy(id="submitRemoveRows")
    public WebElement removeButton;

    @FindBy(id = "btnSubmit")
    public WebElement submitButton;


}
