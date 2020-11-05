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
    
    public EditEmployee(WebDriver driver){
        this.driver = driver;
    }
    
    public void clicEdit(){
        driver.findElement(Edit).click();
    }
    
    public void FuctionEditEmployee(){
        this.clicEdit();
    }
}
