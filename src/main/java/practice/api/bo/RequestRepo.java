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
        boardName = "try10";
        request.setPath("1/boards/?name="+ boardName+ "&defaultLists=false&key="+ KEY + "&token=" + TOKEN);
        request.setMethod("POST");
        return request;
    }

    public static  Request deleteBoard(String BoardId){
        Request request = baseTrelloRequest();
        request.setPath("1/boards/"+BoardId+"?key=" + KEY + "&token=" + TOKEN);
        request.setMethod("DELETE");
        return request;
    }

    public static Request updateInfoTrelloBoard(String boardId) {
        Request request=baseTrelloRequest();
        request.setPath("1/boards/"+boardId+"/labels?name=Green&color=red&key=" + KEY + "&token=" + TOKEN);
        request.setMethod("POST");
        return request;
    }

    public static  Request createTrelloList(String boardId){
        Request request = baseTrelloRequest();
        request.setPath("1/boards/"+boardId+"/lists?name=ToDo&pos=bottom&key="+ KEY + "&token=" + TOKEN);
        request.setMethod("POST");
        return request;
    }

    public static Request getidList(String boardId){
        Request request = baseTrelloRequest();
        request.setPath("1/boards/" + boardId + "/lists?key="+KEY + "&token="+TOKEN);
        request.setMethod("GET");
        return request;
    }

    public static Request getidLabel(String boardId){
        Request request = baseTrelloRequest();
        request.setPath("1/boards/" + boardId + "/labels?key="+KEY + "&token="+TOKEN);
        request.setMethod("GET");
        return request;
    }

    public static Request getidCard(String listid){
        Request request = baseTrelloRequest();
        request.setPath("1/lists/" + listid + "/cards?key="+KEY + "&token="+TOKEN);
        request.setMethod("GET");
        return request;
    }


    public  static Request creatteTrelloCard(String listId){
        Request request = baseTrelloRequest();
        request.setPath("1/cards?idList=" + listId + "&name=ATframe&key="+ KEY + "&token="+ TOKEN);
        request.setMethod("POST");
        return request;
    }

    public static Request createLabelonCard(String cardId, String labelid){
        Request request=baseTrelloRequest();
        request.setPath("1/cards/" + cardId + "/IdLabels?value="+labelid+"&key="+ KEY + "&token="+ TOKEN);
        request.setMethod("POST");
        return request;

    }





}
