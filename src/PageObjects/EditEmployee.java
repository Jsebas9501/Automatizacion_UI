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
 */
public class EditEmployee {
    WebDriver driver;
    By Edit = By.cssSelector("input[value='Edit']");
    By Gender = By.cssSelector("input[name='personal[optGender]']");
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
    
    public void selectGender(String GenderOpt){
        driver.findElement(Gender).sendKeys(GenderOpt);
    }
    
    public void selectNationality(String NationOpt){
        driver.findElement(Nationality).sendKeys(NationOpt);
    }
    
    public void setNickName(String NickNameText){
        driver.findElement(NickName).sendKeys(NickNameText);
    }
    
    public void selectMarital(String Marital){
        driver.findElement(MaritalStatus).sendKeys(Marital);
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
    
    public void FuctionEditEmployee(String gender, String nationaliy, String nickName, String maritalStatus, String dateBirth){
        this.clicEdit();
        this.selectGender(gender);
        this.selectNationality(nationaliy);
        this.setNickName(nickName);
        this.selectMarital(maritalStatus);
        this.selectDate(dateBirth);
        this.clicEditSave();
        //this.clicEmployeeList();
    }
}
