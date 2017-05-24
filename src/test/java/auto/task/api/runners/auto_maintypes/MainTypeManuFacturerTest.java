package auto.task.api.runners.auto_maintypes;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by syed.musab on 5/24/2017.
 */
//Cucumber With Serenity Runner to Execute Rest ASSURED TEST
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/maintype_manufacturer")
public class MainTypeManuFacturerTest {
}
