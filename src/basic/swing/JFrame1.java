package basic.swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class JFrame1 implements ActionListener {

    public JFrame1() {
        JFrame frame = new JFrame("JFrameDemo");
        Container container = frame.getContentPane();
        JButton jbutton = new JButton("click me to get a new window");
        jbutton.addActionListener(this);
        container.add(jbutton);
        frame.pack();
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame j=new JFrame("this is a new frame");
        j.setSize(200,200);
        j.setVisible(true);
    }
    
    public static void main(String[] args) {
        new JFrame1();
    }
}
