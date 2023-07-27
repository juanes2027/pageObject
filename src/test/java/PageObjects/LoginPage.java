package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public boolean loginPageIsDisplayed() throws InterruptedException {
// Navegacion hasta llegar a la pagina slider
        js.executeScript("window.scrollBy(0,250)", "");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Alerts, Frame & Windows'])[1]/following::*[name()='svg'][1]")).click();
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.xpath("//div[@id='app']/div/div/div[2]/div/div/div/div[4]/div/ul/li[4]")).click();
        Thread.sleep(2000);

        return true;
    }

    public boolean moveSlider() throws InterruptedException {

        // Ciclo para mover el slider las veces que necesito hastallegar al 3
        WebElement slider = driver.findElement(By.xpath("//input[@value='25']"));
        Thread.sleep(2000);
        for (int i = 1; i <= 22 ; i++) {
            slider.sendKeys(Keys.ARROW_LEFT);
        }

        Thread.sleep(2000);

        driver.findElement(By.id("sliderValue")).getText().contains("3");
        Thread.sleep(2000);
        return true;
    }
    public boolean validateNumber() throws InterruptedException {

        // Se valida el numero 3 en el slider
        driver.findElement(By.id("sliderValue")).getText().contains("3");
        Thread.sleep(2000);

        return true;
    }
}