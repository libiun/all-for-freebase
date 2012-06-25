package basic.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class JInternalFrame1 extends JFrame implements ActionListener {

    JDesktopPane desktopPane;
    int count;

    public JInternalFrame1() {
        super("JInternalFrame test");
        Container containPane = this.getContentPane();
        containPane.setLayout(new BorderLayout());

        JButton b = new JButton("create new internal frames");
        b.addActionListener(this);
        containPane.add(b, BorderLayout.SOUTH);

        desktopPane = new JDesktopPane();
        containPane.add(desktopPane);

        setSize(350, 350);
        setVisible(true);

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JInternalFrame internalFrame = new JInternalFrame("Internal Frame" + (count++), true, true, true, true);
        internalFrame.setLocation(20, 20);
        internalFrame.setSize(200, 200);
        internalFrame.setVisible(true);

        Container icontentPane = internalFrame.getContentPane();
        JTextArea textArea = new JTextArea();
        JButton b = new JButton("internal frame button");

        icontentPane.add(textArea, "Center");
        icontentPane.add(b, "South");
        desktopPane.add(internalFrame);

        try {
            internalFrame.setSelected(true);
        } catch (java.beans.PropertyVetoException ex) {
            System.out.println("Exception while selecting");
        }
    }

    public static void main(String[] args) {
        new JInternalFrame1();
    }
}
