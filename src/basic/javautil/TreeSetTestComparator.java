package basic.javautil;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

//策略模式（strategy pattern）
//通过comparator改变treeset的顺序
public class TreeSetTestComparator {

    public static void main(String[] args) {
        /**
        TreeSet<String> set = new TreeSet<String>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("e");
        System.out.println(set);//实现了sortedSet接口，按自然顺序排序
         */
        TreeSet<Person> set = new TreeSet<Person>(new MyComparator());
        Person p1 = new Person(10);
        Person p2 = new Person(20);
        Person p3 = new Person(30);
        Person p4 = new Person(40);

        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);

        //System.out.println(set);
        for (Iterator<Person> iter = set.iterator(); iter.hasNext();) {
            //next()返回了Person对象
            Person p = iter.next();
            System.out.println(p.getScore());
        }
    }
}

class Person {

    int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Person(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.valueOf(this.score);
    }
}

class MyComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        //return p1.getScore() - p2.getScore(); //按socre从小到大的顺序
        return p2.getScore() - p1.getScore(); //按socre从大到小的顺序

    }
}
