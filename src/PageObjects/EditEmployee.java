/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Sebastian
 * Taller de Atomatización UI - Ejercicio 03
 */
public class EditEmployee {
    WebDriver driver;
    By Edit = By.cssSelector("input[value='Edit']");
    By optMale = By.id("personal_optGender_1");
    By optFamele = By.id("personal_optGender_2");
    By Nationality = By.id("personal_cmbNation");
    By NickName = By.id("personal_txtEmpNickName");
    By MaritalStatus = By.id("personal_cmbMarital");
    By DateBirth = By.id("personal_DOB");
    By EditSave = By.cssSelector("input[value='Save']");
    By EmployeeList = By.id("menu_pim_viewEmployeeList");
    
    public EditEmployee(WebDriver driver){
        this.driver = driver;
    }
    
    public void clicEdit(){
        driver.findElement(Edit).click();
    }
    
    public void clickMale(){
        driver.findElement(optMale).click();
    }
    public void clickFemale(){
        driver.findElement(optFamele).click();
    }
       
    public void setNickName(String NickNameText){
        driver.findElement(NickName).sendKeys(NickNameText);
    }
    
    public void selectMarital(int Marital){
        WebElement statusMarital = driver.findElement(MaritalStatus);
        Select marital = new Select(statusMarital);
        if(Marital == 1) marital.selectByVisibleText("Single");
        if(Marital == 2) marital.selectByVisibleText("Married");
        if(Marital == 3) marital.selectByVisibleText("Other");
    }
    
    public void selectNationality(int NationOpt){
        WebElement nationality = driver.findElement(Nationality);
        Select nation = new Select(nationality);
        nation.selectByIndex(NationOpt);
    }
    
    public void selectDate(String Date){
        driver.findElement(DateBirth).clear();
        driver.findElement(DateBirth).sendKeys(Date);
    }
    
    public void clicEditSave(){
        driver.findElement(EditSave).click();
    }
    
    public void clicEmployeeList(){
        driver.findElement(EmployeeList).click();
    }
    
    public void FuctionEditEmployee(int gender,int nationaliy, String nickName, int maritalStatus, String dateBirth){
        this.clicEdit();
        if(gender == 1) {
            this.clickMale();      
        } else {
            this.clickFemale();
        }  
        this.selectNationality(nationaliy);    
        this.selectMarital(maritalStatus);
        this.selectDate(dateBirth);
        this.setNickName(nickName);
        this.clicEditSave();
    }
}
