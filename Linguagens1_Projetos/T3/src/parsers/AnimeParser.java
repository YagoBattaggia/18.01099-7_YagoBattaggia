package parsers;

import dao.AnimeDao;
import models.Anime;
import models.Manga;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnimeParser {
    private AnimeDao animeDao;
    public static Anime ParseJSON(String JSON){
        try {
            JSONObject jsonObject = new JSONObject(JSON);
            JSONArray result = jsonObject.getJSONArray("results");
            Anime anime = new Anime(
                    ((JSONObject) result.get(0)).getString("url"),
                    ((JSONObject) result.get(0)).getString("title"),
                    ((JSONObject) result.get(0)).getString("synopsis"),
                    ((JSONObject) result.get(0)).getInt("episodes"),
                    ((JSONObject) result.get(0)).getDouble("score")
            );
            return anime;
        } catch (JSONException e) {
            System.out.println(e);
        }
        return null;
    }
}
