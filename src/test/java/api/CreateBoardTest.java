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
    public void deleteBoardByIdTest(){
        //Step_1
        String boardId="J6gUqFnX";
        //Step_2
        Response res=trelloBO.deleteBoard(boardId);
        //Validate
        Assert.assertEquals(res.getStatusCode().intValue(),200,"invalid code");
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
    public void createCustomListsTest(){
        //Step_1
        String boardId=trelloBO.createBoard();
        //Step_2
        Response res1=trelloBO.customBoard(boardId, "Я");
        Response res2=trelloBO.customBoard(boardId, "Хочу");
        Response res3=trelloBO.customBoard(boardId, "Їсти");
        Response res4=trelloBO.customBoard(boardId, "Давай");
        Response res5=trelloBO.customBoard(boardId, "Працюй");
        //Validate
        Assert.assertEquals(res1.getStatusCode().intValue(),200,"invalid code");
        Assert.assertEquals(res2.getStatusCode().intValue(),200,"invalid code");
        Assert.assertEquals(res3.getStatusCode().intValue(),200,"invalid code");
        Assert.assertEquals(res4.getStatusCode().intValue(),200,"invalid code");
        Assert.assertEquals(res5.getStatusCode().intValue(),200,"invalid code");
    }

    @Test
    public void createCustomBoardTest(){
        //Step1 createBoard
        String boardId = trelloBO.createBoard();
        //Step2 Get Lists on a Board
        String listId = trelloBO.getListIds(boardId).getJSONObject(0).get("id").toString();
        System.out.println(listId);
        //Step3 Create a new Card
        Response res = trelloBO.createCard(listId, "Car");
        System.out.println(res.getBody());
        //Validate
        Assert.assertEquals(res.getStatusCode().intValue(),200,"invalid code");
    }

    @Test
    public void moveCardOnListTest(){
        //Step1 createBoard
        String boardId = trelloBO.createBoard();
        //Step2 Change Name
        trelloBO.updateBoard(boardId);
        //Step3 create two List
        trelloBO.customBoard(boardId, "пиріжок");
        trelloBO.customBoard(boardId, "пільмєнь");
        //Step4 Get Lists on a Board
        JSONArray listIds = trelloBO.getListIds(boardId);
        String listId = listIds.getJSONObject(0).get("id").toString();
        //Step5 Create two new Card
        trelloBO.createCard(listId, "пиріжок");
        trelloBO.createCard(listId, "пільмєнь");
        //Step6 Get first a Card
        String cardId = trelloBO.getCardIdsByList(listId).getJSONObject(0).get("id").toString();
        //Step7 Move Card
        listId = listIds.getJSONObject(1).get("id").toString();
        System.out.println(listId);
        Response res = trelloBO.moveCard(cardId, listId);
        //Validate
        Assert.assertEquals(res.getStatusCode().intValue(),200,"invalid code");
    }
}
