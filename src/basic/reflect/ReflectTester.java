package basic.reflect;
//运用反射的较完整例子
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTester {

    public Object copy(Object object) throws Exception {
        //获取类类型的第三种方法，Class.forName("java.lang.String")+String.class()
        Class<?> classType = object.getClass();
        //object.getName()获取类名称
        //System.out.println(classType.getName());
        //生成实例时，class的newinstance不能有参数
        //这就需要Constructor的newinstance方法
        //Constructor cons = classType.getConstructor(new Class[]{String.class, int.class});
        //Object obj = cons.newInstance(new Object[]{"liyuan", 23});
        //以上两行代码等价于以下一行,因为customer的构造方法无参数才能这样
        //Object obj2=classType.newInstance();
        //总结：若想通过类的不带参数的构造方法来生成对象，有两种方法：1获取class对象，用其newInstance()方法
        //2.先获得class对象，然后通过该对象获取constructor对象，再通过constructor对象的newInstance方法生成

        //使用constructor方法，可操作带参数和不带参数构造函数
        //最后这个是个很聪明的处理办法，不指定具体的参数类型，直接用抽象的父类代替
        Object objectCopy = classType.getConstructor(new Class[]{}).newInstance(new Object[]{});
        //获取对象所有的成员变量
        Field[] fields = classType.getDeclaredFields();
        for (Field field : fields) {
            //System.out.println(field);
            String name = field.getName();
            String firstLetter = name.substring(0, 1).toUpperCase(); //区间都是包含左边不包含右边
            String getMethodName = "get" + firstLetter + name.substring(1);//一个参数从第一个取到最后
            String setMethodName = "set" + firstLetter + name.substring(1);
            System.out.println(getMethodName + " " + setMethodName);

            Method getMethod = classType.getMethod(getMethodName, new Class[]{});
            Method setMethod = classType.getMethod(setMethodName, new Class[]{field.getType()});

            Object value = getMethod.invoke(object, new Object[]{});
            setMethod.invoke(objectCopy, new Object[]{value});

        }
        //System.out.println(obj);
        return objectCopy;
    }

    public static void main(String[] args) throws Exception {
        Customer customer=new Customer("lijun", 56);
        customer.setId(1L); //new Long(1)

        ReflectTester test = new ReflectTester();
        Customer customer2=(Customer)test.copy(customer);
        System.out.println(customer2.getId()+customer2.getName()+customer.getAge());
    }
}

class Customer {

    private Long id;
    private String name;
    private int age;

    public Customer() {
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
