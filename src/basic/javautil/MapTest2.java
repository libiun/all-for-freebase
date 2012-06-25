package basic.javautil;
//Map.Entry内部类
//泛型
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest2 {

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("a", "a_lijun");
        map.put("b", "b_lijun");
        map.put("c", "c_lijun");
        map.put("d", "d_lijun");

        Set<Map.Entry<String,String>> set=map.entrySet();
        for(Iterator<Map.Entry<String,String>> iter=set.iterator();iter.hasNext();){
            Map.Entry<String,String> entry=iter.next();
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }
    }
}
