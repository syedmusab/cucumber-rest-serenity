package auto.task.api.runners.auto_maintypes.steps;

import auto.task.api.runners.auto_maintypes.steps.serenity.MainTypesManufacturerSteps;
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
public class MainTypesManufacturerStepDefinition {
    private static final Logger logger = LoggerFactory.getLogger(MainTypesManufacturerStepDefinition.class);
    private static final int SUCCESS_200 = 200;

    // Steps Class of Serenity To get methods
    @Steps
    MainTypesManufacturerSteps mainTypesManufacturerSteps;

    // Values to define paramters for rest call
    String autoEndpointMainType;
    Response responseAuto;
    String locale;
    String wa_key;
    String manufacturer;
    String wkda;

    @Given("^get endpoint of main-types manufacturer$")
    public void get_endpoint_of_main_types_manufacturer() {

        // Extracting values from step definition file
        locale = mainTypesManufacturerSteps.getLocaleParameterForAutoRequest();
        wa_key = mainTypesManufacturerSteps.getWaKeyParameterForAutoRequest();
        manufacturer = mainTypesManufacturerSteps.getManufacturerParameterForAutoRequest();

        // Called endpoint with each rest service
        autoEndpointMainType = mainTypesManufacturerSteps.getEndPointUrlForMainTypeManufacturerRequest();
        logger.info("auto endpoint" + autoEndpointMainType);

        // assert not null verification
        assertNotNull(autoEndpointMainType);

    }

    @When("^a request is sent to autoOne with wa_key and locale and manufacturer$")
    public void a_request_is_sent_to_autoOne_with_wa_key_and_locale_and_manufacturer() {

        // Variable that contain base url with required parameters
        String urlMainType = autoEndpointMainType.concat("?locale=" + locale + "&wa_key=" + wa_key + "&manufacturer=" + manufacturer);
        logger.info("urlMainType api exposed with parameters" + urlMainType);

        responseAuto = mainTypesManufacturerSteps.getMainTypeManufacturer(urlMainType);
        logger.info("response here" + responseAuto.asString());

        // assert not null verification
        assertNotNull(urlMainType);
    }

    @Then("^autoOne api returns car manufacturer details when valid parameters were passed$")
    public void autoone_api_returns_car_manufacturer_details_when_valid_parameters_were_passed() {

        //Expected and path result
        String expectedValue = "Arnage";
        String jsonPathValue = wkda = responseAuto.path("wkda.Arnage");

        //Assert equal for data verification
        assertEquals(SUCCESS_200, responseAuto.getStatusCode());
        assertEquals(jsonPathValue, expectedValue);

    }

}
