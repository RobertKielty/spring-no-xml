package com.test.cukes;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(features = "classpath:com/test/cukes/steps/", format = {"pretty", "html:target/cucumber"})
public class CucumberIT {
}
