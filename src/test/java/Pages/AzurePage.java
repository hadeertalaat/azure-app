package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AzurePage {

    WebDriver driver = null;
    By usernameField = By.id("mat-input-0");
    By usernameFieldAfterLoggedOut = By.id("mat-input-2");
    By passwordField = By.id("mat-input-1");
    By signinButton = By.xpath("//button[@class='block primary']");
    By accountSidMenuButton = By.xpath("//header//div[@class='user']/img");
    By logoutButton = By.xpath("//header//div[@class='user']//li[text()='Logout']");
    By dashboardMessage = By.xpath("//p[text()='Welcome To Dashboard']");
    By homeTitle = By.xpath("//section//breadcrumb//p");
    By snackbarContent = By.xpath("//*[@id='cdk-overlay-0']//p");

    public AzurePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterTextIntoTheField(String field, String text) {
        final By locator;

        switch (field) {
            case "username":
                locator = usernameField;
                break;
            case "password":
                locator = passwordField;
                break;
            default:
                locator = null;
        }
        (new WebDriverWait(driver, Duration.ofSeconds(100)))
                .until((ExpectedCondition<Boolean>) driver -> driver.findElement(locator).isDisplayed());
        driver.findElement(locator).sendKeys(text);
    }

    public void clickOnButton(String button) throws InterruptedException {
        final By locator;
        switch (button) {
            case "sign in":
                locator = signinButton;
                break;
            case "log out":
                locator = logoutButton;
                break;
            case "account side menu":
                locator = accountSidMenuButton;
                break;
            default:
                locator = null;
        }
        driver.findElement(locator).click();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public boolean hasTheDashboardOpened() {
        (new WebDriverWait(driver, Duration.ofSeconds(100))).until((ExpectedCondition<Boolean>) driver -> driver.findElement(dashboardMessage).isDisplayed());
        return driver.findElement(dashboardMessage).isDisplayed();
    }

    public String getHomePageTitle() {
        return driver.findElement(homeTitle).getText();
    }

    public String getTheSnackBarContent() {
        (new WebDriverWait(driver, Duration.ofSeconds(50))).until((ExpectedCondition<Boolean>) driver -> driver.findElement(snackbarContent).isDisplayed());
        return driver.findElement(snackbarContent).getText();
    }

    public boolean hasTheDashboardClosed() {
        try {
            return !driver.findElement(dashboardMessage).isDisplayed();
        } catch (Exception e) {
            return true;
        }
    }

    public boolean isTheLoginPageDisplayed() {
        return driver.findElement(usernameFieldAfterLoggedOut).isDisplayed();
    }

}
