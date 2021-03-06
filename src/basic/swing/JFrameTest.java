/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JFrameTest.java
 *
 * Created on 2011-10-26, 12:15:07
 */
package basic.swing;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Administrator
 */
public class JFrameTest extends javax.swing.JFrame {

    /** Creates new form JFrameTest */
    public JFrameTest() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jScrollPane1 = new JScrollPane();
        jListSize = new JList();
        jLabelMessage = new JLabel();
        jCheckBoxSize = new JCheckBox();
        jCheckBoxTop = new JCheckBox();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jListSize.setModel(new AbstractListModel() {
            String[] strings = { "300*200", "400*300", "650*400", "800*600" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListSize.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                jListSizeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListSize);

        jCheckBoxSize.setText("可以更改大小");
        jCheckBoxSize.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                jCheckBoxSizeItemStateChanged(evt);
            }
        });

        jCheckBoxTop.setText("总在最前");
        jCheckBoxTop.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                jCheckBoxTopItemStateChanged(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jCheckBoxSize)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxTop))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabelMessage, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabelMessage)
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(jCheckBoxSize)
                            .addComponent(jCheckBoxTop))))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents

    private void jCheckBoxSizeItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_jCheckBoxSizeItemStateChanged
        if (this.jCheckBoxSize.isSelected()) {
            this.setResizable(true);
            this.jListSize.setEnabled(true);
            this.jLabelMessage.setText("当前窗口可以改变大小");
        } else {
            this.setResizable(false);
            this.jListSize.setEnabled(false);
            this.jLabelMessage.setText("当前窗口不可以改变大小");
        }
    }//GEN-LAST:event_jCheckBoxSizeItemStateChanged

    private void jCheckBoxTopItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTopItemStateChanged
        if (this.jCheckBoxTop.isSelected()) {
            this.setAlwaysOnTop(true);
        } else {
            this.setAlwaysOnTop(false);
        }
    }//GEN-LAST:event_jCheckBoxTopItemStateChanged

    private void jListSizeValueChanged(ListSelectionEvent evt) {//GEN-FIRST:event_jListSizeValueChanged
        int i = this.jListSize.getSelectedIndex();
        switch (i) {
            case 0:
                this.setSize(300, 200);
                this.jLabelMessage.setText("当前大小为：" + this.getSize().getWidth()+"*"+this.getSize().getHeight());
                break;
            case 1:
                this.setSize(400, 300);
                this.jLabelMessage.setText("当前大小为：" + this.getSize());
                break;
            case 2:
                this.setSize(650, 400);
                this.jLabelMessage.setText("当前大小为：" + this.getSize());
                break;
            case 3:
                this.setSize(800, 600);
                this.jLabelMessage.setText("当前大小为：" + this.getSize());
                break;
        }
    }//GEN-LAST:event_jListSizeValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new JFrameTest().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    JCheckBox jCheckBoxSize;
    JCheckBox jCheckBoxTop;
    JLabel jLabelMessage;
    JList jListSize;
    JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
