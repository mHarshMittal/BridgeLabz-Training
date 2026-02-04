import org.json.JSONArray;
import org.json.JSONObject;
import org.json.CDL;

import java.nio.file.Files;
import java.nio.file.Paths;

public class IPLCensorAnalyzer {

    private static String maskTeam(String team) {
        return team.split(" ")[0] + " ***";
    }

    public static void main(String[] args) throws Exception {

        // JSON processing
        JSONArray jsonData = new JSONArray(
                new String(Files.readAllBytes(Paths.get("ipl_input.json")))
        );

        for (int i = 0; i < jsonData.length(); i++) {
            JSONObject match = jsonData.getJSONObject(i);

            match.put("team1", maskTeam(match.getString("team1")));
            match.put("team2", maskTeam(match.getString("team2")));
            match.put("winner", maskTeam(match.getString("winner")));
            match.put("player_of_match", "REDACTED");

            JSONObject oldScore = match.getJSONObject("score");
            JSONObject newScore = new JSONObject();

            for (String key : oldScore.keySet()) {
                newScore.put(maskTeam(key), oldScore.getInt(key));
            }

            match.put("score", newScore);
        }

        Files.write(Paths.get("ipl_censored.json"),
                jsonData.toString(2).getBytes());

        // CSV processing
        JSONArray csvData = CDL.toJSONArray(
                new String(Files.readAllBytes(Paths.get("ipl_input.csv")))
        );

        for (int i = 0; i < csvData.length(); i++) {
            JSONObject row = csvData.getJSONObject(i);

            row.put("team1", maskTeam(row.getString("team1")));
            row.put("team2", maskTeam(row.getString("team2")));
            row.put("winner", maskTeam(row.getString("winner")));
            row.put("player_of_match", "REDACTED");
        }

        Files.write(Paths.get("ipl_censored.csv"),
                CDL.toString(csvData).getBytes());

        System.out.println("IPL data censored successfully.");
    }
}

