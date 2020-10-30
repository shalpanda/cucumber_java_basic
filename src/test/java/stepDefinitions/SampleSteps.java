package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.lang.model.element.Name;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class SampleSteps {
    private WebDriver driver;
//    private Object Name;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

//    @When("^I enter name: \"([^\"]*)\"$")
//    public void iEnterName(String name) throws Throwable {
//        driver.findElement(By.id("name")).clear();
//        driver.findElement(By.id("name")).sendKeys(name);
//    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @Given("^I am on Enter a number page$")
    public void iAmOnEnteraNumberPage() {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter number: \"([^\"]*)\"$")
    public void iEnterNumber(String number) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(number));
    }

    @And("^I click Submit$")
    public void iClickSubmit() throws Throwable {
        driver.findElement(By.className("w3-btn")).click();}

    @Then("^I see Error: \"([^\"]*)\"$")
    public void iSeeError(String error) throws Throwable {
        assertEquals(error, driver.findElement(By.id("ch1_error")).getText());
    }

    @Then("^I see result: \"([^\"]*)\"$")
    public void iSeeResult(String Result) throws Throwable {
        Alert alert = driver.switchTo().alert() ;
        assertEquals(Result, alert.getText());
        alert.accept();
    }

    @Given("^I am on List of People page$")
    public void iAmOnListOfPeoplepage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people.html");
    }

    @When("^I click on Add Person$")
    public void iClickOnAddPerson() throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();

    }

    @And("^I enter Name: \"([^\"]*)\"$")
    public void iEnterName(String Name) throws Throwable {
        driver.findElement(By.id("name")).sendKeys(Name);
    }

    @And("^I enter Surname: \"([^\"]*)\"$")
    public void iEnterSurname(String Surname) throws Throwable {
        driver.findElement(By.id("surname")).sendKeys(Surname);
    }


    @And("^I enter Job: \"([^\"]*)\"$")
    public void iEnterJob(String Job) throws Throwable {
        driver.findElement(By.id("job")).sendKeys(Job);
    }


    @And("^I enter DoB: \"([^\"]*)\"$")
    public void iEnterDoB(String DoB) throws Throwable {
        driver.findElement(By.id("dob")).sendKeys(DoB);

    }

    @And("^I select Language: \"([^\"]*)\"$")
    public void iEnterLanguage(String Language) throws Throwable {
        WebElement English = driver.findElement(By.id("english"));
        assertTrue(English.isSelected());

    }


    @And("^I select Gender: \"([^\"]*)\"$")
    public void iSelectGender(String Gender) throws Throwable {
//        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));

//        for (WebElement radioButton : radioButtons) {
//            assertFalse(radioButton.isSelected()); // radio are NOT selected
//            radioButton.click();
//            assertTrue(radioButton.isSelected()); // radio are selected
//        }

        WebElement male = driver.findElement(By.id("male"));
        assertFalse(male.isSelected());
        male.click();
        assertTrue(male.isSelected());
    }
}

