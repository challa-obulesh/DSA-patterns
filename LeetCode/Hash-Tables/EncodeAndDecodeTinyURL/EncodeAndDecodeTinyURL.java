import java.util.HashMap;

public class Solution {

    private HashMap<Integer, String> map = new HashMap<>();
    private int id = 0;

    public String encode(String longUrl) {
        map.put(id, longUrl);
        String shortUrl = "http://tinyurl.com/" + id;
        id++;
        return shortUrl;
    }

    public String decode(String shortUrl) {
        int id = Integer.parseInt(
            shortUrl.replace("http://tinyurl.com/", "")
        );

        return map.get(id);
    }
}
