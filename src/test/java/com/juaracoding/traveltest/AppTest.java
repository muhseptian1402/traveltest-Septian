package com.juaracoding.traveltest;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AppTest     {
    private WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/register.php");
    }

    @Test
    public void registerUserTest()  {
        WebElement firstnameField = driver.findElement(By.name("firstName"));
        WebElement lastnameField = driver.findElement(By.name("lastName"));
        WebElement phoneField = driver.findElement(By.name("phone"));
        WebElement emailField = driver.findElement(By.name("userName"));
        WebElement addressField = driver.findElement(By.name("address1"));
        WebElement cityField = driver.findElement(By.name("city"));
        WebElement stateField = driver.findElement(By.name("state"));
        WebElement postalCodeField = driver.findElement(By.name("postalCode"));
        WebElement countryField = driver.findElement(By.name("country"));
        WebElement usernameField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement confirmPassField = driver.findElement(By.name("confirmPassword"));
        WebElement button = driver.findElement(By.name("submit"));
        
        firstnameField.sendKeys("Septian");
        
        lastnameField.sendKeys("Firmansyah");
        phoneField.sendKeys("08123123456");
        emailField.sendKeys("septian.123@gmail.com");
        addressField.sendKeys("Jl.Sesama No.123");
        cityField.sendKeys("Konoha");
        stateField.sendKeys("East Konoha");
        postalCodeField.sendKeys("123442");
        
        Select select = new Select(countryField);
        
        // Kalau ingin melakukan pengujian secara random country di setiap pengujiannya
        List<WebElement> options = select.getOptions();
        
        Random rand = new Random();
        int randomIndex = rand.nextInt(options.size());
    
        select.selectByIndex(randomIndex);
    
        WebElement selectedOption = select.getFirstSelectedOption();
    
        Assert.assertEquals(selectedOption.getText(), options.get(randomIndex).getText()); 

        // melakukan pengetesan pada user informatin
        usernameField.sendKeys("Septian123");
        passwordField.sendKeys("Septian123_");
        confirmPassField.sendKeys("Septian123_");
    
        button.click();
    
        String actual = driver.getCurrentUrl();
        String expected = "https://demo.guru99.com/test/newtours/register_sucess.php";
    
        Assert.assertEquals(actual, expected);
        
        
    }
    


    @AfterClass   
    public void teardown() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();
    }
    
}
