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
    By searchNameEmployee = By.id("empsearch_employee_name_empName");
    By searchId = By.id("empsearch_id");
    By btnSearch = By.id("searchBtn");
    By clicId = By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a");
    
    public Home(WebDriver driver){
        this.driver = driver;
    }
    
    public void clicPIM(){
        driver.findElement(PIM).click();
    }
    
    public void clicAddEmployee(){
        driver.findElement(addEmployee).click();
    }
    
    public void setSearchEmployee(String searchEmployee){
        driver.findElement(searchNameEmployee).clear();
        driver.findElement(searchNameEmployee).sendKeys(searchEmployee);
    }
    
    public void setSearchId(String SearchId){
        driver.findElement(searchId).clear();
        driver.findElement(searchId).sendKeys(SearchId);
    }
    
    public void clicSearch(){
        driver.findElement(btnSearch).click();
    }
    
    public void clicId(){
        driver.findElement(clicId).click();
    }
       
    public void FuctionSearch(String Id){
       //this.setSearchEmployee(Name);
       this.setSearchId(Id);
       this.clicSearch();        
    }
}
