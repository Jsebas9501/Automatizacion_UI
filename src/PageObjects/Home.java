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
public class Home {
    WebDriver driver;
    By PIM = By.id("menu_pim_viewPimModule");
    By addEmployee = By.id("menu_pim_addEmployee");
    By btnAddEmployee = By.id("btnAdd");
    
    public Home(WebDriver driver){
        this.driver = driver;
    }
    
    public void clicPIM(){
        driver.findElement(PIM).click();
    }
    
    public void clicAddEmployee(){
        driver.findElement(addEmployee).click();
    }
    
    public void clicBtnAddEmployee(){
        driver.findElement(btnAddEmployee).click();
    }
}
