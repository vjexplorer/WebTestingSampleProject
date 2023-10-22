package todo;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class AddingTodoItemsSteps {

    WebDriver driver;

    @Before("@webtest")
    public void setUpDriver(){
        driver = new ChromeDriver();
    }

    @After("@webtest")
    public void closeDriver(){
        driver.quit();
    }


    @Given("Todd has an empty list")
    public void todd_has_an_empty_list() {
        driver.get("https://todomvc.com/examples/angularjs/#/");

    }
    @When("he adds {string}")
    public void he_adds(String todoItem) {
        driver.findElement(By.cssSelector(".new-todo")).sendKeys(todoItem);
        driver.findElement(By.cssSelector(".new-todo")).sendKeys(Keys.ENTER);
    }
    @Then("he see following item on the do to list")
    public void he_see_following_item_on_the_do_to_list(List<String> todoItems) {
        List<String> displayedTodoList = driver.findElements(By.cssSelector(".todo-list label"))
                .stream().map(WebElement::getText).toList();
        assertThat(displayedTodoList).containsExactlyElementsOf(todoItems);

    }

}
