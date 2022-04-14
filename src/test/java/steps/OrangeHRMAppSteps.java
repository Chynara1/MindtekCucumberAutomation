package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.OrangeAppLoginPage;
import pages.OrangeHRMHomePage;
import pages.OrangeHRMyTimesheetPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class OrangeHRMAppSteps {

    WebDriver driver = Driver.getDriver();
    OrangeAppLoginPage orangeAppLoginPage = new OrangeAppLoginPage();
    OrangeHRMHomePage orangeHRMHomePage = new OrangeHRMHomePage();
    OrangeHRMyTimesheetPage orangeHRMyTimesheetPage = new OrangeHRMyTimesheetPage();
    List<Map<String, Object>> data;


    @Given("user send username {string} and password {string}")
    public void user_send_username_and_password(String username, String password) {
        driver.get(ConfigReader.getProperty("OrangeHRMURL"));
        orangeAppLoginPage.username.sendKeys(username);
        orangeAppLoginPage.password.sendKeys(password);
        orangeAppLoginPage.loginButton.click();

    }

    @When("user navigates to {string} page")
    public void user_navigates_to_page(String string) throws InterruptedException {
        BrowserUtils.hoverOver(orangeHRMHomePage.timeBox);
        Thread.sleep(3000);
        BrowserUtils.hoverOver(orangeHRMHomePage.timeSheetButton);
        Thread.sleep(3000);
        orangeHRMHomePage.myTimeSheet.click();


    }


    @When("user chooses and clicks one of the {string} weeks from dropdown")
    public void user_chooses_and_clicks_one_of_the_weeks_from_dropdown(String string) throws InterruptedException {
        BrowserUtils.selectDropdownByValue(orangeHRMyTimesheetPage.timeSheetDropdown, "0");
        Thread.sleep(3000);


    }

    @Then("user validates the desired {string} week is selected")
    public void user_validates_the_desired_week_is_selected(String expectedData) {
        Assert.assertTrue(orangeHRMyTimesheetPage.date1.isSelected());

//        String actualTimesheetData=orangeHRMyTimesheetPage.date1.getText();
//        Assert.assertEquals(expectedData,actualTimesheetData);

    }


    @When("user adds a row to the week")
    public void user_adds_a_row_to_the_week(DataTable dataTable) throws InterruptedException {
        data = dataTable.asMaps(String.class, Object.class);
        orangeHRMyTimesheetPage.editButton.click();
//        orangeHRMyTimesheetPage.addRowButton.click();
        Thread.sleep(300);
        orangeHRMyTimesheetPage.projectName.click();
        orangeHRMyTimesheetPage.projectName.sendKeys(Keys.CLEAR);
        orangeHRMyTimesheetPage.projectName.sendKeys(data.get(0).get("Project Name").toString());
        orangeHRMyTimesheetPage.projectName.sendKeys(Keys.ENTER);
        orangeHRMyTimesheetPage.activityName.click();
        BrowserUtils.selectDropdownByVisibleText(orangeHRMyTimesheetPage.activityName, data.get(0).get("Activity Name").toString());
        orangeHRMyTimesheetPage.monday.sendKeys(data.get(0).get("Mon 4").toString());
        orangeHRMyTimesheetPage.tuesday.sendKeys(data.get(0).get("Tue 5").toString());
        orangeHRMyTimesheetPage.wednesday.sendKeys(data.get(0).get("Wed 6").toString());
        orangeHRMyTimesheetPage.thursday.sendKeys(data.get(0).get("Thu 7").toString());
        orangeHRMyTimesheetPage.friday.sendKeys(data.get(0).get("Fri 8").toString());
        orangeHRMyTimesheetPage.saturday.sendKeys(data.get(0).get("Sat 9").toString());
        orangeHRMyTimesheetPage.sunday.sendKeys(data.get(0).get("Sun 10").toString());
        orangeHRMyTimesheetPage.saveButton.click();
        orangeHRMyTimesheetPage.submitButton.click();


    }


    @Then("user validates the row is added")
    public void user_validates_the_row_is_added() throws InterruptedException {
        String actualMessage = orangeHRMyTimesheetPage.statusOfSubmitted.getText();
        String expectedMessage = "Status: Submitted\n";
        Assert.assertEquals(expectedMessage, actualMessage);
        Thread.sleep(3000);

//        $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//        orangeHRMyTimesheetPage.editButtonToRemove.click();
//        orangeHRMyTimesheetPage.chooseRadioButton.click();
//        orangeHRMyTimesheetPage.removeButton.click();
    }


}

