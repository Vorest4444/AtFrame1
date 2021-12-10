package practice.selenium.trello.page_factory.po;


import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import practice.selenium.decorator.CustomDecorator;
import practice.selenium.parallel_run.BrowserFactory;

public abstract class BasicPO {

    public BasicPO() {
        PageFactory.initElements(new CustomDecorator(BrowserFactory.getDriver()),this);
    }

    public boolean isOpen(){ return true; };
    boolean isCreateBoard(){ return true; };
    boolean isCreateList(){ return true; };
    boolean isCreateCard(){ return true; };
    boolean isCreateTempl(){ return true; };


}
