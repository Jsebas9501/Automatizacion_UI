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
import PageObjects.Verification;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Sebastian
 * Taller de Atomatización UI - Ejercicio 03
 */
public class LoginTest {

    private static WebDriver driver = null;

    Login login;
    Home home;
    AddEmployee addEmployee;
    EditEmployee editEmployee;
    Random rand;
    Calendar date;
    Verification verificar;

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
        rand = new Random();
        verificar = new Verification(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
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
    
    /**
     * Caso de prueba: Verificar que se cree un empleado, editarlo y buscarlo.
     * Pasos a ejecutar:
     * 1.Iniciar sesión
     * 2.Ingresar a la pestaña PIM
     * 3.Ingresar a la pestaña AddEmployee
     * 4.Ingresar firstName de modo aleatorio
     * 5.Ingresar lastName de modo aleatorio
     * 6.Captuar el IdEmployee
     * 7.Clic en Save
     * 8.Clic en Edit
     * 9.Ingresar a la pestaña de Editar
     * 10.Seleccionar Gender de modo aleatorio
     * 12.Seleccionar Nationality de modo aleatorio
     * 12.Ingresar nickName de modo aleatorio
     * 13.Seleccionar Marital de modo aleatorio
     * 14.Ingresar Date en modo aleatorio
     * 15.Clic en Save
     * 16.Clic en EmployeeList
     * 17.Ingresar Id capturado
     * 18.Clic en Search
     * 19.Clic Id de la tabla encontrada
     * 
     * Resultado esperado: El sistema debe ingresar con las credenciales dadas,
     * ingresar los datos necesarios para crear el empleado y editar los campos asigandos 
     * Gender, Nationality, Marital, NickName y Date, guardalos, y luego buscar por el Id del Employee.
     * 
     * Tiempo estimado para la ejecucón 30 segundos.
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
        int firsNameInt = rand.nextInt(999999) + 100000;//Aleatorio para FirstName
        String firsName = String.valueOf(firsNameInt);
        int lastNameInt = rand.nextInt(999999) + 100000;;//Aleatorio para LastName
        String lastName = String.valueOf(lastNameInt);
        String id = addEmployee.getEmployeeId();
        addEmployee.FuctionAddEmployee(firsName, lastName);
        
        //Ingresar a Editar
        //Ingresar Gender
        sleep(1000);  
        int optGender = rand.nextInt(2) + 1;
        String genderVer = String.valueOf(optGender);
        int nation = rand.nextInt(193)+ 1; //Número aleatorio para Nationality
        String nationVer = String.valueOf(nation);
        int marital = rand.nextInt(3)+ 1; //Número aleatorio para Marital
        String nickName = firsName + "_" + lastName;
        
        //Generar Fecha Aleatoria
        int yyyy = rand.nextInt((2120 - 1920) + 1) + 1920; //Aleatorio Año
        String stringYYYY = String.valueOf(yyyy);    
        int mm = rand.nextInt(12) + 1; //Aleatorio Mes
        String stringMM = String.valueOf(mm);    
        int dd = rand.nextInt((31 - 1) + 1) + 1; //Aleatorio Dia
        String stringDD = String.valueOf(dd); 
        
        String Date = stringYYYY; //Contruir Date yyyy
        if(stringMM.length() == 1) Date += "-0" + stringMM; //Date yyyy-mm
        else Date += "-" + stringMM;
        if(stringDD.length() == 1) Date += "-0" + stringDD;// Date yyyy-mm-dd
        else Date += "-" + stringDD;
        
        editEmployee.FuctionEditEmployee(optGender,nation, nickName, marital, Date);
        sleep(1000);
        editEmployee.clicEmployeeList();

        //Agregar Id en el campo y buscar
        sleep(1000);
        home.FuctionSearch(id);
        
        //Clic en el Id de la Tabla
        sleep(1000);
        home.clicId();
        
        //Verificación
        assertEquals("Datos iguales", firsName, verificar.getFirstName());
        assertEquals("Datos iguales", lastName, verificar.getLastName());
        assertEquals("Datos iguales", id, verificar.getIdEmployee());
        assertEquals("Datos iguales", nickName, verificar.getNickName());
        assertEquals("Datos iguales", Date, verificar.getDateBirth());         
        assertEquals("Datos iguales", nationVer, verificar.getNation());
        
        if(optGender == 1) {
            assertEquals("Datos iguales", genderVer, verificar.getGenderMale());
        } else {
            assertEquals("Datos iguales", genderVer, verificar.getGenderFamele());
        }         
        
        String marital1 = "Single";
        String marital2 = "Married";
        String marital3 = "Other";        
        if(marital == 1) assertEquals("Datos iguales", marital1, verificar.getMarital());
        if(marital == 2) assertEquals("Datos iguales", marital2, verificar.getMarital());
        if(marital == 3) assertEquals("Datos iguales", marital3, verificar.getMarital());
        
        sleep(3000);
    }
}
