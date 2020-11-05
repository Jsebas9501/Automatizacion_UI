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
public class Login {
    WebDriver driver;
    By Username = By.id("txtUsername");
    By Password = By.id("txtPassword");
    By Login = By.id("btnLogin");
    
    public Login(WebDriver driver) {
        this.driver = driver;
    }
    
    public void setUsername(String UserNameText) {
        driver.findElement(Username).sendKeys(UserNameText);
    }
    
    
    public void setPassword(String PasswordText) {
        driver.findElement(Password).sendKeys(PasswordText);
    }
    
    public void clicLogin(){
        driver.findElement(Login).click();
    }
    
    public void FuctionLogin(String Username, String Password){
        this.setUsername(Username);
        this.setPassword(Password);
        this.clicLogin();
    }
}
