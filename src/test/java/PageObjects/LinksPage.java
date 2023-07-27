package PageObjects;
import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;

public class LinksPage extends BaseClass {

    public LinksPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;


    public void clickButton() throws InterruptedException {
        // Se llega a la pagina principal de los links
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.cssSelector("path")).click();
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.id("item-5")).click();
        driver.findElement(By.id("simpleLink")).click();


    }

    public void moveWindows() throws InterruptedException {

        // Se hace toda la logica de cambio de ventanas y mantener el foco
        String parentWindowHandler = driver.getWindowHandle(); // Se almacena la ventana actual
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles(); // Se obtienen todas las ventana abiertas
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler); // Se cambia a la ultima ventana

        js.executeScript("window.scrollBy(0,600)", "");
        Thread.sleep(6000);

        WaitUntilElementVisible(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Interactions'])[1]/following::div[2]")));

        driver.switchTo().window(parentWindowHandler);
        driver.findElement(By.id("dynamicLink")).click();

        Iterator<String> iterator2 = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator2.next();
        }
        driver.switchTo().window(subWindowHandler); // Se cambia a ventana principal

        js.executeScript("window.scrollBy(0,600)", "");

        WaitUntilElementVisible(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Interactions'])[1]/following::div[2]")));

        driver.switchTo().window(parentWindowHandler);

    }

    public void validateLink() throws InterruptedException {

        // Logica de obtener valores para ordenar alfabeticamente y luego dar click

        List nombres = new LinkedList<>();
        String a =driver.findElement(By.id("linkWrapper")).getText();
        nombres.add (a);
        String b =driver.findElement(By.id("no-content")).getText();
        nombres.add (b);
        String c = driver.findElement(By.id("moved")).getText();
        nombres.add (c);
        String d = driver.findElement(By.id("bad-request")).getText();
        nombres.add (d);
        String e =  driver.findElement(By.id("unauthorized")).getText();
        nombres.add (e);
        String f =driver.findElement(By.id("forbidden")).getText();
        nombres.add (f);
        String g = driver.findElement(By.id("invalid-url")).getText();
        nombres.add (g);

        Collections.sort(nombres); // Se ordena la lista poralfabeto
        String first = nombres.get(0).toString(); // Se obtiene el primer valor
        first.replaceAll("(\n|\r)", ""); // Se limpian los espacios

        driver.findElement(By.tagName(first)).click();

    }
}
