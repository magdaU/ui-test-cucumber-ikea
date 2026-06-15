package com.ikea.uitestcucumberikeadk;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(
        key = Constants.GLUE_PROPERTY_NAME,
        value = "com.ikea.uitestcucumberikeadk"
)
public class RunCucumberTest {

}
