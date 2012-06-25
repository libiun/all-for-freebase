package test.json.simple;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

@SuppressWarnings("unchecked")
public class TestJsonValue {

    public void testMethod1() throws Exception {
        //test method static parse(java.io.Reader in):Object
        //Parse JSON text into java object from the input source

        Reader reader = new InputStreamReader(new FileInputStream("resource/jsonArray.txt"));
        JSONArray jsonArray = (JSONArray) JSONValue.parse(reader);
        TestTemp.printItemList(jsonArray);
    }

    public void testMethod2() {
        //test method static parser(String):Object
        JSONArray jSONArray = (JSONArray) JSONValue.parse("[5,]");
        System.out.println(jSONArray);

        JSONObject jsonObject = (JSONObject) JSONValue.parse("{}");
        System.out.println(jsonObject);
    }

    public void testMethod3() {
        //JSONValue提供的toJSonString writeJSonString
        JSONObject obj = new JSONObject();
        obj.put("key1", "value1");
        obj.put("key2", "value2");
        obj.put("key3", "value3");
        obj.put("key4", "value4");
        System.out.println(JSONValue.toJSONString(obj));
        try {
            Writer w = new OutputStreamWriter(new FileOutputStream("resource/jsonValue.txt"));
            JSONValue.writeJSONString(obj, w);
            w.close();
        } catch (IOException ex) {
            Logger.getLogger(TestJsonValue.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("success to file of jsonvalue.txt");
    }

    public static void main(String[] args) throws Exception {
        TestJsonValue test = new TestJsonValue();
        test.testMethod3();
    }
}
