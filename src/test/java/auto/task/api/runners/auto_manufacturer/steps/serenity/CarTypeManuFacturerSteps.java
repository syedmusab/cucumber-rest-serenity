package auto.task.api.runners.auto_manufacturer.steps.serenity;

import com.jayway.restassured.response.Response;
import auto.task.api.utlis.AutoGetPropertyFromPropertiesFile;
import net.thucydides.core.annotations.Step;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.rest.SerenityRest.rest;

/**
 * Created by syed.musab on 5/23/2017.
 */
public class CarTypeManuFacturerSteps {

    private static final Logger logger = LoggerFactory.getLogger(CarTypeManuFacturerSteps.class);
    private static final String AUTO_ACCESS_TOKEN_PROPERTIES_FILE_PATH = "properties/auto_token.properties";
    private AutoGetPropertyFromPropertiesFile AutoAccessParamsProps = new AutoGetPropertyFromPropertiesFile();

    // Step to get Endpoint of REST SERVICE
    @Step
    public String getEndPointUrlForCarTypeManufacturerRequest() {

        String carTypeEndpoints = AutoAccessParamsProps.
                getPropertyValueFromPropertiesFile("auto_base_url_cartype",
                        AUTO_ACCESS_TOKEN_PROPERTIES_FILE_PATH);
        return carTypeEndpoints;
    }

    //Step to get parameter from property file
    @Step
    public String getWaKeyParameterForAutoRequest() {
        String waKey = AutoAccessParamsProps.
                getPropertyValueFromPropertiesFile("auto_wa_key",
                        AUTO_ACCESS_TOKEN_PROPERTIES_FILE_PATH);
        return waKey;
    }

    //Step to get parameter from property file
    @Step
    public String getLocaleParameterForAutoRequest() {
        String locale = AutoAccessParamsProps.
                getPropertyValueFromPropertiesFile("auto_locale",
                        AUTO_ACCESS_TOKEN_PROPERTIES_FILE_PATH);
        return locale;
    }

    // Step to extract response using REST ASSURED
    @Step
    public Response getCarTypeManufacturer(String cartypeEndpoint) {

        DateTime dtBeforeAPIRequest = new DateTime();
        long current =  dtBeforeAPIRequest.getMillis();

        Response responseCarTypeInformation = rest().
                given().
                when().
                get(cartypeEndpoint);

        DateTime dtAfterResponse = new DateTime();
        logger.info("Response Time - Brand Information: "
                + Long.toString(dtAfterResponse.getMillis() - current) + " ms");

        return responseCarTypeInformation;
    }
}
