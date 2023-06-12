package com.trendyol.ui.Utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.lang.Math.abs;

    public class ReusableMethods {
        private static WebDriver driver;

        WebDriverWait wait;
        public void hover(By locator) {
            WebElement element = driver.findElement(locator);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
        }

        public static void click(By locator){
            WebElement element = driver.findElement(locator);
            waitUntilElementIsClickable(locator,5);
            element.click();
        }

        public void sendKeys(By locator, String value){

            WebElement element = driver.findElement(locator);
            waitUntilElementIsVisible(locator,10);
            element.sendKeys(value);
        }

        public ReusableMethods(WebDriverWait wait) {

            this.wait = wait;
        }

        public ReusableMethods(WebDriver driver) {

            this.driver = driver;
        }

        public void rightClick(WebElement element){

            Actions action = new Actions(driver);
            action.contextClick(element).perform();
        }

        public void doubleClick(By locator){
            WebElement element = driver.findElement(locator);
            Actions action = new Actions(driver);
            action.doubleClick(element).perform();
        }

        public static void screenShot(String ssName) throws IOException {
            // Take a ScreenShot
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File destinationFile = new File(System.getProperty("user.dir") + "/ScreenShots/"+ssName+".png");

            try {
                FileUtils.copyFile(screenshotFile, destinationFile);
                System.out.println("Screenshot has been saved: " + destinationFile.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("There was an error while saving the screenshot: " + e.getMessage());
            }
        }

        public static void setDriver(WebDriver driver) {
            ReusableMethods.driver = driver;
        }

        public static WebDriver getDriver() {
            return driver;
        }


        public ReusableMethods waitFor(int sec) {

            try {
                Thread.sleep(sec * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return this;
        }

        public void scrollDown(int pixels) {

            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0, " + abs(pixels) + ");", "");
        }

        public void scrollIntoView(By locator) {
            WebElement element = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        }



        public void getPageUrl() {
            System.out.println(driver.getCurrentUrl());
        }

        public String getPageTitle() {
            String element = driver.getTitle();
            return element;
        }

        public void navigateRefresh(){driver.navigate().refresh(); }

        public void navigateBack(){driver.navigate().back(); }

        public void navigateForward(){driver.navigate().forward(); }

        public void deleteCookies(){driver.manage().deleteAllCookies(); }

        public void findAllCookies(){

            Set <Cookie> cookies = driver.manage().getCookies();
            for(Cookie cookie:cookies){
                System.out.println(cookie.getName()+":"+cookie.getValue());
            }
            System.out.println("Total cookies:"+cookies.size());
        }

        public void switchToTab(){

            Set<String> tabs = driver.getWindowHandles(); //Used to switch to a new tab that opens
            for(String actual: tabs) {
                driver.switchTo().window(actual);
            }
        }

        public ReusableMethods switchToWindow(String targetTitle) {

            String origin = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
                if (driver.getTitle().equals(targetTitle)) {
                    return this;
                }
            }
            driver.switchTo().window(origin);
            return null;
        }

        public void dropDownSelectByValue(WebElement element,String value){

            Select Value = new Select(element);
            Value.selectByValue(value);
        }

        public void dropDownSelectByIndex(WebElement element,int value){

            Select index = new Select(element);
            index.selectByIndex(value);
        }

        public void dropDownSelectByText(WebElement element,String value){

            Select VisibleText = new Select (element);
            VisibleText.selectByVisibleText(value);
        }

        public void getElementSize(WebElement element){

            System.out.println(element.getSize());
        }

        public void getElementLocation(WebElement element){

            System.out.println(element.getLocation());
        }

        public boolean waitUntilElementIsVisible(By locator, int time){
            WebElement element = driver.findElement(locator);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.visibilityOf(element));
            return false;
        }


        public static void waitUntilElementIsClickable(By element, int time){

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        public static void waitUntilElementIsActive(By element, int time){

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.presenceOfElementLocated(element));
        }

        public void dragToElement(WebElement element, WebElement element2){

            Actions action = new Actions(driver);
            action.dragAndDrop(element,element2).build().perform();
        }

        public void dragThisCoordinate(WebElement element, int x, int y){

            Actions action = new Actions(driver);
            action.dragAndDropBy(element,x,y).perform();
        }

        public ReusableMethods getElementsText(List<WebElement> list){

            List<String> elemTexts = new ArrayList<>();
            for (WebElement el : list) {
                if (!el.getText().isEmpty()) {
                    System.out.println(elemTexts.add(el.getText()));
                }
            }
            return this;
        }

        public void elementContains(WebElement element, String word){

            String x= element.getText();
            Assert.assertTrue(word.contains(x));
        }

        public void findAllLinks(){

            List<WebElement> links = driver.findElements(By.tagName("a"));
            System.out.println("Total link number "+ links.size());
            for(int i=0;i<links.size();i++)
            {
                System.out.println("Link url: "+links.get(i).getAttribute("href"));
                System.out.println("Link name:"+links.get(i).getText());
            }
        }

        public void copyPasteText(By locator1, By locator2){

            WebElement element = driver.findElement(locator1);
            WebElement element2 = driver.findElement(locator2);
            element.sendKeys(Keys.COMMAND + "a");
            element.sendKeys(Keys.COMMAND + "c");
            element2.sendKeys(Keys.COMMAND + "v");
        }

        public boolean isDisplayed(By locator){
            WebElement element = driver.findElement(locator);
            waitUntilElementIsVisible(locator,10);
            return element.isDisplayed();
        }

        public boolean isClickable(By locator){
            WebElement element = driver.findElement(locator);
            return element.isEnabled();
        }


        public String getTextOfElement(By locator) {

            return driver.findElement(locator).getText();

        }
        public void notifDismiss() {
            driver.switchTo().alert().dismiss();
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
        }

    }

