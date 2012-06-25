package design.patterns.strategy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DownNameSort implements SortInterface, Comparator<Person> {

    @Override
    public void sort(List<Person> list) {
        Collections.sort(list, this);
    }

    @Override
    public int compare(Person o1, Person o2) {
        int result = o2.getName().compareTo(o1.getName());
        if (0 == result) {
            //名称相等按id的顺序排
            return o1.getId() - o2.getId();
        }
        return result;
    }
}
