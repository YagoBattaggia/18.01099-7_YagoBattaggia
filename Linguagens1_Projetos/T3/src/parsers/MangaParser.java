package parsers;


import dao.MangaDao;
import models.Manga;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Classe concreta que vai servir de parser para o manga.
 * @author Guilherme Ballardini - Guiballa@hotmail.com
 * @author Yago Garcia Battaggia - yagobattaggia@gmail.com
 * @since 04/10/2020
 * @version 1.0
 */
public class MangaParser {
    private MangaDao mangaDao;

    /**
     * Método PardeJSON, que ele vai receber um json e retornar o objeto manga.
     * @param json Json que será analisado
     */
    public static Manga ParseJSON(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
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
