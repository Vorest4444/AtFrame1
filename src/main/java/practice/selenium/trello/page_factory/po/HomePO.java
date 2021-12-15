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


    @FindBy(xpath = "//input[@value='Add list']")
    private ButtonElement cardChek;

    @FindBy(xpath = "//a[@aria-label='Cancel list editing']")
    private ButtonElement listChek;


    @FindBy(xpath = "//span[@class='_1e3OHas5aNG1hj']//*[name()='svg']")
    private ButtonElement templChek;



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
        return listChek.waitForMeVisible(10000);
    }
    @Override


    @Step("isCreateBoard")
    public boolean isCreateCard() {
        return cardChek.waitForMeVisible(10000);
    }

    @Step("isCreateBoard")
    public boolean isCreateTempl() {
        return templChek.waitForMeVisible(10000);
    }







}
