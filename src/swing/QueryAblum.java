package swing;

import java.util.Iterator;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.freebase.api.Freebase;
import com.freebase.json.JSON;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import static com.freebase.json.JSON.a;
import static com.freebase.json.JSON.o;

@SuppressWarnings("unchecked")
public class QueryAblum extends javax.swing.JPanel implements Runnable {

    private Freebase freebase;
    private JSON query;
    private JSON queryResult;
    private JSON result;
    private Thread thread;
    private DefaultTableModel tableMode;

    public QueryAblum() {
        initComponents();
        thread = new Thread(this);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jLabel1 = new JLabel();
        jTextFieldNameOfSinger = new JTextField();
        jComboBox1 = new JComboBox();
        jButtonQuery = new JButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jLabelNumberOfResult = new JLabel();
        jButton1 = new JButton();

        setPreferredSize(new Dimension(568, 425));

        jLabel1.setLabelFor(jTextFieldNameOfSinger);
        jLabel1.setText("歌手名：");

        jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "20", "50", "100", "All" }));

        jButtonQuery.setMnemonic('Q');
        jButtonQuery.setText("Query");
        jButtonQuery.setToolTipText("hello");
        jButtonQuery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonQueryActionPerformed(evt);
            }
        });

        jTable1.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "专辑名", "发布日期"
            }
        ) {
            Class[] types = new Class [] {
                String.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("boss");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNameOfSinger, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jButtonQuery)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jLabelNumberOfResult, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNameOfSinger, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonQuery)
                    .addComponent(jLabelNumberOfResult, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
    }//GEN-END:initComponents

    private void jButtonQueryActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonQueryActionPerformed
        if (!thread.isAlive()) {
            thread = new Thread(this);
        }

        try {
            thread.start();
        } catch (Exception e) {
            jLabelNumberOfResult.setText("querying, please wait......");
        }
    }//GEN-LAST:event_jButtonQueryActionPerformed

    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        for (int i = 0; i < tableMode.getRowCount(); i++) {
            tableMode.removeRow(i);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public JButton jButton1;
    public JButton jButtonQuery;
    public JComboBox jComboBox1;
    public JLabel jLabel1;
    public JLabel jLabelNumberOfResult;
    public JScrollPane jScrollPane1;
    public JTable jTable1;
    public JTextField jTextFieldNameOfSinger;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        String strNameOfSinger = jTextFieldNameOfSinger.getText().trim();
        if ("".equals(strNameOfSinger)) {
            JOptionPane.showMessageDialog(this, "歌手名不能为空", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int comboxSelected = jComboBox1.getSelectedIndex();
        int queryNumber = 20;
        switch (comboxSelected) {
            case 0:
                queryNumber = 20;
                break;
            case 1:
                queryNumber = 50;
                break;
            case 2:
                queryNumber = 100;
                break;
            case 3:
                queryNumber = 500;
                break;
            default:
                queryNumber = 20;
                break;
        }

        query = a(o("type", "/music/artist",
                "name", strNameOfSinger,
                "album", a(o("name", null, "release_date", null, "limit", queryNumber, "sort", "name"))));
        freebase = Freebase.getFreebase();
        queryResult = freebase.mqlread(query);
        result = queryResult.get("result");

//   queryResult        
//         "code":          "/api/status/ok",
//         "result": [{
//             "album": [
//                          {
//                            "name":         "Ben",
//                            "release_date": "1972-08-04"
//                          },
//                          {
//                            "name":         "Music &amp; Me",
//                            "release_date": "1973-04-13"
//                          }
//                      ],
//              "name": "Michael Jackson",
//              "type": "/music/artist"
//                    },{如果有同名歌手，就会有第二个object}],
//        "status": "200 OK",

        //处理无结果返回
        if (0 == result.array().size()) {
            //查询的结果为[],获取数组的元素列表list,其个数为空则无数据
            JOptionPane.showMessageDialog(this, "对不起，没有查到歌手专辑", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //处理结果,这里涉及到查询结果的数组形势，与查导演那个只有一个不同，那里是多个内外部数组，这里要处理内部数组。
        //result=[{},{},{}]
        if (1 < result.array().size()) {
            //查询的结果为[],获取数组的元素列表list,其个数大于一说明有歌手同名
            JOptionPane.showMessageDialog(this, "对不起，系统还没有实现歌手同名情况", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //上面处理掉歌手同名情况，一般不会有歌手同名，所以可以不考虑   
        ArrayList albumArray = (ArrayList) result.get(0).get("album").array();
        //System.out.println(albumArray.size());
        tableMode = (DefaultTableModel) jTable1.getModel();
        for (Iterator it = albumArray.iterator(); it.hasNext();) {
            JSON ob = (JSON) it.next();
            String albumName = ob.get("name").toString().replace("\"", "");
            String releaseDate;
            if (null == ob.get("release_date")) {
                releaseDate = "no release date";
            } else {
                releaseDate = ob.get("release_date").toString().replace("\"", "");
            }

            //System.out.println(albumName+":"+releaseDate);
            Vector rowVector = new Vector();
            rowVector.add(albumName);
            rowVector.add(releaseDate);

            tableMode.addRow(rowVector);
        }
        jTable1.setModel(tableMode);
        jLabelNumberOfResult.setText("Album numbers:" + albumArray.size());
    }
}
