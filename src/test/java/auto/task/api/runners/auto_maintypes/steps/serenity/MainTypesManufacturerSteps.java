package auto.task.api.runners.auto_maintypes.steps.serenity;

import auto.task.api.runners.auto_manufacturer.steps.serenity.CarTypeManuFacturerSteps;
import auto.task.api.utlis.AutoGetPropertyFromPropertiesFile;
import com.jayway.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.rest.SerenityRest.rest;

/**
 * Created by syed.musab on 5/24/2017.
 */
public class MainTypesManufacturerSteps {

    private static final Logger logger = LoggerFactory.getLogger(CarTypeManuFacturerSteps.class);
    private static final String AUTO_ACCESS_TOKEN_PROPERTIES_FILE_PATH = "properties/auto_token.properties";
    private AutoGetPropertyFromPropertiesFile AutoAccessParamsProps = new AutoGetPropertyFromPropertiesFile();

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

    //Step to get parameter from property file
    @Step
    public String getManufacturerParameterForAutoRequest() {
        String locale = AutoAccessParamsProps.
                getPropertyValueFromPropertiesFile("auto_manufacturer",
                        AUTO_ACCESS_TOKEN_PROPERTIES_FILE_PATH);
        return locale;
    }

    // Step to get Endpoint of REST SERVICE
    @Step
    public String getEndPointUrlForMainTypeManufacturerRequest() {

        String carTypeEndpoints = AutoAccessParamsProps.
                getPropertyValueFromPropertiesFile("auto_base_url_maintype",
                        AUTO_ACCESS_TOKEN_PROPERTIES_FILE_PATH);
        return carTypeEndpoints;
    }

    // Step to extract response using REST ASSURED
    @Step
    public Response getMainTypeManufacturer(String mainTypeEndpoint) {

        DateTime dtBeforeAPIRequest = new DateTime();
        long current =  dtBeforeAPIRequest.getMillis();

        Response responseMainTypeInformation = rest().
                given().
                when().
                get(mainTypeEndpoint);

        DateTime dtAfterResponse = new DateTime();
        logger.info("Response Time - MainType Information: "
                + Long.toString(dtAfterResponse.getMillis() - current) + " ms");

        return responseMainTypeInformation;
    }
}
