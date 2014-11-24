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

    public void signIn()
    {
        WebElement emailField = getDriver().findElement(By.name("email"));
        emailField.sendKeys(TestData.email);

        WebElement passwordField = getDriver().findElement(By.name("pass"));
        passwordField.sendKeys(TestData.password);

        getDriver().findElement(By.cssSelector("popup_login_btn> #install_allow")).click();
    }

   }

