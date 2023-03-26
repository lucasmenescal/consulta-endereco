package com.consultaendereco;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.consultaendereco",
        plugin = {"pretty", "html:target/cucumber"})
@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
public class CucumberIntegrationTest {
}
