package test.json.simple;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import org.json.simple.JSONArray;

/**
 * @author libiun
 * JSONArray extends ArrayList, implement 3 interfaces
 * so the operation in JSONArray is just about ArrayList
 * 
 * java.lang.Object
 * java.util.AbstractCollection<E>
 *    java.util.AbstractList<E>
 *         java.util.ArrayList
 *             org.json.simple.JSONArray
 *
 */
@SuppressWarnings("unchecked")
public class TestJsonArray {

    public void testMethod1() throws InterruptedException {
        //像操作ArrayList那样操作JSONArray
        //字符串
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("hello");
        jsonArray.add("you");
        jsonArray.add("fucker");

        //toJSONString():String
        System.out.println(jsonArray.toJSONString());
        TestTemp.printItemList(jsonArray);

        //ArrrayList的元素类型可以多种多样，放入对象也可以
        JSONArray jsonArray2 = new JSONArray();
        jsonArray2.add(new Date());
        Thread.sleep(2000);
        jsonArray2.add(new Date());
        jsonArray2.add(new Date());
        jsonArray2.add(new Date());
        TestTemp.printItemList(jsonArray2);
    }

    public void testMethod2() {
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("hello");
        jsonArray.add("you");
        jsonArray.add("fucker");
        jsonArray.add("中国人");
        
        //把jsonArray对象保存到json.txt中
        try {
            //writeJSONWrite(java.io.Writer out):void
            //把json输出到io中
            Writer fw = new OutputStreamWriter(new FileOutputStream("resource/jsonArray.txt"));
            jsonArray.writeJSONString(fw);
            fw.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("保存成功。");
    }

    public static void main(String[] args) throws InterruptedException {
        TestJsonArray t = new TestJsonArray();
        //t.testMethod1();
        t.testMethod2();
    }
}
