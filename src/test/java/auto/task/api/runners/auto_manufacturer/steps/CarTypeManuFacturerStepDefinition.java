package auto.task.api.runners.auto_manufacturer.steps;

import auto.task.api.runners.auto_manufacturer.steps.serenity.CarTypeManuFacturerSteps;
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
 * Created by syed.musab on 5/23/2017.
 */
public class CarTypeManuFacturerStepDefinition {

    private static final Logger logger = LoggerFactory.getLogger(CarTypeManuFacturerStepDefinition.class);
    private static final int SUCCESS_200 = 200;

    // Steps Class of Serenity To get methods
    @Steps
    CarTypeManuFacturerSteps carTypeManuFacturerSteps;

    // Values to define paramters for rest call
    String autoEndpoint;
    Response responseAuto;
    String locale;
    String wa_key;
    String wkda;


    @Given("^get endpoint of car-types manufacturer$")
    public void get_endpoint_of_car_types_manufacturer() {

        // Extracting values from step definition file
        locale = carTypeManuFacturerSteps.getLocaleParameterForAutoRequest();
        wa_key = carTypeManuFacturerSteps.getWaKeyParameterForAutoRequest();

        // Called endpoint with each rest service
        autoEndpoint = carTypeManuFacturerSteps.getEndPointUrlForCarTypeManufacturerRequest();
        logger.info("auto endpoint" + autoEndpoint);

        // assert not null verification
        assertNotNull(autoEndpoint);
    }

    @When("^a request is sent to autoOne with wa_key and locale$")
    public void a_request_is_sent_to_autoOne_with_wa_key_and_locale() {

        // Variable that contain base url with required parameters
        String url = autoEndpoint.concat("?locale=" + locale + "&wa_key=" + wa_key);
        logger.info("api exposed with parameters" + url);

        responseAuto = carTypeManuFacturerSteps.getCarTypeManufacturer(url);
        logger.info("response here" + responseAuto.asString());
        // assert not null verification
        assertNotNull(url);

    }

    @Then("^autoOne api returns wkda response when valid parameters were passed$")
    public void autoone_api_returns_wkda_response_when_valid_parameters_were_passed() {

        //Expected and path result
        String expectedValue = "Bentley";
        String jsonPathValue = wkda = responseAuto.path("wkda.107");

        logger.info("maintype api value " + expectedValue + "maintype api result " + jsonPathValue);

        //Assert equal for data verification
        assertEquals(SUCCESS_200, responseAuto.getStatusCode());
        assertEquals(expectedValue, jsonPathValue);

    }
}
