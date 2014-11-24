package rozetkaPages;

import baseConfig.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created with IntelliJ IDEA.
 * User: Nastya
 * Date: 22.11.14
 * Time: 13:07
 * To change this template use File | Settings | File Templates.
 */
public class UserPage extends TestBase {
    public boolean isEntered()
    {

        WebElement profile = getDriver().findElement(By.name("profile"));
        if(profile.getText().contains("Настя")) return true;
        else return false;

    }

}
