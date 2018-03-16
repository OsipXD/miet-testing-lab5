import cucumber.api.*;
import cucumber.api.junit.*;
import org.junit.runner.*;

@RunWith(Cucumber::class)
@CucumberOptions(glue = ["steps"])
class SeleniumTest