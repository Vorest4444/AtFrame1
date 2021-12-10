package practice.selenium.trello.page_factory.po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import practice.selenium.decorator.ButtonElement;
import practice.selenium.parallel_run.BrowserFactory;

public class HomePO extends BasicPO {

    @FindBy(xpath = "//span[@aria-label='NotificationIcon']")
    private ButtonElement kolokol;

    @FindBy(xpath = "//button[@title='Board views']")
    private ButtonElement board;


    @Override
    @Step("isOpen")
    public boolean isOpen() {
        return kolokol.waitForMeVisible(10000);
    }

    @Override
    @Step("isCreateBoard")
    public boolean isCreateBoard() {
        return board.waitForMeVisible(10000);
    }

    @Override
    @Step("isCreateBoard")
    public boolean isCreateList() {
        return board.waitForMeVisible(10000);
    }
    @Override


    @Step("isCreateBoard")
    public boolean isCreateCard() {
        return board.waitForMeVisible(10000);
    }

    @Step("isCreateBoard")
    public boolean isCreateTempl() {
        return board.waitForMeVisible(10000);
    }







}
