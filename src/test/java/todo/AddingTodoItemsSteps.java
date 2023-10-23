package todo;

import actions.AddItemsActions;
import actions.DisplayedItemsList;
import actions.NavigateActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class AddingTodoItemsSteps {

    @Steps
    NavigateActions navigate;

    @Steps
    AddItemsActions addItem;

    DisplayedItemsList displayedItemsList;

    @Given("Todd has an empty list")
    public void todd_has_an_empty_list() {
        navigate.toHomePage();

    }

    @When("he adds {string}")
    public void he_adds(String todoItem) {
        addItem.called(todoItem);
    }

    @Then("he see following item on the do to list")
    public void he_see_following_item_on_the_do_to_list(List<String> todoItems) {

        List<String> displayedTodoList = displayedItemsList.getDisplayedItemList();
        assertThat(displayedTodoList).containsExactlyElementsOf(todoItems);

    }

}
