package auto.task.api.runners.auto_built_dates.steps;

import auto.task.api.runners.auto_built_dates.steps.serenity.AutoBuiltDatesSteps;
import auto.task.api.runners.auto_maintypes.steps.MainTypesManufacturerStepDefinition;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by syed.musab on 5/24/2017.
 */

public class AutoBuiltDatesStepDefinition {

    private static final Logger logger = LoggerFactory.getLogger(MainTypesManufacturerStepDefinition.class);
    private static final int SUCCESS_200 = 200;

    // Steps Class of Serenity To get methods
    @Steps
    AutoBuiltDatesSteps autoBuiltDatesSteps;

    // Values to define paramters for rest call
    String autoEndpointBuiltDate;
    Response responseAuto;
    String locale;
    String wa_key;
    String manufacturer;
    String wkda;
    String builtDate;
    String mainType;

    @Given("^get endpoint of built-dates manufacturer$")
    public void get_endpoint_of_built_dates_manufacturer() {

        // Extracting values from step definition file
        locale = autoBuiltDatesSteps.getLocaleParameterForAutoRequest();
        wa_key = autoBuiltDatesSteps.getWaKeyParameterForAutoRequest();
        manufacturer = autoBuiltDatesSteps.getManufacturerParameterForAutoRequest();
        builtDate = autoBuiltDatesSteps.getMainTypeParameterForAutoRequest();
        mainType = autoBuiltDatesSteps.getMainTypeParameterForAutoRequest();

        // Called endpoint with each rest service
        autoEndpointBuiltDate = autoBuiltDatesSteps.getEndPointUrlForMainTypeManufacturerRequest();
        logger.info("auto endpoint" + autoEndpointBuiltDate);

        // assert not null verification
        assertNotNull(autoEndpointBuiltDate);


    }

    @When("^a request is sent to autoOne with wa_key and locale and manufacturer and main types$")
    public void a_request_is_sent_to_autoOne_with_wa_key_and_locale_and_manufacturer_and_main_types() {

        // Variable that contain base url with required parameters
        String urlBuiltDate = autoEndpointBuiltDate.concat("?locale=" + locale + "&wa_key=" + wa_key + "&manufacturer=" + manufacturer
                + "&main-type=" + mainType);

        logger.info("url main type api exposed with parameters" + urlBuiltDate);

        responseAuto = autoBuiltDatesSteps.getBuiltDateManufacturer(urlBuiltDate);
        logger.info("response here" + responseAuto.asString());

        // assert not null verification
        assertNotNull(urlBuiltDate);

    }

    @Then("^api returns car built dates details when valid parameters were passed$")
    public void api_returns_car_built_dates_details_when_valid_parameters_were_passed() {

        //Expected and path result
        String expectedValue = "2007";
        String jsonPathValue = wkda = responseAuto.path("wkda.2007");

        //Assert equal for data verification
        assertEquals(SUCCESS_200, responseAuto.getStatusCode());
        assertEquals(expectedValue, jsonPathValue);

    }
}
