package myprojects.automation.assignment3.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebDriverLogger implements WebDriverEventListener {
    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Before navigating to: '" + s + "'");
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Navigated to:'" + s + "'");
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        System.out.println("Navigated back to previous page");
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        System.out.println("Navigating back to previous page");
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        System.out.println("Navigated forward to next page");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        System.out.println("Navigating forward to next page");
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Trying to find Element By : " + by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Found Element By : " + by.toString());
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Trying to click on: " + webElement.toString());
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Clicked on: " + webElement.toString());
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Value of the:" + webElement.toString() + " before any changes made");
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Element value changed to: " + webElement.toString());
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {

    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        System.out.println("Exception occured: " + throwable);
    }
}
