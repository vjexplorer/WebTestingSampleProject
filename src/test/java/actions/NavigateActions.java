package actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class NavigateActions extends UIInteractionSteps {
    @Step("Open the todo list application")
    public void toHomePage() {
        this.openUrl("https://todomvc.com/examples/angularjs/#/");
    }
}
