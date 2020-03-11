package WebTest;

import org.junit.runner.RunWith;



        import io.cucumber.junit.Cucumber;


        import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = ".",tags = "@login", plugin={"pretty", "html:target/Destination"},strict = true)

public class RunTest {
}
