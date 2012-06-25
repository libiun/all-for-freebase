package swing;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import weka.gui.explorer.AssociationsPanel;
import weka.gui.explorer.AttributeSelectionPanel;
import weka.gui.explorer.ClassifierPanel;
import weka.gui.explorer.Messages;
import weka.gui.explorer.PreprocessPanel;
import weka.gui.explorer.VisualizePanel;

public class FatherFrame extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;

    public FatherFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jTabbedPane1 = new JTabbedPane();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Query Freebase By libiun@gmail.com");
        setLocationByPlatform(true);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
        );

        pack();
    }//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                FatherFrame fatherFrame=new FatherFrame();
                fatherFrame.jTabbedPane1.addTab("查导演", new QueryDirector());
                fatherFrame.jTabbedPane1.addTab("查歌手专辑", new QueryAblum());
                fatherFrame.jTabbedPane1.addTab("AssociationsPanel", new AssociationsPanel());
                fatherFrame.jTabbedPane1.addTab("AttributeSelectionPanel", new AttributeSelectionPanel());
                fatherFrame.jTabbedPane1.addTab("ClassifierPanel", new ClassifierPanel());
                fatherFrame.jTabbedPane1.addTab("PreprocessPanel", new PreprocessPanel());
                fatherFrame.jTabbedPane1.addTab("VisualizePanel", new VisualizePanel());
                fatherFrame.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
