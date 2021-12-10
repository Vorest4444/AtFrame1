package practice.selenium.trello.page_factory.po;

import io.qameta.allure.Link;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import practice.selenium.decorator.ButtonElement;
import practice.selenium.decorator.InputElement;
import practice.selenium.parallel_run.BrowserFactory;


public class LoginPO extends BasicPO {
    @FindBy(xpath = "//input[@id='user']")
    private InputElement loginInput;
    @FindBy(xpath = "//input[@id='password']")
    private InputElement passInput;
    private InputElement textInput;

    private ButtonElement SubmitButton;

    @Override
    @Step("isOpen")
    public boolean isOpen() {
        System.out.println("isOpen");
        return loginInput.waitForMeVisible(8000);
    }

    @Step("inputLogin")
    public LoginPO inputLogin(String login) {
        System.out.println("inputLogin");
        loginInput.sendKeys(login);
        return this;
    }
    @Step("inputPassword")
    public LoginPO inputPassword(String pass) {
        System.out.println("inputPassword");
        passInput.sendKeys(pass);
        return this;
    }


    @Step("loginSubmit1")
    public LoginPO loginSubmit1() {
        System.out.println("loginSubmit1");
        SubmitButton = new ButtonElement(BrowserFactory.getDriver().findElement( By.xpath("//button[@id='login-submit']//span[@class='css-19r5em7']")));
        SubmitButton.click();
        return this;
    }

    @Step("loginSubmit")
    public LoginPO loginSubmit() {
        System.out.println("loginSubmit");
        SubmitButton = new ButtonElement(BrowserFactory.getDriver().findElement( By.xpath("//input[@id='login']")));
        SubmitButton.click();
        return this;
    }

    @Step("createBoard")
    public LoginPO createBoard(){
        System.out.println("createBoard");
        SubmitButton = new ButtonElement(BrowserFactory.getDriver().findElement( By.xpath("//div[@class='board-tile mod-add']")));
        SubmitButton.click();
        return this;
    }

    @Step("inputMassages")
    public LoginPO inputMassages(String massage) {
        System.out.println("inputMassage");
        textInput = new InputElement(BrowserFactory.getDriver().findElement(By.xpath("//input[@placeholder='Add board title']")));
        textInput.sendKeys(massage);
        return this;
    }

    @Step("submitBoard")
    public LoginPO submitBoard(){
        System.out.println("submitBoard");
        SubmitButton = new ButtonElement(BrowserFactory.getDriver().findElement( By.xpath("//button[normalize-space()='Create board']")));
        SubmitButton.click();
        return this;
    }

    @Step("addlist")
    public LoginPO addlist(){
        System.out.println("addlist");
        SubmitButton = new ButtonElement(BrowserFactory.getDriver().findElement( By.xpath("//body/div[@id='trello-root']/div[@id='chrome-container']/div[@class='_2ffa7ex19Eoxvc']/div[@id='surface']/main[@id='popover-boundary']/div/div/div[@id='content']/div[@class='board-wrapper']/div[@class='board-main-content']/div[@class='board-canvas']/div[@id='board']/div[1]/div[1]/div[3]/a[1]")));
        SubmitButton.click();
        return this;
    }

    @Step("inputName")
    public LoginPO inputName(String Name) {
        System.out.println("inputMassage");
        textInput = new InputElement(BrowserFactory.getDriver().findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']")));
        textInput.sendKeys(Name);
        return this;
    }

    @Step("createlist")
    public LoginPO createlist(){
        System.out.println("createlist");
        SubmitButton = new ButtonElement(BrowserFactory.getDriver().findElement( By.xpath("//input[@value='Add card']")));
        SubmitButton.click();
        return this;
    }

    @Step("inputCardName")
    public LoginPO inputCardName(String cardName) {
        System.out.println("inputCardName");
        textInput = new InputElement(BrowserFactory.getDriver().findElement(By.xpath("//input[@placeholder='Enter list title…']")));
        textInput.sendKeys(cardName);
        return this;
    }

    @Step("createCard")
    public LoginPO createCard(){
        System.out.println("createCard");
        SubmitButton = new ButtonElement(BrowserFactory.getDriver().findElement( By.xpath("//input[@value='Add list']")));
        SubmitButton.click();
        return this;
    }

    @Step("pageTempl")
    public LoginPO pageTempl(){
        System.out.println("pageTempl");
        SubmitButton = new ButtonElement(BrowserFactory.getDriver().findElement( By.xpath("//span[normalize-space()='Templates']")));
        SubmitButton.click();
        return this;
    }
    @Step("pageBus")
    public LoginPO pageBus(){
        System.out.println("pageBus");
        SubmitButton = new ButtonElement(BrowserFactory.getDriver().findElement( By.xpath("//a[@title='Business']//div[@class='_3Lw3izKlYMYD6c']")));
        SubmitButton.click();
        return this;
    }

    @Step("takeTempl")
    public LoginPO takeTempl(){
        System.out.println("takeTempl");
        SubmitButton = new ButtonElement(BrowserFactory.getDriver().findElement( By.xpath("//a[@title='An Order Management Pipeline by Crmble']//div[@class='_17VcHfbAgFVdB4']")));
        SubmitButton.click();
        return this;
    }

    @Step("useTempl")
    public LoginPO useTempl(){
        System.out.println("useTempl");
        SubmitButton = new ButtonElement(BrowserFactory.getDriver().findElement( By.xpath("//button[normalize-space()='Use template']")));
        SubmitButton.click();
        return this;
    }
    @Step("createTempl")
    public LoginPO createTempl(){
        System.out.println("createTempl");
        SubmitButton = new ButtonElement(BrowserFactory.getDriver().findElement( By.xpath("//input[@value='Create']")));
        SubmitButton.click();
        return this;
    }



    @Step("loginCheck")
    public HomePO loginCheck() {
        System.out.println("loginCheck");
        return new HomePO();
    }

    @Step("massageSendCheck")
    public HomePO massageSendCheck() { return new HomePO();  }

    @Step("massageSendCheck")
    public HomePO CreateBoardChek() { return new HomePO();  }

    @Step("massageSendCheck")
    public HomePO CreateListChek() { return new HomePO();  }

    @Step("massageSendCheck")
    public HomePO CreateCardChek() { return new HomePO();  }

    @Step("massageSendCheck")
    public HomePO CreateTemplChek() { return new HomePO();  }


    public LoginPO mySleep(long time){
        System.out.println("sleep on: "+time+" millis.");
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("goToLoginPage")
    @Link("https://trello.com/login")
    public LoginPO goToLoginPage() {
        BrowserFactory.getDriver().get("https://trello.com/login");
        return this;
    }
    @Step("goToTemplates")
    @Link("https://trello.com/templates/business")
    public LoginPO goToTemplates() {
        System.out.println("goToTemplates");
        BrowserFactory.getDriver().navigate().to("https://trello.com/templates/business");
        return this;
    }


}
