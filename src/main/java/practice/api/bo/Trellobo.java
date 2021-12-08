package practice.api.bo;

import org.bouncycastle.cert.ocsp.Req;
import org.json.JSONArray;
import org.testng.Assert;

import java.util.UUID;

public class Trellobo {


  static Client httpClient = new Client();

    public String createBoard() {
        Request createRequest = RequestRepo.createTrelloBoard("Board"+ UUID.randomUUID().toString().substring(0,5));
        Response createResponse=new Client().send(createRequest);
        Assert.assertEquals(createResponse.getStatusCode().intValue(),200,"invalid code");
        return createResponse.getBodyAsJson().getString("id");
    }


    public Response delete(String BoardId){
        Request deleteRequest = RequestRepo.deleteBoard(BoardId);
        Response deleteResponse=new Client().send(deleteRequest);
        Assert.assertEquals(deleteResponse.getStatusCode().intValue(),200,"get wrong");
        return deleteResponse;
    }



    public Response updateBoard(String boardId) {
        Request req = RequestRepo.updateInfoTrelloBoard(boardId);
        Response res=new Client().send(req);
        Assert.assertEquals(res.getStatusCode().intValue(),200,"get wrong");
        return res;
    }


    public Response createList(String boardId){
        Request req = RequestRepo.createTrelloList(boardId);
        Response res = new Client().send(req);
        Assert.assertEquals(res.getStatusCode().intValue(),200,"get wrong");
        return res;

    }

    public JSONArray getListId(String boardId){
        Request req = RequestRepo.getidList(boardId);
        Response res = new Client().send(req);
        Assert.assertEquals(res.getStatusCode().intValue(),200,"get wrong");
        return new JSONArray(res.getBody());
    }
    public JSONArray getLabelid(String boardId){
        Request req = RequestRepo.getidLabel(boardId);
        Response res = new Client().send(req);
        Assert.assertEquals(res.getStatusCode().intValue(),200,"get wrong");
        return new JSONArray(res.getBody());
    }

    public Response createCard(String listId){
        Request req = RequestRepo.creatteTrelloCard(listId);
        Response res = new Client().send(req);
        Assert.assertEquals(res.getStatusCode().intValue(),200,"get wrong");
        return  res;
    }
    public JSONArray getCardId(String listId) {
        Request req = RequestRepo.getidCard(listId);
        Response res = new Client().send(req);
        Assert.assertEquals(res.getStatusCode().intValue(),200,"invalid code");
        return new JSONArray(res.getBody());
    }

    public Response addLebel(String cardId, String labelid){
        Request req = RequestRepo.createLabelonCard(cardId, labelid);
        Response res = new Client().send(req);
        Assert.assertEquals(res.getStatusCode().intValue(),200,"get wrong");
        return  res;

    }

}
