package actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class AddItemsActions extends UIInteractionSteps {
    @Step("User adds the '{0}' item to the list")
    public void called(String todoItem) {
        $(".new-todo").typeAndEnter(todoItem);
    }
}
