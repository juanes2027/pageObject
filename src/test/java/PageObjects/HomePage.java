package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class HomePage extends BaseClass {

    public HomePage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;
    public boolean homePageIsDisplayed()
    {

        // Se da click y se llega a la pagina principal del formulario
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Elements'])[1]/following::*[name()='svg'][1]")).click();
        driver.findElement(By.xpath("//div[2]/div/ul/li/span")).click();

        return true;
    }

    public boolean submitInfo() {

        // Se agregan todos los parametros al formulario
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("Juan");
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("Osorio");
        driver.findElement(By.id("userEmail")).click();
        driver.findElement(By.id("userEmail")).clear();
        driver.findElement(By.id("userEmail")).sendKeys("ks@g.com");
        driver.findElement(By.xpath("//div[@id='genterWrapper']/div[2]/div/label")).click();
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.id("userNumber")).click();
        driver.findElement(By.id("userNumber")).clear();
        driver.findElement(By.id("userNumber")).sendKeys("3247658939");
        driver.findElement(By.id("dateOfBirthInput")).click();
        driver.findElement(By.xpath("//div[2]/select")).click();
        new Select(driver.findElement(By.xpath("//div[2]/select"))).selectByVisibleText("2005");
        driver.findElement(By.xpath("//select")).click();
        new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText("February");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Hobbies'])[1]/preceding::div[49]")).click();
        driver.findElement(By.xpath("//div[6]/div[2]/div/div/div")).click();

        return true;
    }
    public boolean validateInfo() {
    //  Sehace la validacion del correcto envio comparando con el texto respuesta
        driver.findElement(By.id("userForm")).submit();
        driver.findElement(By.id("example-modal-sizes-title-lg")).getText().contains("Thanks for submitting the form");

        return true;

    }


}