package api;

import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;
import practice.api.bo.Response;
import practice.api.bo.Trellobo;

public class CreateBoardTest {

    Trellobo trelloBO=new Trellobo();

    @Test
    public void createBoardTest(){
        trelloBO.createBoard();
    }

    @Test
    public void deleteBoardTest(){
        //записуємо id
        String BoardId = "qPD7AtKY";
        //видаляємо бодру
        Response res = trelloBO.delete(BoardId);
        //перевірка
        Assert.assertEquals(res.getStatusCode().intValue(),200,"get wrong");
    }


    @Test
    public void updateBoardTest(){
        //Step_1
        String boardId=trelloBO.createBoard();
        //Step_2
        Response res=trelloBO.updateBoard(boardId);
        //Validate
        Assert.assertEquals(res.getStatusCode().intValue(),200,"invalid code");
    }


    @Test
    public void createListTest(){
        //створити борду
        String boardId=trelloBO.createBoard();
        //створити ліст
        Response res = trelloBO.createList(boardId);
        //перевірка
        Assert.assertEquals(res.getStatusCode().intValue(),200,"get wrong");
    }

    @Test
    public void createCardTest(){
        //створити борду
        String boardId=trelloBO.createBoard();
        //створити ліст
        Response res = trelloBO.createList(boardId);
        //получити id ліста
        JSONArray listIds = trelloBO.getListId(boardId);
        String listId = listIds.getJSONObject(0).get("id").toString();
        //створити карду
        trelloBO.createCard(listId);
        //перевірка
        Assert.assertEquals(res.getStatusCode().intValue(),200,"get wrong");
    }

    @Test
    public void addlabelonCardTest(){
        //створити борду
        String boardId=trelloBO.createBoard();
        //створити ліст
        Response res = trelloBO.createList(boardId);
        //получити id ліста
        JSONArray listIds = trelloBO.getListId(boardId);
        String listId = listIds.getJSONObject(0).get("id").toString();
        //створити карду
        trelloBO.createCard(listId);
        //получит id карди
        JSONArray cardIds = trelloBO.getCardId(listId);
        String cardId = cardIds.getJSONObject(0).get("id").toString();
        //створити лейблу
        Response res1=trelloBO.updateBoard(boardId);
        //получити id лей
        JSONArray labelIds = trelloBO.getLabelid(boardId);
        String labelid = labelIds.getJSONObject(0).get("id").toString();
        //добавити лейблу в карту
        trelloBO.addLebel(cardId,labelid);
        Assert.assertEquals(res.getStatusCode().intValue(),200,"get wrong");
    }

}
