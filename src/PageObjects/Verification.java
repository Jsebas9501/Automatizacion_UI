/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Sebastian
 * Taller de Atomatización UI - Ejercicio 03
 */
public class Verification {
    WebDriver driver;
    By firstName = By.xpath("//*[@id=\"personal_txtEmpFirstName\"]");
    By lastName = By.xpath("//*[@id=\"personal_txtEmpLastName\"]");
    By employeeId = By.xpath("//*[@id=\"personal_txtEmployeeId\"]"); 
    By optMale = By.xpath("//*[@id=\"personal_optGender_1\"]");
    By optFamele = By.xpath("//*[@id=\"personal_optGender_2\"]");
    By Nationality = By.xpath("//*[@id=\"personal_cmbNation\"]");
    By NickName = By.xpath("//*[@id=\"personal_txtEmpNickName\"]");
    By MaritalStatus = By.xpath("//*[@id=\"personal_cmbMarital\"]");
    By DateBirth = By.xpath("//*[@id=\"personal_DOB\"]");
    
    public Verification (WebDriver driver){
        this.driver = driver;
    }
    
    public String getFirstName(){
        String firstN = driver.findElement(firstName).getAttribute("value");
        return firstN;
    }
    
    public String getLastName(){
        String lastN = driver.findElement(lastName).getAttribute("value");
        return lastN;
    }
    
    public String getIdEmployee(){
        String emploId = driver.findElement(employeeId).getAttribute("value");
        return emploId;
    }
    
    public String getNickName(){
        String nickN = driver.findElement(NickName).getAttribute("value");
        return nickN;
    }
    
    public String getDateBirth(){
        String dateBirth = driver.findElement(DateBirth).getAttribute("value");
        return dateBirth;
    }
    
    public String getGenderMale(){
        String genderM = driver.findElement(optMale).getAttribute("value");
        return genderM;
    }
    
    public String getGenderFamele(){
        String genderF = driver.findElement(optFamele).getAttribute("value");
        return genderF;
    }
    
    public String getNation(){
        String nation = driver.findElement(Nationality).getAttribute("value");
        return nation;
    }
    
    public String getMarital(){
        String marital = driver.findElement(MaritalStatus).getAttribute("value");
        return marital;
    }
    
   
}
