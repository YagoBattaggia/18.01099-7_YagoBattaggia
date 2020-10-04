package parsers;


import dao.MangaDao;
import models.Manga;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MangaParser {
    private MangaDao mangaDao;
    public static Manga ParseJSON(String JSON) {
        try {
            JSONObject jsonObject = new JSONObject(JSON);
            JSONArray result = jsonObject.getJSONArray("results");
            Manga manga = new Manga(
                    ((JSONObject) result.get(0)).getString("url"),
                    ((JSONObject) result.get(0)).getString("title"),
                    ((JSONObject) result.get(0)).getString("synopsis"),
                    ((JSONObject) result.get(0)).getInt("chapters"),
                    ((JSONObject) result.get(0)).getInt("volumes"),
                    ((JSONObject) result.get(0)).getString("type"),
                    ((JSONObject) result.get(0)).getDouble("score")
            );
            return manga;

        } catch (JSONException | NullPointerException e) {
            System.out.println(e);
        }
        return null;
    }
}
