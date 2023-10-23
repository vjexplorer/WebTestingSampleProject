package actions;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DisplayedItemsList extends PageComponent {

    public List<String> getDisplayedItemList(){
        return $$(".todo-list label").texts();

    }

}
