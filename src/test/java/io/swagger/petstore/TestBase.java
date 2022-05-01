package io.swagger.petstore;

import io.swagger.petstore.util.LoggerUtil;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;

public class TestBase {

    protected SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void initMethod(Method method) {
        LoggerUtil.logINFO("Running test - " + method.getName());
        this.softAssert = new SoftAssert();
    }
}
