package ui;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import practice.selenium.trello.page_factory.bo.LoginBO;
import practice.selenium.parallel_run.BrowserFactory;




@Test
public class TrelloTest {





    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest() {
        BrowserFactory.initDriver("edge");
        LoginBO loginBO = new LoginBO();
        Assert.assertTrue(loginBO.login(4),"login Failed!");

    }
    @Severity(SeverityLevel.CRITICAL)
    public void createBoardTest() {
        BrowserFactory.initDriver("edge");
        LoginBO loginBO = new LoginBO();
        Assert.assertTrue(loginBO.CreateBoard(4,"Hi bro"),"Send Massage Failed!");

    }


    @Test()
    public void createListTest() {
        BrowserFactory.initDriver("edge");
        LoginBO loginBO = new LoginBO();
        Assert.assertTrue(loginBO.createList(4,"Hi bro", "List1"));

    }
    @DataProvider(name = "data-provider")

    public static Object[][] dataProviderMethod()
    {
        return new Object[][] { { "List1" }, { "List2" } };
    }

    @Test(dataProvider = "data-provider")
    public void createCardTest(String data) {
        BrowserFactory.initDriver("edge");
        LoginBO loginBO = new LoginBO();
        Assert.assertTrue(loginBO.createCard(4,1, data));

    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void createTemplTest() {
        BrowserFactory.initDriver("edge");
        LoginBO loginBO = new LoginBO();
        Assert.assertTrue(loginBO.createTempl(4), "login Failed!");

    }





}
