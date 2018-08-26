package myprojects.automation.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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
        // enter to the 'category' menu
        waitForContentLoad();
        Actions action = new Actions(driver);
        WebElement catalog = driver.findElement(By.linkText("Каталог"));
        action.moveToElement(catalog).perform();
        WebElement category = driver.findElement(By.linkText("категории"));
        action.moveToElement(category).click().perform();

        // enter to the 'add new category' page
        waitForContentLoad();
        WebElement addCategoryButton = driver.findElement(By.id("page-header-desc-category-new_category"));
        addCategoryButton.click();

        // add new category
        waitForContentLoad();
        WebElement categoryNameField = driver.findElement(By.id("name_1"));
        categoryNameField.sendKeys(categoryName);
        WebElement submit = driver.findElement(By.id("category_form_submit_btn"));
        submit.click();

        // check if confirmation message appears
        waitForContentLoad();
        List<WebElement> message = driver.findElements(By.xpath("//div[@class='alert alert-success']"));
        if (message.size() > 0) System.out.println("Категорию создано");
        else System.out.println("Категорию не создано");
    }

    /**
     * Checks whether category exist.
     * @param categoryName
     */
    public void checkCategoryIfExist(String categoryName) {
        // enter categoryName in search field and submit
        waitForContentLoad();
        WebElement search = driver.findElement(By.name("categoryFilter_name"));
        search.sendKeys(categoryName);
        search.submit();

        // check present of category
        waitForContentLoad();
        WebElement message = driver.findElement(By.xpath("//table[@id='table-category']/tbody//td[3]"));
        if (message.getText().equals(categoryName)) System.out.println("Категория присутствует");
        else System.out.println("Категория отсутствует");
    }

    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ajax_running")));
    }

}
