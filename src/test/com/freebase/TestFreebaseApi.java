package test.com.freebase;

import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import com.freebase.api.Freebase;
import com.freebase.json.JSON;
import static com.freebase.json.JSON.a;
import static com.freebase.json.JSON.o;

public class TestFreebaseApi {
    
    public static void testMqlread(){
            JSON query = o("id", null,
                "type", "/film/film",
                "name", "The Shawshank Redemption",
                "directed_by", a(o("id", null, "name", null)));
        System.out.println(query);
        Freebase freebase = Freebase.getFreebase();
        JSON queryResult = freebase.mqlread(query);
        System.out.println(queryResult.isArray());
        System.out.println(queryResult.isObject());

        /**
         *{"result":
         * {
         *      "id":"\/en\/blade_runner",
         *      "directed_by":[{"id":"\/en\/ridley_scott","name":"Ridley Scott"}],
         *      "name":"Blade Runner",
         *      "type":"\/film\/film"
         * },
         * "status":"200 OK",
         * "code":"\/api\/status\/ok",
         * "transaction_id":"cache;cache02.p01.sjc1:8101;2011-11-16T15:09:24Z;0030"}
         */
        //输出整个结果map
        Map map = queryResult.object();
        Set keySet = map.keySet();
        for (Iterator iter = keySet.iterator(); iter.hasNext();) {
            Object key = iter.next();
            System.out.print(key + ":" + map.get(key));
            System.out.println();
        }

        System.out.println("---------------");
        //单独处理freebase返回中我关心的部分:Blade Runner这部电影的导演是谁？
         System.out.println("电影Blade Runner的导演是:"+queryResult.get("result").get("directed_by").get(0).get("name").string());
        
    }

    public static void testSearch(){
        Freebase freebase=Freebase.getFreebase();
        String queryString="michael jackson";
        JSON result=freebase.search(queryString);
        System.out.println(result);
                
    }
    public static void main(String[] args) {
        testSearch();
    }
}
