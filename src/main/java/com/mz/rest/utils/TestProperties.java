package com.mz.rest.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class TestProperties {
    private final static Properties testDataProps;
    private final static String testDataPropsPath = "src/test/resources/testdata.properties";

    static {
        testDataProps = new Properties();
        try (InputStream in = new FileInputStream(testDataPropsPath)) {
            testDataProps.load(in);
        } catch (IOException e) {
            System.out.println("Can not load properties file");
            e.printStackTrace();
        }
    }

    public static Properties getTestDataProps() {
        return testDataProps;
    }
}
