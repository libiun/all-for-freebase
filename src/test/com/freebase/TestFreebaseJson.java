package test.com.freebase;

import java.util.Set;
import java.util.ArrayList;
import com.freebase.json.JSON;
import java.util.HashMap;
import java.util.Iterator;
import static com.freebase.json.JSON.a;
import static com.freebase.json.JSON.o;

public class TestFreebaseJson {

    public static void getJSONTypeValues() {
        for (JSON.Type value : JSON.Type.values()) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
       
        //构造array
        JSON jsonArray=a("a","b","c");
        System.out.println(jsonArray.toString());
        ArrayList list=(ArrayList)jsonArray.array();
        for (Iterator iter=list.iterator();iter.hasNext();) {
            System.out.print(iter.next()+ " ");
        }
        
        System.out.println();
        System.out.println("------------");
        
        //构造object
        JSON jsonObject=o("lijun",1,"liyuan",2);
        System.out.println(jsonObject.toString());
        HashMap map=(HashMap)jsonObject.object();
        Set set=map.keySet();
        for(Iterator iter=set.iterator();iter.hasNext();){
            Object key=iter.next();
            System.out.println(key+":"+map.get(key));
        }
        
        //对象与数组的复合
        System.out.println("-----------");
        JSON json = a(o("a",1,"b",true,"c",null,"d",o("a1",a("love","me"))));
        System.out.println(json.toString());
        
        //[] {} 为空的时候打印其内部元素个数
        JSON objArray=a(o(),o());
        JSON objObject=o();
        System.out.println(objArray+" "+objObject);
        System.out.println(objArray.array().size());
        System.out.println(objObject.object().size());
        
        //[] {} 有元素的时候
        //JSON j1=a("hello","me");
    }
}
