package rozetkaPages;

import baseConfig.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tets.TestData;

//Page of social net window where you enter credentials
//for logining to rozetka as a vk or fb user
public class SocialNetPage extends TestBase {

    public void signIn(String userEmail, String userPassword) {


        //sends user email to userEmail field
        WebElement emailField = getDriver().findElement(By.name("email"));
        emailField.sendKeys(userEmail);

        //sends user password to userPassword field
        WebElement passwordField = getDriver().findElement(By.name("pass"));
        passwordField.sendKeys(userPassword);

        //click on "Войти" button
        getDriver().findElement(By.cssSelector("#install_allow")).click();

        //Thread.sleep(2000);

        getDriver().findElement(By.xpath("//button[contains(text(),'Разрешить')]")).click();
    }

   }

