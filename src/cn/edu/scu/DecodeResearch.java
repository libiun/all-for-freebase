package cn.edu.scu;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.*;
import org.json.simple.*;

@SuppressWarnings("unchecked")
public class DecodeResearch {

    public void UseJSONValueStaticMethod(String str) {
        //it's a convenient way:use jsonvalue
        //String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
        String s = str;
        Object obj = JSONValue.parse(s);
        JSONArray array = (JSONArray) obj;
        System.out.println("输出数组的两个元素：");
        System.out.println(array.get(0));
        System.out.println(array.get(1));

        JSONObject obj2 = (JSONObject) array.get(1);
        System.out.println("输出第二个数组元素：jsonobject的元素,需要用key来获取：”");
        System.out.println(obj2.get("1"));

        s = "{\"a\":23}";
        obj = JSONValue.parse(s);
        System.out.println(obj.toString());

        s = "[5,0]";
        obj = JSONValue.parse(s);
        System.out.println(obj);
    }

    public void UseInstanceOfJSONParser(String str) {
        try {
            //Faster way: Reuse instance of JSONParser
            //String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
            String s = str;
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(s);
            JSONArray array = (JSONArray) obj;
            System.out.println(array.get(0));
        } catch (ParseException ex) {
            Logger.getLogger(DecodeResearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ImplyContainerFactoryInterface(String str) {
        String jsonText = str;
        //String jsonText = "{\"first\": 123, \"second\": [4, 5, 6], \"third\": 789}";
        JSONParser parser = new JSONParser();
        ContainerFactory containerFactory = new ContainerFactory() {
            //匿名类
            @Override
            public Map createObjectContainer() {
                return new LinkedHashMap();
            }

            @Override
            public List creatArrayContainer() {
                return new LinkedList();
            }
        };
        try {
            //java.lang.Object parse(java.lang.String s, ContainerFactory containerFactory)
            Map json = (Map) parser.parse(jsonText, containerFactory);
            Iterator iter = json.entrySet().iterator();
            System.out.println("iterate results");
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                System.out.println(entry.getKey() + "=>" + entry.getValue());
            }

            System.out.println("===toJSONString()===");
            System.out.println(JSONValue.toJSONString(json));

        } catch (ParseException ex) {
            Logger.getLogger(DecodeResearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void TryFinderClass(String str,String matchKey) {
        // String jsonText = "{\"first\": 123, \"second\": [{\"k1\":{\"id\":\"id1\"}}, 4, 5, 6, {\"id\": 123}], \"third\": 789, \"id\": null}";
        String jsonText = str;
        JSONParser parser = new JSONParser();
        KeyFinder finder = new KeyFinder();
       // finder.setMatchKey("id");
        finder.setMatchKey(matchKey);
        try {
            while (!finder.isEnd()) {
                parser.parse(jsonText, finder, true);
                if (finder.isFound()) {
                    finder.setFound(false);
                    System.out.println(matchKey+" found:");
                    System.out.println(finder.getValue());
                }
            }
        } catch (ParseException pe) {
            System.out.println(pe.getMessage());
        }

    }
    public static void main(String[] args) {
        DecodeResearch d= new DecodeResearch();
        d.UseJSONValueStaticMethod("[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]");
        System.out.println(" --------------- ");
        d.UseInstanceOfJSONParser("[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]");
    }
}
