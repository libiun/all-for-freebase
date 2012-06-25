package basic.net;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;

public class GetHttp extends javax.swing.JFrame implements Runnable {

    URL url;
    InputStream is;
    Thread thread;
    BufferedReader br;
    String line;

    public GetHttp() {
        initComponents();
        thread = new Thread(this);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jLabelAddress = new JLabel();
        jTextFieldAddress = new JTextField();
        jButtonGetContent = new JButton();
        jScrollPane1 = new JScrollPane();
        jTextAreaContent = new JTextArea();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabelAddress.setText("网址：");

        jButtonGetContent.setText("确定");
        jButtonGetContent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonGetContentActionPerformed(evt);
            }
        });

        jTextAreaContent.setColumns(20);
        jTextAreaContent.setRows(5);
        jScrollPane1.setViewportView(jTextAreaContent);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelAddress)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAddress, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jButtonGetContent)
                        .addGap(13, 13, 13))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabelAddress)
                    .addComponent(jTextFieldAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGetContent))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }//GEN-END:initComponents

    private void jButtonGetContentActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonGetContentActionPerformed
        if (!(thread.isAlive())) {
            thread = new Thread(this);
        }

        try {
            thread.start();
        } catch (IllegalThreadStateException ee) {
            //如果线程已启动的异常信息
            JOptionPane.showMessageDialog(this, "正在读取请稍候", "提示信息",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonGetContentActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    JButton jButtonGetContent;
    JLabel jLabelAddress;
    JScrollPane jScrollPane1;
    JTextArea jTextAreaContent;
    JTextField jTextFieldAddress;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            url = new URL(this.jTextFieldAddress.getText().trim());
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));
            while (null != (line = br.readLine())) {
                this.jTextAreaContent.append(line);
                this.jTextAreaContent.append("\n");
            }
        } catch (MalformedURLException ex) {
            //抛出这一异常指示出现了错误的 URL。或者在规范字符串中找不到任何合法协议，或者无法解析字符串。
            this.jTextFieldAddress.setText("错误的地址");
            return;
        } catch (IOException ex) {
            this.jTextFieldAddress.setText(ex.getMessage());
            return;
        }
    }

    public static void main(String[] args) {
        new GetHttp().setVisible(true);
    }
}
