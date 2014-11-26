package tets;

import baseConfig.TestBase;
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

    @Test(dependsOnMethods = {"goToRozetkaTest"}, enabled = true)
    public void enterAsTest()
    {
        startPage.logIn(TestData.email, TestData.password);
    }

   /* @Test(dependsOnMethods = {"goToRozetkaTest"}, enabled = true)
    public void enterSocNetTest()
    {
        startPage.enterAs(TestData.socialNetType);
        socNetPage.signIn(TestData.email,TestData.password);

    }  */


    @Test(dependsOnMethods = {"enterAsTest"}, enabled = true)
    public void isEnteredTest()
    {
        Assert.assertTrue(userPage.isEntered(TestData.userName));
        Assert.assertTrue(userPage.isOpenSettings());
    }
}
