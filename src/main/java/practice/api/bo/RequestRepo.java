package practice.api.bo;



public class RequestRepo {

    public static Request getPostman() {
        Request request=new Request();
        request.setProtocol("https");
        request.setHost("postman-echo.com");
        request.setPath("get");
        request.setMethod("GET");
        return request;
    }

    private final static String KEY="7b0c058a1dcbfd4e9a5c55d90e53066f";
    private final static String TOKEN="c3e9c5dc1608fe18b397e41131c2ab7203b9a30d7650a9f6af459d376f40b2b7";


    private static Request baseTrelloRequest() {
        Request request=new Request();
        request.setProtocol("https");
        request.setHost("api.trello.com");
        return request;
    }

    public static Request createTrelloBoard(String boardName) {
        Request request=baseTrelloRequest();
        boardName = "AtFrame";
        request.setPath("1/boards/?name="+ boardName+ "&defaultLists=false&key="+ KEY + "&token=" + TOKEN);
        request.setMethod("POST");
        return request;
    }

    public static Request deleteTrelloBoard(String boardId) {
        Request request=baseTrelloRequest();
        request.setPath("1/boards/"+boardId+"?key=" + KEY + "&token=" + TOKEN);
        request.setMethod("DELETE");
        return request;
    }

    public static Request updateInfoTrelloBoard(String boardId) {
        Request request=baseTrelloRequest();
        request.setPath("1/boards/"+boardId+"?name=AtFrame&desc=Test&prefs/background=green&key=" + KEY + "&token=" + TOKEN);
        request.setMethod("PUT");
        return request;
    }

    public static Request customTrelloBoard(String boardId, String nameList) {
        Request request=baseTrelloRequest();
        request.setPath("1/boards/" + boardId + "/lists?name=" + nameList + "&pos=bottom&key="+ KEY + "&token="+ TOKEN);
        request.setMethod("POST");
        return request;
    }

    public static Request listIdsTrelloBoard(String boardId) {
        Request request=baseTrelloRequest();
        request.setPath("1/boards/" + boardId + "/lists?key="+KEY + "&token="+TOKEN);
        request.setMethod("GET");
        return request;
    }

    public static Request createCardTrello(String idList, String nameCart) {
        Request request=baseTrelloRequest();
        request.setPath("1/cards?idList=" + idList + "&name=" + nameCart + "&key="+ KEY + "&token="+ TOKEN);
        request.setMethod("POST");
        return request;
    }

    public static Request getCardIdsByListTrello(String idList) {
        Request request=baseTrelloRequest();
        request.setPath("1/lists/" + idList + "/cards?key="+ KEY + "&token="+ TOKEN);
        request.setMethod("GET");
        return request;
    }

    public static Request moveCardTrello(String idCart, String newIdList) {
        Request request=baseTrelloRequest();
        request.setPath("1/cards/" + idCart + "?idList=" + newIdList + "&key="+ KEY + "&token="+ TOKEN);
        request.setMethod("PUT");
        return request;
    }
}
