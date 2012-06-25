/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package design.patterns.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author libiun
 */
public class Client {

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("a_lijun");
        p1.setAge(20);
        p1.setId(1);

        Person p2 = new Person();
        p2.setName("b_lijun");
        p2.setAge(320);
        p2.setId(2);

        Person p3 = new Person();
        p3.setName("c_lijun");
        p3.setAge(231);
        p3.setId(3);


        Person p4 = new Person();
        p4.setName("d_lijun");
        p4.setAge(98);
        p4.setId(4);

        List<Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        Environment env = new Environment();

        //name的升序
        UpNameSort uns = new UpNameSort();
        env.setSortInterface(uns);
        env.Sort(list);
        for (int i = 0; i < list.size(); i++) {
            Person p = list.get(i);
            System.out.println("id:" + p.getId() + ",name:" + p.getName() + ",age:" + p.getAge());
        }

        System.out.println("-----------");
        //name的降序
        DownNameSort dns = new DownNameSort();
        env.setSortInterface(dns);
        env.Sort(list);
        for (int i = 0; i < list.size(); i++) {
            Person p = list.get(i);
            System.out.println("id:" + p.getId() + ",name:" + p.getName() + ",age:" + p.getAge());
        }
    }
}
