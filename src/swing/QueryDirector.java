package swing;

import com.freebase.api.Freebase;
import com.freebase.json.JSON;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import org.json.simple.JSONArray;
import static com.freebase.json.JSON.a;
import static com.freebase.json.JSON.o;

public class QueryDirector extends javax.swing.JPanel implements Runnable {

    private Freebase freebase;
    private JSON query;
    private JSON queryResult;
    private JSON result;
    private Thread thread;

    public QueryDirector() {
        initComponents();
        //getRootPane().setDefaultButton(jButtonQuery);
        thread = new Thread(this);
        jTextFieldProgress.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jLabel1 = new JLabel();
        jTextFieldNameOfMovie = new JTextField();
        jButtonQuery = new JButton();
        jButtonBoss = new JButton();
        jScrollPane1 = new JScrollPane();
        jTextAreaResult = new JTextArea();
        jTextFieldProgress = new JTextField();

        setPreferredSize(new Dimension(568, 425));

        jLabel1.setText("请输入电影名字：");

        jButtonQuery.setText("Query");
        jButtonQuery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonQueryActionPerformed(evt);
            }
        });

        jButtonBoss.setText("清空");
        jButtonBoss.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonBossActionPerformed(evt);
            }
        });

        jTextAreaResult.setColumns(20);
        jTextAreaResult.setRows(5);
        jScrollPane1.setViewportView(jTextAreaResult);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNameOfMovie, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jButtonQuery)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jButtonBoss)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldProgress, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNameOfMovie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBoss)
                    .addComponent(jButtonQuery))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jTextFieldProgress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
            //JOptionPane.showMessageDialog(this, "查询中，请稍等。。。", "提示", JOptionPane.WARNING_MESSAGE);
            jTextFieldProgress.setText("querying, please wait......");
        }
    }//GEN-LAST:event_jButtonQueryActionPerformed

    private void jButtonBossActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonBossActionPerformed
        jTextAreaResult.setText("");
    }//GEN-LAST:event_jButtonBossActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public JButton jButtonBoss;
    public JButton jButtonQuery;
    public JLabel jLabel1;
    public JScrollPane jScrollPane1;
    public JTextArea jTextAreaResult;
    public JTextField jTextFieldNameOfMovie;
    public JTextField jTextFieldProgress;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        //The Shawshank Redemption
        //puss in boots
        String strNameOfMovie = this.jTextFieldNameOfMovie.getText().trim();
        //处理没有输入电影名字的情况
        if ("".equals(strNameOfMovie)) {
            JOptionPane.showMessageDialog(this, "电影名不能为空", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }

        query = a(o("id", null,
                "type", "/film/film",
                "name", strNameOfMovie,
                "directed_by", a(o("id", null, "name", null))));
        freebase = Freebase.getFreebase();
        queryResult = freebase.mqlread(query);
        //构造freebase查询json官方推荐使用数组,所以返回json中result对应的值就会是数组
        //下面这个语句的result是一个List形式
        result = queryResult.get("result");

        //result的三种情况：
        //1。 无结果 []
        //2.  有一个结果 [{}]
        //3.  多个结果返回 [{} ,{}, {}]

        //判断第一种情况，无结果返回
        if (0 == result.array().size()) {
            //查询的结果为[],获取数组的元素列表list,其个数为空则无数据
            JOptionPane.showMessageDialog(this, "对不起，没有查到此电影", "提示", JOptionPane.WARNING_MESSAGE);
            jTextFieldProgress.setText("");
            return;
        }

        //如果有结果返回
        //获取里面的单个元素
        JSONArray list = (JSONArray) result.array();
        //ArrayList list=(ArrayList)result.array();
        jTextAreaResult.append("there are " + list.size() + " movie named【" + strNameOfMovie + "】:\n");
        for (Iterator it = list.iterator(); it.hasNext();) {
            JSON obj = (JSON) it.next();
            //System.out.println(obj.get("directed_by").get(0).get("name").string());
            String directorName = obj.get("directed_by").get(0).get("name").string();
            jTextAreaResult.append("-----director is【" + directorName + "】\n");
        }

        jTextFieldProgress.setText("query successful......");
        //现在程序处理了不同的电影有同一个名字的情况，会显示每个电影的导演名字。
        //对于同一个电影可能有多个导演的情况，只能获取第一个导演的名字，由directorName中get(0)决定的。这个还需要再次在内部使用List处理。
    }
}
