package design.patterns.strategy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UpNameSort implements SortInterface, Comparator<Person> {

    @Override
    public void sort(List<Person> list) {
        //使用Collections静态类排序集合
        Collections.sort(list,this);
    }

    @Override
    public int compare(Person o1, Person o2) {
        int result=o1.getName().compareTo(o2.getName());
        if(0==result){
            //如果名字相等，根据id的升序排
            return o1.getId()-o2.getId();
        }
        //否则根据名字的升序排
        return result;
    }
}
