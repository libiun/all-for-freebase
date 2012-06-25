package test.json.simple;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.ItemList;

//ItemList维护了一个ArrayList,使用ArrayList实现元素的操作
//最有用的方法
//1.用构造函数指定元素ItemList(String)
//2.addAll(String),添加字符串，用默认分隔符截断成各个元素
//3.get(int i):String，获取各个元素
@SuppressWarnings("unchecked")
public class TestItemList {

    public static void printItemList(ItemList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public void testFirstConstructor() {
        ItemList itemList = new ItemList();
        itemList.add("a");
        itemList.add("b");

        ItemList itemList2 = new ItemList();
        itemList2.add("c");
        itemList2.add("d");
        itemList2.addAll(itemList);

        printItemList(itemList2);

    }

    public void testSecondConstructor() {
        //create a ItemList
        ItemList list = new ItemList("hello,you,li,jun"); //指定分隔符
        list.addAll("a,b,c,d");
        
        //test method: getItems():java.util.List
        ArrayList<String> array=(ArrayList<String>)list.getItems();
        for(Iterator<String> iter=array.iterator();iter.hasNext();){
            System.out.print(iter.next()+" ");
        }
        
        //test method: getArray():java.lang.String[],this method throw a exception
        //object can't cast to string
 
    }

    public static void main(String[] args) {
        TestItemList test = new TestItemList();
        System.out.println("method one:--------");
        test.testFirstConstructor();
        System.out.println("method two:-------");
        test.testSecondConstructor();
    }
}
