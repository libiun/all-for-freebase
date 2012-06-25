package basic.innerclass;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("click me");
        //button.addActionListener(new MyListener());
        button.addActionListener(new ActionListener() {
            //实现了interface ActionListener的匿名内部类

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button: click me be clicked!");
            }
        });

        frame.setSize(new Dimension(200, 200));
        frame.getContentPane().add(button);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("the window closed");
            }
        });

        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class MyListener implements ActionListener {
//    no usage，通过内部类实现了。
//    按钮的监听器

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button: click me be clicked!");
    }
}