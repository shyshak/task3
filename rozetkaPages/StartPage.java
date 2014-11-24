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

    public void open(String url)
    {
        getDriver().get(url);
    }

    public boolean isOpened(String url)
    {
        if(getDriver().getCurrentUrl().equals(url)) return true;
        else return false;
    }

    public void logIn()
    {
        WebElement signIn = getDriver().findElement(By.xpath(".//*[@id='user_menu']/div/a"));
        signIn.click();

        WebElement name = getDriver().findElement(By.name("login"));
        name.sendKeys(TestData.email);

        WebElement pass = getDriver().findElement(By.name("password"));
        pass.sendKeys(TestData.password);

        getDriver().findElement(By.cssSelector("button.button-css-blue.auth-f-submit-btn")).click();


    }
    public void enterAs(String socialNetType)
    {

        if (socialNetType.equals("vk"))
        {
            getDriver().findElement(By.linkText("Вконтакте")).click();
        }
        if(socialNetType.equals("fb"))
        {
            getDriver().findElement(By.linkText("Facebook")).click();
        }
    }
}