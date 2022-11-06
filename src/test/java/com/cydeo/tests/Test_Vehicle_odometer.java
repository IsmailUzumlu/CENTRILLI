package com.cydeo.tests;

import com.cydeo.base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Vehicle_odometer extends TestBase {


    @Test

    public static  void Test_Odometer () throws InterruptedException {

        WebDriverManager.chromedriver().setup();;
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


//        1. Verify that user can create a Vehicle Odometer
//        2. Verify that user cannot create a Vehicle Odometer without selecting vehicle
//        3. Verify that user can cancel creating by clicking Discard button
//        4. Verify that page title is changed to the new Odometer value after user create the Odometer
//        5. Verify that “Attachment” and Action buttons are displayed at the top of the page (after creating a new Odometer).
//        6. Verify that user can find the new created Odometer value under Odometer list by using search box.
//        7. Verify that user can change Odometer display to Kanban / List / Graph
//        8- Verify that the number of Odometer increased 1


        driver.get("https://centrilli.com/");
        WebElement loginPage = driver.findElement(By.xpath("//a[.='Log in']"));
        loginPage.click();

        WebElement enterUsername = driver.findElement(By.xpath("//input[@type='text']"));
        enterUsername.sendKeys("posmanager10@info.com");


        WebElement enterPassword = driver.findElement(By.xpath("//input[@type='password']"));
        enterPassword.sendKeys("posmanager");

        WebElement loginBtn = driver.findElement(By.xpath("//button[.='Log in']"));
        loginBtn.click();
        Thread.sleep(2000);

        WebElement salesPage = driver.findElement(By.xpath("//span[normalize-space()='Sales']"));
        salesPage.click();

        WebElement productsBtn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[6]/ul[3]/li[1]/a[1]/span[1]"));
        productsBtn.click();
        Thread.sleep(4000);

        WebElement createBtn = driver.findElement(By.xpath("//button[normalize-space()='Create']"));
        createBtn.click();

        Thread.sleep(2000);

        WebElement productNameInput = driver.findElement(By.id("o_field_input_703"));
        Thread.sleep(2000);
        productNameInput.sendKeys("Vehicle Odometer");


        WebElement saveBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm o_form_button_save']"));
        saveBtn.click();
        Thread.sleep(2000);

        String afterSaveTitle = driver.getTitle();
        System.out.println(afterSaveTitle);

        String beforeSaveTitle = "New - Odoo";
        Assert.assertEquals(afterSaveTitle,beforeSaveTitle,"the title changed :");

        WebElement attachmentsBtn = driver.findElement(By.xpath("//button[@class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle']"));
        attachmentsBtn.isDisplayed();

        WebElement actionBtn = driver.findElement(By.xpath("//button[normalize-space()='Action']"));
        actionBtn.isDisplayed();

        driver.close();

        }



    }

