package practice.selenium.trello.page_factory.bo;

import io.qameta.allure.Step;
import practice.hibernate.model.Name;
import practice.hibernate.model.User;
import practice.selenium.trello.page_factory.po.LoginPO;

import static practice.hibernate.HibernateTest.getName;
import static practice.hibernate.HibernateTest.getUser;

public class LoginBO {

    @Step("isOpen")
    public boolean login(Integer userId) {
        LoginPO loginPO = new LoginPO().goToLoginPage();
        User user = getUser(userId);
        return loginPO.isOpen()
                &&
                loginPO.inputLogin(user.getLogin())
                        .inputPassword(user.getPass())
                        .mySleep(4000)
                        .loginSubmit()
                        .inputPassword(user.getPass())
                        .loginSubmit1()
                        .isOpen();
    }


    @Step("isCreateBoard")
    public boolean CreateBoard(Integer userId,String massage) {
        LoginPO loginPO = new LoginPO().goToLoginPage();
        System.out.println("getUser");
        User user = getUser(userId);
        System.out.println("Do");
        return   loginPO.inputLogin(user.getLogin())
                .inputPassword(user.getPass())
                .mySleep(4000)
                .loginSubmit()
                .inputPassword(user.getPass())
                .loginSubmit1()
                .mySleep(6000)
                .createBoard()
                .mySleep(3000)
                .inputMassages(massage)
                .submitBoard()
                .CreateBoardChek()
                .isCreateBoard();
    }

    @Step("isListCreated")
    public boolean createList(Integer userId,String massage, String Name) {
        LoginPO loginPO = new LoginPO().goToLoginPage();
        System.out.println("getUser");
        User user = getUser(userId);
        System.out.println("Do");
        return   loginPO.inputLogin(user.getLogin())
                .inputPassword(user.getPass())
                .mySleep(4000)
                .loginSubmit()
                .inputPassword(user.getPass())
                .loginSubmit1()
                .mySleep(6000)
                .createBoard()
                .mySleep(3000)
                .inputMassages(massage)
                .submitBoard()
                .mySleep(3000)
                .inputName(Name)
                .createlist()
                .CreateListChek()
                .isCreateList();
    }

    @Step("isCardCreated")
    public boolean createCard(Integer userId,Integer nameId,String cardName) {
        LoginPO loginPO = new LoginPO().goToLoginPage();
        System.out.println("getUser");
        User user = getUser(userId);
        Name name = getName(nameId);
        System.out.println("Do");
        return   loginPO.inputLogin(user.getLogin())
                .inputPassword(user.getPass())
                .mySleep(4000)
                .loginSubmit()
                .inputPassword(user.getPass())
                .loginSubmit1()
                .mySleep(6000)
                .createBoard()
                .mySleep(3000)
                .inputMassages(name.getName())
                .submitBoard()
                .mySleep(3000)
                .inputCardName(cardName)
                .createCard()
                .CreateCardChek()
                .isCreateCard();
    }



    @Step("isOpen")
    public boolean createTempl(Integer userId) {
        LoginPO loginPO = new LoginPO().goToLoginPage();
        User user = getUser(userId);
        return loginPO.isOpen()
                &&
                loginPO.inputLogin(user.getLogin())
                        .inputPassword(user.getPass())
                        .mySleep(4000)
                        .loginSubmit()
                        .inputPassword(user.getPass())
                        .loginSubmit1()
                        .mySleep(4000)
                        .pageTempl()
                        .mySleep(3000)
                        .pageBus()
                        .mySleep(3000)
                        .takeTempl()
                        .mySleep(3000)
                        .useTempl()
                        .createTempl()
                        .CreateTemplChek()
                        .isCreateTempl();
    }




}
