package stepDefinitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

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

        WebElement radioBtn1 = driver.findElement(By.cssSelector("#male"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", radioBtn1);

    }

    @And("^I select Status: \"([^\"]*)\"$")
    public void iSelectStatus(String Status) throws Throwable {
        Select dropdown = new Select(driver.findElement(By.id("status")));
        dropdown.selectByVisibleText(Status);

    }

    @And("^I click Add$")
    public void iClickAdd() {
        driver.findElement(By.id("modal_button")).click();
    }

    @Then("^A new person is added\\.$")
    public void aNewPersonIsAdded() {
       assertEquals("Hazem",driver.findElement(By.xpath("//*[@id=\"person3\"]/div/span[1]")).getText());

    }

    @And("^I click pencil$")
    public void iClickPencil()  {
        driver.findElement(By.xpath(" //*[@id=\"person3\"]/span[2]/i")).click();
    }

    @And("^I change Status: \"([^\"]*)\"$")
    public void iChangeStatus(String Status) throws Throwable {
        Select dropdown = new Select(driver.findElement(By.id("status")));
        dropdown.selectByVisibleText(Status);
    }


    @And("^I click Edit$")
    public void iClickEdit() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/button[1]]")).click();
    }

    @Then("^Status is changed from Intern to Employee\\.$")
    public void statusIsChangedFromInternToEmployee() {
        assertEquals("employee",driver.findElement(By.xpath("//*[@id=\"person3\"]/span[7]]")).getText());
    }


    @And("^I click Remove$")
    public void iClickRemove() {
        driver.findElement(By.xpath("//*[@id=\"person3\"]/span[1]")).click();
    }


    @Then("^Person is removed\\.$")
    public void personIsRemoved() {
        assertFalse(driver.findElements(By.id("person3")).size() > 0);
    }

    @And("^I click Reset$")
    public void iClickReset() {
        driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"]")).click();
    }


    @And("^I click Clear$")
    public void iClickClear() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div/button")).click();

    }

    @And("^I check Name$")
    public void iCheckName() {
        assertFalse(driver.findElements(By.id("name")).size() > 0);
    }


    @And("^I check Surname$")
    public void iCheckSurname() throws InterruptedException{
        assertFalse(driver.findElements(By.id("surname")).size() > 0);
        Thread.sleep(10000);
    }

    @Then("^All Fields are cleared\\.$")
    public void allFieldsAreCleared() {
        assertEquals("",driver.findElement(By.id("name")).getText());
        assertEquals("",driver.findElement(By.id("surname")).getText());
    }
}



