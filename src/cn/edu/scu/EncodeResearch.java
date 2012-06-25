package cn.edu.scu;

import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

@SuppressWarnings("unchecked")
public class EncodeResearch {

    public void method1() {
        //encode a json object
        //JSONObject extends java.util.HashMap
        JSONObject obj = new JSONObject();
        obj.put("name", "foo");
        obj.put("num", new Integer(100));
        obj.put("balance", new Double(1000.21));
        obj.put("is_vip", true);
        obj.put("nickname", "method 1");
        System.out.print(obj);
    }

    public void method2() {
        try {
            //encode a json object
            //streaming
            JSONObject obj = new JSONObject();
            obj.put("name", "foo");
            obj.put("num", new Integer(100));
            obj.put("balance", new Double(1000.21));
            obj.put("is_vip", true);
            obj.put("nickname", "method 2");
            StringWriter out = new StringWriter();
            //obj.writeJSONString(out);
            JSONObject.writeJSONString(obj, out);
            System.out.println(out.toString());
        } catch (IOException ex) {
            Logger.getLogger(EncodeResearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        EncodeResearch er = new EncodeResearch();
        er.method2();
    }
}
