package rozetkaPages;

import rozetkaLogIn.baseConfig.TestBase;
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


    public boolean isEntered(String name)
    {
        WebElement profile = getDriver().findElement(By.name("profile"));
        if(profile.getText().contains(name)) return true;
        else return false;

    }

    public boolean isOpenSettings()
    {
        WebElement profile = getDriver().findElement(By.name("profile"));
        profile.click();
        if(getDriver().findElement(By.className("profile-m-i-title"))!=null)
            return true;
        else
            return false;
    }

}
