package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.OrangeAppLoginPage;
import pages.OrangeHRMHomePage;
import pages.OrangeHRMyTimesheetPage;
import utilities.ConfigReader;
import utilities.Driver;

public class OrangeHRMAppUsersSteps {

    WebDriver driver = Driver.getDriver();
    OrangeAppLoginPage orangeAppLoginPage = new OrangeAppLoginPage();
    OrangeHRMHomePage orangeHRMHomePage = new OrangeHRMHomePage();
    OrangeHRMyTimesheetPage orangeHRMyTimesheetPage = new OrangeHRMyTimesheetPage();

    @Given("user navigates to the HRM App")
    public void user_navigates_to_the_HRM_App() {
        driver.get(ConfigReader.getProperty("OrangeHRMURL"));
    }


    @When("user Provides credentials username {string} and password {string}")
    public void user_Provides_credentials_username_and_password(String string, String string2) {
        orangeAppLoginPage.username.sendKeys(string);
        orangeAppLoginPage.password.sendKeys(string2);
        orangeAppLoginPage.loginButton.click();

    }
    @When("user Moves to users page")
    public void user_Moves_to_users_page() {


    }
    @Then("user searches for valid user with data")
    public void user_searches_for_valid_user_with_data(io.cucumber.datatable.DataTable dataTable) {
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V>
    }
    @Then("user validates user is shown")
    public void user_validates_user_is_shown() {

    }



    public void user_navigates_to_the_HRM_app() {

    }



    @When("user provides credentials username {string} and password {string}")
    public void user_provides_credentials_username_and_password(String string, String string2) {

    }
    @When("user moves to users page")
    public void user_moves_to_users_page() {

    }
    @Then("user searches for invalid user with data")
    public void user_searches_for_invalid_user_with_data(io.cucumber.datatable.DataTable dataTable) {
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V>

    }
    @Then("user validates error message {string} is shown")
    public void user_validates_error_message_is_shown(String string) {

    }

}
