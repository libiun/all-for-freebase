package basic.swing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommonSwingComponentTest extends javax.swing.JFrame {

    public CommonSwingComponentTest() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jCheckBoxHeiti = new javax.swing.JCheckBox();
        jCheckBoxXieti = new javax.swing.JCheckBox();
        jRadioButtonShouxiao = new javax.swing.JRadioButton();
        jRadioButtonPutong = new javax.swing.JRadioButton();
        jRadioButtonJiada = new javax.swing.JRadioButton();
        jLabelMessage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldAddress = new javax.swing.JTextField();
        jButtonGo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPaneHtml = new javax.swing.JEditorPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/basic/swing/images/lijun.jpg"))); // NOI18N

        jButton1.setText("确定");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("取消");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton3.setText("读取文件");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("清空");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBoxHeiti);
        jCheckBoxHeiti.setText("黑体");
        jCheckBoxHeiti.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxHeitiItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jCheckBoxXieti);
        jCheckBoxXieti.setText("斜体");
        jCheckBoxXieti.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxXietiItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButtonShouxiao);
        jRadioButtonShouxiao.setText("缩小");
        jRadioButtonShouxiao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonShouxiaoItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButtonPutong);
        jRadioButtonPutong.setSelected(true);
        jRadioButtonPutong.setText("普通");
        jRadioButtonPutong.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonPutongItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButtonJiada);
        jRadioButtonJiada.setText("加大");
        jRadioButtonJiada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonJiadaItemStateChanged(evt);
            }
        });

        jLabelMessage.setText("JCheckBox 和 JRadioButton");

        jLabel2.setText("地址：");

        jButtonGo.setText("转到");
        jButtonGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoActionPerformed(evt);
            }
        });

        jEditorPaneHtml.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                jEditorPaneHtmlHyperlinkUpdate(evt);
            }
        });
        jScrollPane2.setViewportView(jEditorPaneHtml);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                        .addGap(143, 143, 143)))
                .addGap(91, 91, 91))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jButton4)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jCheckBoxHeiti)
                            .addGap(18, 18, 18)
                            .addComponent(jLabelMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jCheckBoxXieti)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jRadioButtonShouxiao)
                            .addGap(16, 16, 16)
                            .addComponent(jRadioButtonPutong)
                            .addGap(18, 18, 18)
                            .addComponent(jRadioButtonJiada))))
                .addGap(90, 90, 90))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonGo)
                .addGap(120, 120, 120))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxHeiti)
                    .addComponent(jLabelMessage))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxXieti)
                    .addComponent(jRadioButtonPutong)
                    .addComponent(jRadioButtonShouxiao)
                    .addComponent(jRadioButtonJiada))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextField1.setText("你点击了确认按钮");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextField1.setText("你点击了取消按钮");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        File f = new File("resource/helloto.txt");
        try {
            FileReader fis = new FileReader(f);
            BufferedReader br = new BufferedReader(fis);
            int i = 0;
            String b;
            while ((b = br.readLine()) != null) {
                jTextArea1.append((String) b);
                jTextArea1.append("\n");
            }
        } catch (Exception ex) {
            Logger.getLogger(CommonSwingComponentTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTextArea1.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jCheckBoxHeitiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxHeitiItemStateChanged
        if (this.jCheckBoxXieti.isSelected()) {
            this.setStyle(java.awt.Font.BOLD);
        } else {
            this.setStyle(-java.awt.Font.BOLD);
        }
        this.setLabelFont();
    }//GEN-LAST:event_jCheckBoxHeitiItemStateChanged

    private void jCheckBoxXietiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxXietiItemStateChanged
        if (this.jCheckBoxXieti.isSelected()) {
            this.setStyle(java.awt.Font.ITALIC);
        } else {
            this.setStyle(-java.awt.Font.ITALIC);
        }
        this.setLabelFont();
    }//GEN-LAST:event_jCheckBoxXietiItemStateChanged

    private void jRadioButtonShouxiaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonShouxiaoItemStateChanged
        this.setFontSize(14);
        this.setLabelFont();
    }//GEN-LAST:event_jRadioButtonShouxiaoItemStateChanged

    private void jRadioButtonPutongItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonPutongItemStateChanged
        this.setFontSize(18);
        this.setLabelFont();
    }//GEN-LAST:event_jRadioButtonPutongItemStateChanged

    private void jRadioButtonJiadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonJiadaItemStateChanged
        this.setFontSize(22);
        this.setLabelFont();
    }//GEN-LAST:event_jRadioButtonJiadaItemStateChanged

    private void jEditorPaneHtmlHyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_jEditorPaneHtmlHyperlinkUpdate
        try {
            if (evt.getEventType() == javax.swing.event.HyperlinkEvent.EventType.ACTIVATED) {
                jEditorPaneHtml.setPage(evt.getURL());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jEditorPaneHtmlHyperlinkUpdate

    private void jButtonGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoActionPerformed
        String myurl = this.jTextFieldAddress.getText().trim();
        try {
            if (myurl != null && !myurl.equals("")) {
                jEditorPaneHtml.setPage(myurl);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButtonGoActionPerformed

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
            java.util.logging.Logger.getLogger(CommonSwingComponentTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CommonSwingComponentTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CommonSwingComponentTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CommonSwingComponentTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CommonSwingComponentTest().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JMenuItem aboutMenuItem;
    javax.swing.ButtonGroup buttonGroup1;
    javax.swing.JMenuItem contentsMenuItem;
    javax.swing.JMenuItem copyMenuItem;
    javax.swing.JMenuItem cutMenuItem;
    javax.swing.JMenuItem deleteMenuItem;
    javax.swing.JMenu editMenu;
    javax.swing.JMenuItem exitMenuItem;
    javax.swing.JMenu fileMenu;
    javax.swing.JMenu helpMenu;
    javax.swing.JButton jButton1;
    javax.swing.JButton jButton2;
    javax.swing.JButton jButton3;
    javax.swing.JButton jButton4;
    javax.swing.JButton jButtonGo;
    javax.swing.JCheckBox jCheckBoxHeiti;
    javax.swing.JCheckBox jCheckBoxXieti;
    javax.swing.JEditorPane jEditorPaneHtml;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabelMessage;
    javax.swing.JRadioButton jRadioButtonJiada;
    javax.swing.JRadioButton jRadioButtonPutong;
    javax.swing.JRadioButton jRadioButtonShouxiao;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JTextArea jTextArea1;
    javax.swing.JTextField jTextField1;
    javax.swing.JTextField jTextFieldAddress;
    javax.swing.JMenuBar menuBar;
    javax.swing.JMenuItem openMenuItem;
    javax.swing.JMenuItem pasteMenuItem;
    javax.swing.JMenuItem saveAsMenuItem;
    javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables
    private int style = java.awt.Font.PLAIN;
    private int fontSize = 18;

    private void setStyle(int style) {
        this.style = this.style + style;
    }

    /**
     * @return the style
     */
    public int getStyle() {
        return this.style;
    }

    /**
     * @return the fontSize
     */
    public int getFontSize() {
        return fontSize;
    }

    /**
     * @param fontSize the fontSize to set
     */
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    private void setLabelFont() {
        this.jLabelMessage.setFont(new java.awt.Font("宋体", this.getStyle(), this.getFontSize()));
    }
}
