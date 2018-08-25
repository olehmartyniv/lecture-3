package myprojects.automation.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static myprojects.automation.assignment3.utils.Properties.getBaseAdminUrl;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * Logs in to Admin Panel.
     * @param login
     * @param password
     */
    public void login(String login, String password) {
        // open page for log in
        driver.get(getBaseAdminUrl());

        // fill email form
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(login);

        // fill password form
        WebElement pass = driver.findElement(By.id("passwd"));
        pass.sendKeys(password);

        // log in by clicking button
        WebElement signIn = driver.findElement(By.name("submitLogin"));
        signIn.click();
    }

    /**
     * Adds new category in Admin Panel.
     * @param categoryName
     */
    public void createCategory(String categoryName) {
        // TODO implement logic for new category creation
        throw new UnsupportedOperationException();

    }

    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajax_running")));
    }

}
