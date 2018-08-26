package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.GeneralActions;
import org.openqa.selenium.WebDriver;

public class CreateCategoryTest extends BaseScript {
    public static void main(String[] args) throws InterruptedException {
        // prepare driver object
        WebDriver driver = getConfiguredDriver();
        GeneralActions actions = new GeneralActions(driver);

        // login
        actions.login("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");

        // create category
        actions.createCategory("Kids");

        // check that new category appears in Categories table
        actions.checkCategoryIfExist("Kids");

        driver.quit();
    }
}
