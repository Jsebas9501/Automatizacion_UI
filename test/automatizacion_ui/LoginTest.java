/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatizacion_ui;

import PageObjects.AddEmployee;
import PageObjects.EditEmployee;
import PageObjects.Home;
import PageObjects.Login;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
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
    Home home;
    AddEmployee addEmployee;
    EditEmployee editEmployee;
    Random rand = new Random();
    Calendar date;

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
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
        home = new Home(driver);
        addEmployee = new AddEmployee(driver);
        editEmployee = new EditEmployee(driver);

    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    //Metodo para esperar un tiempo entre clicks
    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
        }
    }

    /**
     * Test of main method, of class SeleniumPractice.
     */
    @Test
    public void LoginPass() {
        //Hacer Inicio de sesión
        String Username = "Admin";
        String Password = "admin123";
        login.FuctionLogin(Username, Password);

        //Ingresar a AddEmployed
        home.clicPIM();
        sleep(1000);
        home.clicAddEmployee();

        //Ingresar un empleado
        int firsNameInt = (int) (Math.random() * 999999) + 100000;//Aleatorio para FirstName
        String firsName = String.valueOf(firsNameInt);
        int lastNameInt = (int) (Math.random() * 999999) + 100000;//Aleatorio para LastName
        String lastName = String.valueOf(lastNameInt);
        addEmployee.FuctionAddEmployee(firsName, lastName);

        //Ingresar a Editar
        String gender = "1";
        String national = "34";
        String nickName = firsName + "_" + lastName;
        String marital = "Single";

        //Generar Fecha Aleatoria
        int yyyy = (int) rand.nextInt((2120 - 1920) + 1) + 1920; //Aleatorio Año
        int mm = (int) rand.nextInt((12 - 1) + 1) + 1; //Aleatorio Mes
        int dd = (int) rand.nextInt((31 - 1) + 1) + 1; //Aleatorio Mes

        date = Calendar.getInstance(); //Instancia de la clase Calendar 
        date.set(yyyy, mm, dd);         //Se guardan los valores aleatorios
        SimpleDateFormat amd = new SimpleDateFormat("yyyy-mm-dd"); //Formato de fecha
        String date1 = amd.format(date.getTime()); //Cambiamos la fecha a String  
        editEmployee.FuctionEditEmployee(gender, national, nickName, marital, date1);
        sleep(1000);
        editEmployee.clicEmployeeList();

        //Ingresar a Lista de empleados
        String id = "0250";
        home.FuctionSearch(id);

    }

}
