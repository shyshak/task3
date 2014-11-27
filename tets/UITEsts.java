package tets;

import baseConfig.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import rozetkaPages.SocialNetPage;
import rozetkaPages.StartPage;
import rozetkaPages.UserPage;

/**
 * Created with IntelliJ IDEA.
 * User: Nastya
 * Date: 22.11.14
 * Time: 13:18
 * To change this template use File | Settings | File Templates.
 */
public class UITEsts extends TestBase {
    StartPage startPage = new StartPage();
    SocialNetPage socNetPage = new SocialNetPage();
    UserPage userPage = new UserPage();

    String parentWindow = getDriver().getWindowHandle();

    @Test
    public void goToRozetkaTest()
    {
        startPage.open(TestData.rozetkaURL);
        Assert.assertTrue(startPage.isOpened("http://rozetka.com.ua/"));

    }

   /* @Test(dependsOnMethods = {"goToRozetkaTest"}, enabled = true)
    public void enterAsTest()
    {
        startPage.logIn(TestData.email, TestData.password);
    }  */

    @Test(dependsOnMethods = {"goToRozetkaTest"}, enabled = true)
    public void enterSocNetTest() {
        //to remember main window of the browser
        String winHandleBefore = getDriver().getWindowHandle();
        startPage.enterAs(TestData.socialNetType);

        for(String winHandle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(winHandle);
        }

        socNetPage.signIn(TestData.email,TestData.password);
        for(String winHandle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(winHandle);
        }

        //Switch back to original browser (first window)
        getDriver().switchTo().window(winHandleBefore);

    }


    @Test(dependsOnMethods = {"enterSocNetTest"}, enabled = true)
    public void isEnteredTest()
    {
        Assert.assertTrue(userPage.isEntered(TestData.userName));
        Assert.assertTrue(userPage.isOpenSettings());
    }
}
