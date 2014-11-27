package rozetkaPages;

import baseConfig.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tets.TestData;

/**
 * Created with IntelliJ IDEA.
 * User: Nastya
 * Date: 22.11.14
 * Time: 13:07
 * To change this template use File | Settings | File Templates.
 */
public class StartPage extends TestBase {

    //opens Rozetka home page
    public void open(String url)
    {
        getDriver().get(url);
    }

    //check if opened page is Rozetka page
    public boolean isOpened(String url)
    {
        if(getDriver().getCurrentUrl().equals(url)) return true;
        else return false;
    }

    //log in Rozetka using name and password
    public void logIn(String userEmail, String userPassword)
    {
        //click on LogIn button
        WebElement signIn = getDriver().findElement(By.xpath(".//*[@id='user_menu']/div/a"));
        signIn.click();

        //sends user email to userEmail field
        WebElement name = getDriver().findElement(By.name("login"));
        name.sendKeys(userEmail);

        // sends user password to userPassword field
        WebElement pass = getDriver().findElement(By.name("password"));
        pass.sendKeys(userPassword);

        //click on "Войти" button
        getDriver().findElement(By.cssSelector("button.button-css-blue.auth-f-submit-btn")).click();


    }

    // log in Rozetka using social network credentials
    public void enterAs(String socialNetType)
    {
        getDriver().findElement(By.name("signin")).click();

        if (socialNetType.equals("vk"))
        {
            getDriver().findElement(By.xpath("//a[contains(text(),'Вконтакте')]")).click();
        }
        if(socialNetType.equals("fb"))
        {
            getDriver().findElement(By.linkText("Facebook")).click();
        }


    }
}