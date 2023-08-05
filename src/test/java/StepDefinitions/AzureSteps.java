package StepDefinitions;

import Pages.AzurePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static StepDefinitions.BrowserConfig.BASE_URL;

public class AzureSteps {

    WebDriver driver = null;

    @Before
    public void setup() {
        if (this.driver == null) {
            this.driver = BrowserConfig.getIEWebDriver();
        }
    }

    @After
    public void cleanUp() {
        BrowserConfig.releaseResources(driver);
    }

    @And("^user clicks on \"([^\"]*)\" button$")
    public void clickOnButton(String button) throws InterruptedException {
        AzurePage azurePage = new AzurePage(driver);
        azurePage.clickOnButton(button);
    }

    @Then("^user redirected to the dashboard$")
    public void hasTheDashboardOpened() {
        AzurePage azurePage = new AzurePage(driver);
        Assert.assertTrue("the dashboard screen has been opened", azurePage.hasTheDashboardOpened());
        Assert.assertNotEquals("the user has redirected to home page successfully", BASE_URL, azurePage.getCurrentURL());
    }

    @Given("^user get the title of the home page$")
    public void getTheTitleOfTheHomePage() {
        AzurePage azurePage = new AzurePage(driver);
        System.out.println("the title of the home page: " + azurePage.getHomePageTitle());
    }

    @And("^user can see the signed out snack bar$")
    public void hasTheSignedOutSnackBarAppeared() {
        AzurePage azurePage = new AzurePage(driver);
        Assert.assertEquals("the signed out message is displayed successfully in the snack bar", "Signed out successfully", azurePage.getTheSnackBarContent());
    }

    @Then("^user can not see the dashboard$")
    public void hasTheDashboardClosed() {
        AzurePage azurePage = new AzurePage(driver);
        Assert.assertTrue("the dashboard screen has been closed", azurePage.hasTheDashboardClosed());
    }

    @Given("^user login using \"([^\"]*)\" as username and \"([^\"]*)\" as password$")
    public void loginUsingUsernameAndAsPassword(String usernameValue, String passwordValue) throws InterruptedException {
        AzurePage azurePage = new AzurePage(driver);
        azurePage.enterTextIntoTheField("username", usernameValue);
        azurePage.enterTextIntoTheField("password", passwordValue);
        azurePage.clickOnButton("sign in");
    }

    @And("^user can see the login page$")
    public void isTheLoginPageDisplayed() {
        AzurePage azurePage = new AzurePage(driver);
        Assert.assertTrue("the user can see the login page", azurePage.isTheLoginPageDisplayed());
    }
}
