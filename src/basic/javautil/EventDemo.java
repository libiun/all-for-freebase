package basic.javautil;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

public class EventDemo extends JFrame {

    private JButton btnOk;
    private JDialog dialog;

    /**
     * 每发生一个事件，程序都需要做出响应，称为事件处理，事件处理涉及3个对象：事件源、事件、监听器
     * 事件源都不处理自己的事件，而是将事件处理委托给外部的处理实体（监听器），这种事件处理模型称为委派式（Delegation）
     * 所有的组件都从Component类继承了将事件处理委派给监听器的方法。
     * addXXXListener(ListenerType listener):给摸个需要处理某种事件的组件注册监听器；
     * removeXXXListener(ListenerType listener):删除组件注册的摸个监听器。
     */

    /**
     * 事件适配器与监听器，适配器是类
     * ComponentListener   ComponentAdapter
     * ContainerListener    ContainerAdapter
     * FocusListener    FocusAdapter
     * KeyListener  KeyAdapter
     * MouseListener    MouseAdapter
     * MouseMotionListener  MouseMotionAdapter
     * WindowListener   WindowAdapter
     */

    /**
     * 监听事件的实现形式有5种
     * 匿名内部类形式：在程序主类中，嵌入匿名内部类创见事件监听器对象，应用最广泛
     * 类本身实现监听器形式：程序主类实现监听器接口，此时类本身就是监听器对象
     * 类本身继承适配类形式：程序主类继承适配器类，此时类本身就是监听器对象
     * 内部类：专门定义一个监听器类，并且嵌入到程序主类中。
     * 外部类：专门定义一个监听器类，并且本身以外部类的形式独立存在。     *
     */
    public EventDemo() {
        super("Java事件处理例子");
        //无模式对话框与有模式对话框不同的是在创建后其他窗口都可以继续接收用户输入，因此无模式对话框有些类似一个弹出窗口
        dialog = new JDialog(this, "对话框", true);
        btnOk = new JButton("与我对话");
        btnOk.addActionListener(new MyListener());

        JLabel lb = new JLabel("Java事件处理实例。");
        dialog.add(lb);
        dialog.setBounds(580, 300, 150, 50);
        this.setLayout(new FlowLayout());
        this.add(btnOk);
        this.setVisible(true);
        this.setBounds(500, 200, 300, 200);
    }

    /*
     * 内部类，定义一个监听器类，处理事件
     */
    class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //e.getActionCommand() 返回与此动作相关的命令字符串。获取组件的标签名称
            //e.getSourec获取组件的名称，就是定义的变量
            dialog.setVisible(true);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new EventDemo();
    }
}
