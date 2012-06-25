package basic.javaio;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * ObjectInputStream and ObjectOutputStream
 */
class Person implements Serializable {

    String name, major;
    transient int age;
    //transient关键字持久化对象时，age的属性不保存

    public Person(String name, int age, String major) {
        this.age = age;
        this.name = name;
        this.major = major;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", major=" + major + ", age=" + age + '}';
    }
}

public class ObjectInputStreamDemo {

    public void methodWriteObject() {
        //FileDemo.createNewFile("resource/objectstream.txt");
        try {
            FileOutputStream fos = new FileOutputStream("resource/objectstream", true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new Person("lijun", 28, "library science"));
            //oos.writeObject(new Person("liyuan", 29, "library science"));
            //写入两个对象怎么办？
            fos.close();
        } catch (Exception ex) {
            Logger.getLogger(ObjectInputStreamDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void methodReadObject() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("resource/objectstream"));

            //for (int i = 0; i < 2; i++) {
            Person p = (Person) ois.readObject();
            System.out.println(p.toString());
            //如果3此循环会报错，因为只有两个对象存储。一般情况不需要多个对象的存储。
            //  }
            ois.close();
        } catch (Exception ex) {
            Logger.getLogger(ObjectInputStreamDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String a[]) {
        ObjectInputStreamDemo o = new ObjectInputStreamDemo();

        o.methodWriteObject();
        o.methodReadObject();
    }
}
