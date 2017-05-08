import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Created by Administrator on 2017/5/8 0008.
 */
public class GetPlaceByIp {
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
            // System.out.println("同时 从这里也能看出 即便return了，仍然会执行finally的！");
        }
    }
    public static void main(String[] args) throws IOException, JSONException {
        //这里调用百度的ip定位api服务 详见 http://api.map.baidu.com/lbsapi/cloud/ip-location-api.htm
        JSONObject json = readJsonFromUrl("http://api.map.baidu.com/location/ip?" +
                "ak=F454f8a5efe5e577997931cc01de3974&ip=101.226.33.217");
        JSONObject json2 = readJsonFromUrl("http://api.map.baidu.com/place/v2/search?" +
                "query=学校&page_size=10&page_num=0&scope=2&region=北京&output=json&ak=F454f8a5efe5e577997931cc01de3974");
        System.out.println(json2.toString());
//        System.out.println(((JSONObject) json.get("content")).get("address"));
    }
}
