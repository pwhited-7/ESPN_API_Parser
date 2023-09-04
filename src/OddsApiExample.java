import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

import com.google.gson.*;
import org.w3c.dom.ls.LSOutput;

public class OddsApiExample {
    public static void main(String[] args) {
        String jsonString = getJson();
        mlbParse(jsonString);

    }
    public static void mlbParse(String json){
        int counter = 0;
        Gson gson = new Gson();
        // Converting json string to object
        // leagues, season, day, events
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        // Get events array which has each game being played
        // Array size = # of games
        JsonArray gamesArray = jsonObject.getAsJsonArray("events");
        while(counter < gamesArray.size()) {
            // Get specific game object
            JsonObject game1 = gson.fromJson(gamesArray.get(counter), JsonObject.class);

            // Competitions array (size 1)
            JsonArray array1 = game1.getAsJsonArray("competitions");

            // Get object from array1
            JsonObject array1Object = gson.fromJson(array1.get(0), JsonObject.class);

            // Gets competitors array size 2 (teams playing for one game)
            JsonArray competitorsArray = array1Object.getAsJsonArray("competitors");

            // Gets json object from game chosen; 15 categories - id, team(obj), score, etc..
            JsonObject homeTeam = competitorsArray.get(0).getAsJsonObject();
            JsonObject awayTeam = competitorsArray.get(1).getAsJsonObject();

            // Home Team Info
            String homeTeamName = homeTeam.getAsJsonObject("team").get("displayName").getAsString();
            int homeTeamScore = homeTeam.get("score").getAsInt();

            // Away Team Info
            String awayTeamName = awayTeam.getAsJsonObject("team").get("displayName").getAsString();
            int awayTeamScore = awayTeam.get("score").getAsInt();

            MLB game = new MLB(homeTeamName, homeTeamScore, awayTeamName, awayTeamScore);

            game.mlbArrayList.add(game);
            System.out.println(gson.toJson(game, MLB.class));
            counter++;
        }
    }

    public static String getJson(){
        String jsonString = null;
        String apyKey = "";
        try {
            // Create a URL object with the API endpoint
//
            URL url = new URL("http://site.api.espn.com/apis/site/v2/sports/baseball/mlb/scoreboard");
            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Print the response
            jsonString = response.toString();
//            System.out.println("Response: " + jsonString);

            // Close the connection
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
