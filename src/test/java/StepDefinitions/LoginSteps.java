package StepDefinitions;

import PageObjects.HomePage;
import PageObjects.LinksPage;
import PageObjects.LoginPage;
import Utilities.PropertiesReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;

    public LoginSteps() throws Exception {

        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }


    @Given("Login form in login page")
    public void loginPage() throws InterruptedException {

        HomePage home = new HomePage(driver, wait);
        home.homePageIsDisplayed();
    }

    @When("Submit information")
    public void submitInfo() throws InterruptedException {
        HomePage home = new HomePage(driver, wait);
        home.submitInfo();

    }

    @Then("Success validate")
    public void ValidtetInfo() throws InterruptedException {
        HomePage home = new HomePage(driver, wait);
        home.validateInfo();

    }

    @Given("Home page")
    public void slider() throws InterruptedException {

        LoginPage login = new LoginPage(driver, wait);
        login.loginPageIsDisplayed();

    }

    @When("Move the slider")
    public void moveSlider() throws InterruptedException {
        LoginPage login = new LoginPage(driver, wait);
        login.moveSlider();

    }

    @Then("Validate number")
    public void validateNumber() throws InterruptedException {
        LoginPage login = new LoginPage(driver, wait);
        login.validateNumber();

    }


    @Given("Link page")
    public void linkPage() throws InterruptedException {

        LinksPage link = new LinksPage(driver, wait);
        link.clickButton();
    }

    @When("Move in windows")
    public void moveWindows() throws InterruptedException {

        LinksPage link = new LinksPage(driver, wait);
        link.moveWindows();
    }

    @Then("Validate link")
    public void validateLink() throws InterruptedException {

        LinksPage link = new LinksPage(driver, wait);
        link.validateLink();
    }


    @When("Submit email using \"(.*)\" and password using \"(.*)\"")
    public void submitEmailPassword(String email, String password) throws InterruptedException {

        LoginPage login = new LoginPage(driver, wait);
        HomePage home = new HomePage(driver, wait);
       // login.loginPageIsDisplayed();
        //home.homePageIsDisplayed2();
      //  login.fillEmailData(email);
       // login.fillPasswordData(password);
      //  login.clickSignInButton();
    }
}