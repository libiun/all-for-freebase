package basic.swing;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("unchecked")
public class TableModelDemo extends javax.swing.JFrame {

    public TableModelDemo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUseModel = new javax.swing.JTable();
        jButtonAddRow = new javax.swing.JButton();
        jButtonDeleteRow = new javax.swing.JButton();
        jButtonAddColumn = new javax.swing.JButton();
        jButtonDeleteColumn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableUseModel.setModel(this.initialTableModel());
        jTableUseModel.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(jTableUseModel);

        jButtonAddRow.setText("add row");
        jButtonAddRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddRowActionPerformed(evt);
            }
        });

        jButtonDeleteRow.setText("del row");
        jButtonDeleteRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteRowActionPerformed(evt);
            }
        });

        jButtonAddColumn.setText("add column");
        jButtonAddColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddColumnActionPerformed(evt);
            }
        });

        jButtonDeleteColumn.setText("del column");
        jButtonDeleteColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteColumnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jButtonAddRow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeleteRow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAddColumn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeleteColumn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddRow)
                    .addComponent(jButtonDeleteRow)
                    .addComponent(jButtonAddColumn)
                    .addComponent(jButtonDeleteColumn))
                .addContainerGap())
        );

        pack();
    }//GEN-END:initComponents

    private void jButtonAddRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddRowActionPerformed
        DefaultTableModel myModel = (DefaultTableModel) jTableUseModel.getModel(); //获取表格模型
        Vector newRow = new Vector();   //创建新的vector存放今天加行的内容
        int columnNum = myModel.getColumnCount(); //获取表格列数
        for (int i = 0; i < columnNum; i++) {
            newRow.add("");
        }
        //myModel.getDataVector().add(newRow);
        myModel.addRow(newRow);  //与上面的方法作用一样
        ((DefaultTableModel) jTableUseModel.getModel()).fireTableStructureChanged();
    }//GEN-LAST:event_jButtonAddRowActionPerformed

    private void jButtonDeleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteRowActionPerformed
        DefaultTableModel myModel = (DefaultTableModel) jTableUseModel.getModel();
        int rowNum = myModel.getRowCount();
        if (rowNum > 0) {
            myModel.removeRow(rowNum - 1);
        } //删除最后一行
    }//GEN-LAST:event_jButtonDeleteRowActionPerformed

    private void jButtonAddColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddColumnActionPerformed
        DefaultTableModel myModel = (DefaultTableModel) jTableUseModel.getModel();
        int columnCount = myModel.getColumnCount() + 1;
        myModel.addColumn("第" + columnCount + "列");
    }//GEN-LAST:event_jButtonAddColumnActionPerformed

    private void jButtonDeleteColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteColumnActionPerformed
        DefaultTableModel myModel = (DefaultTableModel) jTableUseModel.getModel();
        int columnCount = myModel.getColumnCount() - 1;
        if (columnCount > 0) {
            myModel.setColumnCount(columnCount);
        }
    }//GEN-LAST:event_jButtonDeleteColumnActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TableModelDemo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddColumn;
    private javax.swing.JButton jButtonAddRow;
    private javax.swing.JButton jButtonDeleteColumn;
    private javax.swing.JButton jButtonDeleteRow;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUseModel;
    // End of variables declaration//GEN-END:variables

    private DefaultTableModel initialTableModel() {
        Vector title = new Vector(); //title放标题的内容
        title.add("第一列");
        title.add("第二列");
        title.add("第三列");

        Vector firstRow = new Vector(); //firstRow放第一行的内容
        firstRow.add("11111");
        firstRow.add("11111");
        firstRow.add("11111");

        Vector secondRow = new Vector(); //secondRow放第2行的内容
        secondRow.add("22222");
        secondRow.add("22222");
        secondRow.add("22222");

        Vector thirdRow = new Vector(); //thirdRow放第2行的内容
        thirdRow.add("33333");
        thirdRow.add("33333");
        thirdRow.add("33333");

        Vector content = new Vector();
        content.add(firstRow);
        content.add(secondRow);
        content.add(thirdRow);

        DefaultTableModel defaultTableModel = new DefaultTableModel(content, title);
        return defaultTableModel;
    }
}
