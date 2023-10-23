package user_directory;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.DirectoryUser;
import net.serenitybdd.rest.SerenityRest;
import org.assertj.core.api.SoftAssertions;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;


public class UserDirectorySteps {

    @Given("Dirk is a Directory Administrator")
    public void dirk_is_a_directory_administrator() {

    }
    @When("he asks for the available users using the default configuration")
    public void he_asks_for_the_available_users_using_the_default_configuration() {
        SerenityRest.get("https://reqres.in/api/users")
                .then()
                .statusCode(200);
    }
    @Then("he should be presented with following results:")
    public void he_should_be_presented_with_following_results(Map<String,Integer> resultsSummary) {
        SoftAssertions.assertSoftly(softly->{
        for(String field:resultsSummary.keySet()){
            int expected =resultsSummary.get(field);
            int actual = SerenityRest.lastResponse().jsonPath().getInt(field);
            softly.assertThat(actual).isEqualTo(expected);
        }});
    }

    @DataTableType
    public DirectoryUser directoryUser(Map<String, String> fields){
        return new DirectoryUser(
                Integer.parseInt(fields.get("id")),
                fields.get("email"),
                fields.get("first_name"),
                fields.get("last_name"),
                fields.get("avatar")
        );
    }
    @Then("the matching users should include the following:")
    public void the_matching_users_should_include_the_following(List<DirectoryUser> expectedUsers) {
        List<DirectoryUser> actualUsers = SerenityRest.lastResponse().jsonPath().getList("data",DirectoryUser.class);
        assertThat(actualUsers).containsAll(expectedUsers);

    }
}
