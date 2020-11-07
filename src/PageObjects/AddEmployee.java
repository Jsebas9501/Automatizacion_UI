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
public class AddEmployee {
    WebDriver driver;
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By employeeId = By.name("employeeId");
    By Save = By.id("btnSave");
    
    public AddEmployee(WebDriver driver){
        this.driver = driver;
    }
    
    public void setFirstName(String FirstNameText){
        driver.findElement(firstName).sendKeys(FirstNameText);
    }
    
    public void setLastName(String LastNameText){
        driver.findElement(lastName).sendKeys(LastNameText);
    }
    
    public String getEmployeeId(){
        String id = driver.findElement(employeeId).getAttribute("value");
        return id;
    }
    
    public void clicSave(){
        driver.findElement(Save).click();
    }
    
    public void FuctionAddEmployee(String Firtname, String Lastname){
        this.setFirstName(Firtname);
        this.setLastName(Lastname);
        //this.getEmployeeId();
        this.clicSave();
    }
    
    
}
