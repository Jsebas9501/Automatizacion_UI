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
        //String Username = "Admin";
        //String Password = "admin123";
        
        String Username = "politecnicojic";
        String Password = "Asdf1234";
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
        
        //Ingresar Gender
        int optGender = rand.nextInt(2) + 1;
        if(optGender == 1) {
            editEmployee.clickMale();      
        } else {
            editEmployee.clickFemale();
        }
        
        int nation = rand.nextInt(193)+ 1; //Número aleatorio para Nationality
        String nickName = firsName + "_" + lastName;
        int marital = rand.nextInt(3)+ 1; //Número aleatorio para Marital
        
        //Generar Fecha Aleatoria
        int yyyy = rand.nextInt((2120 - 1920) + 1) + 1920; //Aleatorio Año
        int mm = rand.nextInt(12) + 1; //Aleatorio Mes
        int dd = rand.nextInt(31) + 1; //Aleatorio Dia

        date = Calendar.getInstance(); //Instancia de la clase Calendar 
        date.set(yyyy, mm, dd);         //Se guardan los valores aleatorios
        SimpleDateFormat amd = new SimpleDateFormat("yyyy-mm-dd"); //Formato de fecha
        String date1 = amd.format(date.getTime()); //Cambiamos la fecha a String  
        editEmployee.FuctionEditEmployee(nation, nickName, marital, date1);
        sleep(1000);
        editEmployee.clicEmployeeList();

        //Ingresar a Lista de empleados
        //String name = firsName + "_" + lastName;
        String id = "0250";
        home.FuctionSearch(id);

    }

}
