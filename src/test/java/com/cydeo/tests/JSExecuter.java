package com.cydeo.tests;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecuter extends TestBase {
    @Test
    public void scrollingTest() throws InterruptedException {

        driver.get("http://practice.cydeo.com/");

        WebElement cydeoLink = driver.findElement(By.linkText("CYDEO"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3000);

        js.executeScript("arguments[0].scrollIntoView(true);"+"arguments[0];",cydeoLink);
        Thread.sleep(2000);
        cydeoLink.click();
        Thread.sleep(2000);


    }


}
