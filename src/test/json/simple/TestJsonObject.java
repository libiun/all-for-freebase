package test.json.simple;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.simple.JSONObject;

/**
 * @author Administrator
 *
 * JSONObject 继承了HashMap类
 */
//java.lang.Object
//  java.util.AbstractMap<K,V>
//      java.util.HashMap
//          org.json.simple.JSONObject
@SuppressWarnings("unchecked")
public class TestJsonObject {

    public void testMethod1() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key1", "value1");
        jsonObject.put("key2", "value2");
        jsonObject.put("key3", "value3");
        jsonObject.put("key4", "value4");
        jsonObject.put("key5", "value5");

        Map map = new HashMap();
        map.put("key6", "value6");
        map.put("key7", "val\rue7");

        jsonObject.putAll(map);  //对象构造完成
        System.out.println(jsonObject.toJSONString());

        //获取Key的集合，然后迭代
        Set set = jsonObject.keySet();
        for (Iterator<String> iter = set.iterator(); iter.hasNext();) {
            String key = iter.next();
            System.out.println(key + "->" + jsonObject.get(key));
        }

        System.out.println("---------------------");

        //使用Map.entry迭代
        Set set1=jsonObject.entrySet();
        for(Iterator<Map.Entry<String,String>> iter=set1.iterator();iter.hasNext();){
            Map.Entry<String,String> entry=iter.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }
    
    public void testMethod2() throws Exception{
        //把jsonObject 写入jsonObject.txt
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key1", "value1");
        jsonObject.put("key2", "value2");
        jsonObject.put("key3", "value3");
        jsonObject.put("key4", "value4");
        jsonObject.put("key5", "value5");

        Map map = new HashMap();
        map.put("key6", "value6");
        map.put("key7", "val\rue7");

        jsonObject.putAll(map);  //对象构造完成

        Writer wr=new OutputStreamWriter(new FileOutputStream("resource/jsonObject.txt"));
        jsonObject.writeJSONString(wr);
        wr.close();
        
    }

    public static void main(String[] args) throws Exception {
        TestJsonObject test = new TestJsonObject();
        test.testMethod1();
        test.testMethod2();
    }
}
