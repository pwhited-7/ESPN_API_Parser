



public class Main {
    public static void main(String[] args) {
    OddsApiExample api = new OddsApiExample();
    String jsonString = api.getJson();
    api.mlbParse(jsonString);


    }
}