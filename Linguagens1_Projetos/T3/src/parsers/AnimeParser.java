package parsers;

import dao.AnimeDao;
import models.Anime;
import models.Manga;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Classe concreta que vai servir de parser para o anime.
 * @author Guilherme Ballardini - Guiballa@hotmail.com
 * @author Yago Garcia Battaggia - yagobattaggia@gmail.com
 * @since 04/10/2020
 * @version 1.0
 */
public class AnimeParser {
    private AnimeDao animeDao;

    /**
     * Método PardeJSON, que ele vai receber um json e retornar o objeto anime.
     * @param json Json que será analisado
     */
    public static Anime ParseJSON(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
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
