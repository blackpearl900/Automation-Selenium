package com.uiframework.common;

import io.cucumber.java.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Hooks extends Base {


    @Before
    public void before() throws InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver", "src/Resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        PropsFunction();
        driver.get(props.getProperty("baseURL"));
        Thread.sleep(1000);

    }

    @After
    public void after() throws Exception {
        driver.quit();
        Reporter.log("Closing the browser", true);
    }

    @AfterAll
    public static void After_all() throws IOException {
        //EmailFunction();
    }

}