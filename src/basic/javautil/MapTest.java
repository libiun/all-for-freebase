package basic.javautil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
//遍历map的第一种方式 
public class MapTest {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("a", "a_lijun");
        map.put("b", "b_lijun");
        map.put("c", "c_lijun");
        map.put("d", "d_lijun");

        Set set = map.keySet();
        for (Iterator<String> iter = set.iterator(); iter.hasNext();) {
            String strKey = iter.next();
            System.out.println(strKey + " ->" + map.get(strKey));
        }

    }
}
