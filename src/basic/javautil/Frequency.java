package basic.javautil;

import java.util.HashMap;
import java.util.Map;

public class Frequency {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<String,Integer>();
        for(String word:args){
            Integer freq=map.get(word);
            map.put(word, (null==freq)?1:freq+1);//运用到自动装箱
        }
        System.out.println(map);
    }
}
