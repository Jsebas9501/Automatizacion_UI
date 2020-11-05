/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatizacion_ui;

import PageObjects.Login;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Sebastian
 */
public class LoginTest {
    private static WebDriver driver = null;
    
    Login login;
    
    @BeforeClass
    public static void setUpClass() {                
        System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {        
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");   
        login = new Login(driver);
    }
    
    @After
    public void tearDown() {
        //driver.quit();
    }
    
     /**
     * Test of main method, of class SeleniumPractice.
     */
    @Test
    public void LoginPass() {
         //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
         String Username = "Admin";
         String Login = "admin123";
         login.FuctionLogin(Username, Login);
    }
    
}
