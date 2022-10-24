package com.omsdev.testCases;

import com.omsdev.utilities.ReadConfig;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.poifs.property.DirectoryProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.logging.Logger;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();
    public String baseUrl= readConfig.getApplicationURL();
    public String username= readConfig.getUsername();
    public String password= readConfig.getPassword();
    public static WebDriver driver;

    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setup(String br)
    {
        logger=Logger.getLogger("OmsDev_V3");
        PropertyConfigurator.configure("log4j.properties");

        if(br.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
            driver = new ChromeDriver();
        }
        else if(br.equals("egde"))
        {
            System.setProperty("webdriver.edge.driver", readConfig.getEdgePath());
            driver = new EdgeDriver();
        }

        driver.get(baseUrl);
    }

    @AfterClass
    public void teardown()
    {
        driver.quit();
    }

}
